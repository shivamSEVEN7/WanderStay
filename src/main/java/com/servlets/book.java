package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.connection.DBconnection;
import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;


@WebServlet("/book")
public class book extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String totalAmount = req.getParameter("totalAmount");
        String checkIn = req.getParameter("checkin");
        String checkOut = req.getParameter("checkout");
        String userId = req.getParameter("userID");
        String listingId = req.getParameter("listingID");
        String listingTitle = req.getParameter("listingTitle");
        System.out.println("Booking Confirmed");
        System.out.println("Total Amount is " + totalAmount);
        System.out.println("Checkin is " + checkIn);
        System.out.println("Checkout is " + checkOut);
        System.out.println("UserId is " + userId);
        System.out.println("ListingId is " + listingId);
        System.out.println("ListingsTitle is " + listingTitle);
        try{
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO bookings(total_amount, checkin, checkout, user_id, listing_id) VALUES (?,?,?,?,?);");
            ps.setString(1,totalAmount);
            ps.setString(2,checkIn);
            ps.setString(3,checkOut);
            ps.setString(4,userId);
            ps.setString(5,listingId);
            int result = ps.executeUpdate();
            if(result == 1){
                System.out.println("Booking Successful and i is " + result);
                RequestDispatcher rd = req.getRequestDispatcher("/confirmbooking");
                rd.forward(req,resp);
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
