<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/style.css" />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
            integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:ital,wght@0,200..800;1,200..800&display=swap"
            rel="stylesheet"
    />
    <title>Document</title>
</head>
<body>
<%@include file="includes/navbar.jsp"%>
<div class="container">
    <div class="outerbox">
        <div class="boxtitle">
            <h2>listing.title</h2>
        </div>
        <div class="showimage">
            <img src="https://images.unsplash.com/photo-1552733407-5d5c46c3bb3b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fHRyYXZlbHxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=800&q=60" alt="">
        </div>
        <div class="mboxtitle">
            <h2>listing.title</h2>
        </div>
        <div class="location">listing.location, listing.country</div>
        <div class="price">&#8377 listingPrice</div>
        <div class="description">listing.description</div>
        <div class="edit"><a href="http://localhost:8080/listings/"><button>Edit This Listing</button></a>
        </div>

        <div class="delete">
            <form action="http://localhost:8080/listings/?_method=DELETE" method="post">
                <button>Delete this Listing</button>
            </form>
        </div>
        <hr>
        <div class="reviewBox">
            <h4>Leave a Review</h4>
            <form action="/listings" method="post" id="form2">
                <div class="rating">
                    <label for="review[rating]">Rating</label>
                    <br>
                    <input type="range" name="review[rating]" class="form-range" min="0" max="5" id="customRange2">

                </div>
                <br>
                <div class="comment">
                    <label for="review[comment]">Comment</label>
                    <br>
                    <textarea id="rcomment" cols="90" rows="6" name="review[comment]"></textarea>
                    <div class="error"></div>
                    <br>
                </div>
                <div class="submit">
                    <button type="submit">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="includes/footer.jsp"%>

</body>
</html>
