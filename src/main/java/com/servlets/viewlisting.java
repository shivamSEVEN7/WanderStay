package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/viewlisting")
public class viewlisting extends HttpServlet {
    String user = "root";
    String pass = "Shivam@123";
    String url = "jdbc:mysql://localhost:3306/wanderstay";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            HttpSession session = req.getSession();
            String listingid = req.getParameter("id");
            session.setAttribute("listing_id", listingid);
            RequestDispatcher rd = req.getRequestDispatcher("show.jsp");
            System.out.println("ID is "+ listingid);
            PreparedStatement ps = con.prepareStatement("select * from listings where listing_id = ? ");
            ps.setString(1, listingid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            req.setAttribute("result", rs);
            rd.forward(req, resp);
        }
        catch(Exception e){
            System.out.println(e);
        }


    }
}
