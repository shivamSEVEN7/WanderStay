package com.controller;

import com.model.ListingModel;
import com.services.ListingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/listings")
public class Listings extends HttpServlet {
    ListingService listingService = new ListingService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("listings", listingService.getAllListings());
            req.getRequestDispatcher("listings.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Adding New Listing");
        ListingModel listing = new ListingModel();
        listing.setTitle(req.getParameter("title"));
        listing.setDescription(req.getParameter("description"));
        listing.setImageUrl(req.getParameter("imageUrl"));
        listing.setPrice(Integer.parseInt(req.getParameter("price")));
        listing.setLocation(req.getParameter("location"));
        listing.setCountry(req.getParameter("country"));
        if(listingService.addListing(listing)){
            System.out.println("listing added");
        }
        else{
            System.out.println("listing not added");
        }

    }
}
