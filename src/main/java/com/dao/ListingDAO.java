package com.dao;

import com.connection.DBconnection;
import com.model.ListingModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListingDAO {
    private ListingModel extractListing(ResultSet rs) throws SQLException {
        ListingModel lm = new ListingModel();
            lm.setListingId(rs.getInt("listing_id"));
            lm.setTitle(rs.getString("title"));
            lm.setDescription(rs.getString("description"));
            lm.setImageUrl(rs.getString("image_url"));
            lm.setPrice(rs.getInt("price"));
            lm.setLocation(rs.getString("location"));
            lm.setCountry(rs.getString("country"));
        return lm;
    }
    public List<ListingModel> getAllListings(){
        List<ListingModel> allListings = new ArrayList<ListingModel>();
        try(Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from listings");
            ){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                allListings.add(extractListing(rs));
            }
        }
        catch(Exception e){}
        return allListings;
    }
    public boolean addNewListing(ListingModel listing){
        try(Connection con = DBconnection.getConnection();
            PreparedStatement ps  = con.prepareStatement("Insert into listings(title, description, image_url,price, location, country, user_id) values(?,?,?,?,?,?,?)");
        ){
            ps.setString(1, listing.getTitle());
            ps.setString(2, listing.getDescription());
            ps.setString(3, listing.getImageUrl());
            ps.setInt(4, listing.getPrice());
            ps.setString(5, listing.getLocation());
            ps.setString(6, listing.getCountry());
            ps.setInt(7, 1);
            int rows = ps.executeUpdate();
            if(rows > 0){
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
