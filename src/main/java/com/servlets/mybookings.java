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

@WebServlet("/mylistings")
public class mybookings extends HttpServlet {

}
