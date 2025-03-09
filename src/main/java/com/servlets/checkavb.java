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
import java.sql.Date;
import java.time.LocalDate;
@WebServlet("/checkavb")
public class checkavb extends HttpServlet {
    String url ="jdbc:mysql://localhost:3306/wanderstay";
    String user = "root";
    String pass = "Shivam@123";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("user_id") == null){
            resp.sendRedirect("login.jsp");
        }
        else{
            Date checkin = Date.valueOf(req.getParameter("checkin"));
            Date checkout = Date.valueOf(req.getParameter("checkout"));
            LocalDate d1 = checkin.toLocalDate();
            LocalDate d2 = checkout.toLocalDate();
            System.out.println("Month is " + d1.getMonth());
            System.out.println(checkin);
            System.out.println(checkout);
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url,user,pass);
                PreparedStatement ps = con.prepareStatement("SELECT * FROM bookings WHERE ((checkin <= ? AND checkout > ?) OR (checkin BETWEEN ? AND ?)) AND listing_id = ?;");
                PreparedStatement ps2 = con.prepareStatement("SELECT title, user_id, price, image_url FROM listings WHERE listing_id = ?;");
                ps.setDate(1, checkin);
                ps.setDate(2, checkout);
                ps.setDate(3, checkin);
                ps.setDate(4, checkout);
                ps.setString(5, session.getAttribute("listing_id").toString());
                ps2.setString(1, session.getAttribute("listing_id").toString());
                ResultSet rs = ps.executeQuery();
                ResultSet rs2 = ps2.executeQuery();
                rs2.next();
                PreparedStatement ps3 = con.prepareStatement("SELECT username FROM users WHERE user_id = ?;");
                ps3.setInt(1, rs2.getInt("user_id"));
                ResultSet rs3 = ps3.executeQuery();
                rs3.next();

                if(rs.next()){
                    System.out.println("Not Available");
                }
                else{
                    System.out.println("Available");
                    req.setAttribute("checkin", d1);
                    req.setAttribute("checkout", d2);
                    req.setAttribute("host", rs3.getString("username"));
                    req.setAttribute("guests", req.getParameter("guests"));
                    req.setAttribute("price", rs2.getInt("price"));
                    req.setAttribute("listingTitle", rs2.getString("title"));
                    req.setAttribute("imageUrl", rs2.getString("image_url"));
                    req.setAttribute("userId", rs2.getInt("user_id"));
                    req.setAttribute("listingId", session.getAttribute("listing_id"));
                    RequestDispatcher bookingDispatcher = req.getRequestDispatcher("booking.jsp");
                    bookingDispatcher.forward(req, resp);
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
