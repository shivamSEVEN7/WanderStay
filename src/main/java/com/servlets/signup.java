package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.io.IOException;
import com.connection.DBconnection;
import java.sql.Connection;

import java.sql.Date;
//@WebServlet("/signup")
public class signup extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hello");
        String firstName = req.getParameter("firstname"); 
        String lastName = req.getParameter("lastname");
        String gender = req.getParameter("gender");
        String dateString = req.getParameter("dob");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String password = req.getParameter("password");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String zip = req.getParameter("zip");
        Date dob = Date.valueOf(dateString);
        System.out.println(firstName + " " + lastName + " " + gender + " " + dob + " " + username + " " + email + " " + mobile + " " + password + " " + address + " " + city + " " + state + " " + zip);
        try{
            Connection con = DBconnection.getConnection();
            System.out.println("Connected to database");
            PreparedStatement stmnt = con.prepareStatement("insert into users (first_name, last_name, gender, dob, username, mobile, email, password, address, city, state, zip) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            stmnt.setString(1,firstName);
            stmnt.setString(2,lastName);
            stmnt.setString(3,gender);
            stmnt.setDate(4,dob);
            stmnt.setString(5,username);
            stmnt.setString(6,mobile);
            stmnt.setString(7,email);
            stmnt.setString(8,password);
            stmnt.setString(9,address);
            stmnt.setString(10,city);
            stmnt.setString(11,state);
            stmnt.setString(12,zip);
            int col = stmnt.executeUpdate();
            resp.sendRedirect("/wanderstay/login.jsp");
        }
        catch(Exception e){
            System.out.println("error");
            System.out.println(e);
        }
    }
}
