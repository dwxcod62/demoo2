<%-- 
    Document   : a
    Created on : Dec 12, 2023, 10:49:49 PM
    Author     : ADMIN
--%>

<%@page import="dto.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Account user = (Account) session.getAttribute("USER"); %>
        <h1><%= user.getFullName() %> </h1>
    </body>
</html>
