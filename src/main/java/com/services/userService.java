package com.services;

import com.dao.UserDAO;
import com.model.UserModel;

import java.sql.SQLException;

public class userService {
    UserDAO dao = new UserDAO();
    public void existingUserCheck(UserModel user) throws SQLException {
        if(dao.checkExistingEmail(user.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }
        if(dao.checkExistingMobile(user.getMobile())){
            throw new IllegalArgumentException("Mobile already exists");
        }
        if(dao.checkExistingUsername(user.getUsername())){
            throw new IllegalArgumentException("Username already exists");
        }
    }
    public boolean register(UserModel user) {
        try{
            existingUserCheck(user);
            if(dao.registerUser(user)){
                return true;
            }
        }
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some other exception occurred");
        }
        return false;
    }

    public UserModel login(UserModel user) throws Exception {
        user = dao.loginUser(user);
       if(user==null){
           throw new IllegalArgumentException("Invalid username or password");
       }
       return user;
    }
}
