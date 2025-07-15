package com.controller;

import com.model.UserModel;
import com.services.userService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    userService userService = new userService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel user = new UserModel();
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        System.out.println("email is " + user.getEmail() + " password is " + user.getPassword());
        try{
            user = userService.login(user);
            System.out.println("Login Success");
            System.out.println("username is " + user.getUsername());
        }
        catch(IllegalArgumentException e){
            System.out.println("invalid username or pass");
        }
        catch (Exception e){
            System.out.println("Generic Error Occured");
        }

    }
}
