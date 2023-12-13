/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dao.AccountDao;
import dto.Account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String key = request.getParameter("key-input");
        String url = "loginPage";
        AccountDao accDao = new AccountDao();
        Account acc = null;

        try{
            acc = accDao.getAccountByKey(key);
            if (acc != null){
                url = "sussces";
                HttpSession session = request.getSession(true);
                if (session != null) {
                    session.setAttribute("USER", acc);
                    session.setAttribute("CURRENT_PAGE", "dashboard");
                }
            }
            
        } catch (Exception e){
            
        } finally {
            if (acc != null){
                response.sendRedirect(url);
            } else {
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
        
    }

}
