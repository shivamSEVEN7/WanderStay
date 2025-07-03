package com.servlets;

import com.mysql.cj.Session;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.connection.DBconnection;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/mylistings")
public class mylistings extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Connection con = DBconnection.getConnection();
        RequestDispatcher rd = req.getRequestDispatcher("mylistings.jsp");
        try{
            String user_id = session.getAttribute("user_id").toString();
            PreparedStatement ps = con.prepareStatement("SELECT * from listings WHERE user_id=?");
            ps.setString(1, user_id);
            ResultSet rs = ps.executeQuery();
            req.setAttribute("listings", rs);
            rd.forward(req, resp);

        }
        catch(Exception e){
            System.out.println("Error in Retrieving your listings");
            System.out.println(e.getMessage());
        }

    }
}
