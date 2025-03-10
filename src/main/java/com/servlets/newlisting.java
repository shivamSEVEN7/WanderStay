package com.servlets;

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

@WebServlet("/listing")
public class newlisting extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String image_url = req.getParameter("image");
        String price = req.getParameter("price");
        String location = req.getParameter("location");
        String country = req.getParameter("country");
        String id = (String) session.getAttribute("user_id");
        System.out.println(id);
       try{
           Connection con = DBconnection.getConnection();
           System.out.println("Connected to database");
           PreparedStatement ps = con.prepareStatement("INSERT INTO listings(title, description, image_url,price, location, country, user_id) VALUES (?,?,?,?,?,?,?)");
           ps.setString(1,title);
           ps.setString(2,description);
           ps.setString(3,image_url);
           ps.setString(4,price);
           ps.setString(5,location);
           ps.setString(6,country);
           ps.setString(7,id);
           int col = ps.executeUpdate();
           System.out.println("COL is "+ col);
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
}
