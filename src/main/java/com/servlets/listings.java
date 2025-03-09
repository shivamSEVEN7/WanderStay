package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/listings")
public class listings extends HttpServlet {
    String user = "root";
    String pass = "Shivam@123";
    String url = "jdbc:mysql://localhost:3306/wanderstay";
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher indexDispatcher = req.getRequestDispatcher("listings.jsp");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            int page=1;
            if(req.getParameter("page")!=null){
                page = Integer.parseInt(req.getParameter("page"));
            }
            PreparedStatement ps = con.prepareStatement("select count(*) as row_count from listings");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt("row_count");
            req.setAttribute("count", count);
            PreparedStatement ps2 = con.prepareStatement("SELECT * FROM listings LIMIT 9 OFFSET ?");
            ps2.setInt(1,(9*(page-1)));
            ResultSet rs2 = ps2.executeQuery();
            req.setAttribute("result", rs2);
        }
        catch(Exception e){
            System.out.println("Database Error");
            System.out.println(e);
        }
        indexDispatcher.forward(req, resp);
    }
}
