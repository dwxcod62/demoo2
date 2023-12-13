package dao;

import dto.Account;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import utils.DButils;

public class AccountDao {
    
    public Account getAccountByKey(String key){
        Connection cn = null;
        PreparedStatement pst = null;
        Account acc = null;
        
        try{
            cn = DButils.makeConnection();
            if (cn != null){
                String sql = "select * from user_information where key = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, key);

                ResultSet rs = pst.executeQuery();
                if (rs != null && rs.next()){
                    
                    int userId = rs.getInt("userid");
                    String fullname = rs.getString("fullname");
                    int role = rs.getInt("role");
                    
                    acc = new Account(userId, fullname, role);
                }
            }
            
        } catch (Exception e){
            System.out.println(e);
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return acc;
    }
}
