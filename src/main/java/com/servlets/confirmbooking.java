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

@WebServlet("/confirmbooking")
public class confirmbooking extends HttpServlet {
    String url ="jdbc:mysql://localhost:3306/wanderstay";
    String user = "root";
    String pass = "Shivam@123";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,pass);
            PreparedStatement ps = con.prepareStatement("select booking_id from bookings where listing_id = ? and checkin =?");
            ps.setString(1,req.getParameter("listingID"));
            ps.setString(2,req.getParameter("checkin"));
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println("Booking ID is " + rs.getString("booking_id"));
            req.setAttribute("bookingID",rs.getString("booking_id"));
            req.setAttribute("listingTitle",req.getParameter("listingTitle"));
        }
        catch(Exception e){
            System.out.println("Error Occured " + e.getMessage());
        }
        System.out.println("Confirmed Booking");
        RequestDispatcher rd = req.getRequestDispatcher("confirmbooking.jsp");
        rd.forward(req, resp);


    }
}
