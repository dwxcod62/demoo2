
package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButils {
    public static Connection makeConnection() throws Exception {
        Connection cn = null;
        String url = "jdbc:postgresql://ep-snowy-surf-88947670.us-east-2.aws.neon.tech/project-manager?user=dwxcod62&password=SbH6gDQtx1IG&sslmode=require";
        Class.forName("org.postgresql.Driver");
        cn = DriverManager.getConnection(url);
        return cn;
    }
    
//    public static void main(String[] args) {
//        Connection cn = null;
//        PreparedStatement pst = null;
//        Account acc = null;
//        try{
//            cn = makeConnection();
//            if (cn != null){
//                String sql = "select * from user_information where key = ?";
//                pst = cn.prepareStatement(sql);
//                pst.setString(1, "nad14");
//
//                ResultSet rs = pst.executeQuery();
//                if (rs != null && rs.next()){
//                    
//                    
//                    int userId = rs.getInt("userid");
//                    String fullname = rs.getString("fullname");
//                    int role = rs.getInt("role");
//                    
//                    acc = new Account(userId, fullname, role);
//                }
//            }
//            
//        } catch (Exception e){
//            System.out.println(e);
//        } finally {
//            if (pst != null) {
//                try {
//                    pst.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if (cn != null) {
//                try {
//                    cn.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }
}
