package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import com.connection.DBconnection;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class login extends HttpServlet {
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        RequestDispatcher loginDispatcher = req.getRequestDispatcher("/login.jsp?error=true");
        try{
            Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from users where email = ? and password = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Correct");
                HttpSession session = req.getSession();
                session.setAttribute("user_id", rs.getString("user_id"));
                session.setAttribute("user_name", rs.getString("username"));
                session.setAttribute("email", rs.getString("email"));
                session.setAttribute("first_name", rs.getString("first_name"));
                session.setAttribute("last_name", rs.getString("last_name"));
                session.setAttribute("address", rs.getString("address"));
                session.setAttribute("mobile", rs.getString("mobile"));
                session.setAttribute("gender", rs.getString("gender"));
                session.setAttribute("dob", rs.getString("dob"));
                resp.sendRedirect("profilepage.jsp");
            }
            else{
                System.out.println("wrong");
                loginDispatcher.forward(req, resp);
            }
        }
        catch(Exception e){
            System.out.println("error");
            System.out.println(e);
        }

    }
}
