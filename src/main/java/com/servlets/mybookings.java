package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.connection.DBconnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/mylistings")
public class mybookings extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = DBconnection.getConnection();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * from listings");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Here Are listings Ids");
                System.out.println(rs.getString("listing_id"));
            }
        }
        catch(Exception e){
            System.out.println("Error in Retrieving your listings");
            System.out.println(e.getMessage());
        }

    }
}
