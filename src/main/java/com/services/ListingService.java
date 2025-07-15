package com.services;

import com.dao.ListingDAO;
import com.model.ListingModel;

import java.util.List;

public class ListingService {
    ListingDAO listingDAO = new ListingDAO();
    public List<ListingModel> getAllListings(){
        return listingDAO.getAllListings();
    }

    public boolean addListing(ListingModel listing){
        return listingDAO.addNewListing(listing);
    }

}
