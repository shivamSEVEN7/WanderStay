package com.controller;

import com.dao.UserDAO;
import com.model.UserModel;
import com.services.userService;
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
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    userService us = new userService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello World");
        resp.sendRedirect("signup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel user = new UserModel();
        user.setFirstName(req.getParameter("firstname"));
        user.setLastName(req.getParameter("lastname"));
        user.setGender(req.getParameter("gender"));
        user.setDob(java.sql.Date.valueOf(req.getParameter("dob")));
        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        user.setMobile(Long.parseLong(req.getParameter("mobile")));
        user.setPassword(req.getParameter("password"));
        user.setAddress(req.getParameter("address"));
        user.setCity(req.getParameter("city"));
        user.setState(req.getParameter("state"));
        user.setZip(Integer.parseInt(req.getParameter("zip")));
        try {
            us.register(user);
        }
        catch (IllegalArgumentException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
            System.out.println("This message is from servlet");
        }


    }
}
