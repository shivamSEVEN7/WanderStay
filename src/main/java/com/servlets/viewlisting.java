package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import com.connection.DBconnection;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/viewlisting")
public class viewlisting extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{

            Connection con = DBconnection.getConnection();
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
