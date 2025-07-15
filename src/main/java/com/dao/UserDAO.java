package com.dao;

import com.connection.DBconnection;
import com.model.UserModel;

import java.sql.*;

public class UserDAO {
    Connection conn = DBconnection.getConnection();
    public boolean checkExistingUsername(String username) throws SQLException {
        String sql = "select 1 from users where username = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExistingEmail(String email) throws SQLException {
        String sql = "select 1 from users where email = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExistingMobile(long mobile) throws SQLException {
        String sql = "select 1 from users where mobile = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, mobile);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        }
        return false;
    }

    public boolean registerUser(UserModel user) throws Exception {
        String sql = "INSERT INTO users (first_name, last_name, gender, dob, username, mobile, email, password, address, city, state, zip) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getGender());
            ps.setDate(4, (Date) user.getDob());
            ps.setString(5, user.getUsername());
            ps.setLong(6, user.getMobile());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getPassword());
            ps.setString(9, user.getAddress());
            ps.setString(10, user.getCity());
            ps.setString(11, user.getState());
            ps.setInt(12, user.getZip());

            return ps.executeUpdate() > 0;
        }
    }

    public UserModel loginUser(UserModel user) throws Exception {
        String sql = "select * from users where email = ? and password = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setGender(rs.getString("gender"));
                user.setDob(rs.getDate("dob"));
                user.setUsername(rs.getString("username"));
                user.setMobile(rs.getLong("mobile"));
                user.setAddress(rs.getString("address"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setZip(rs.getInt("zip"));
                return user;
            }
        }
        return null;
    }


}
