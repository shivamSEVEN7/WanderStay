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
    <div class="form" >
        <form action="http://localhost:8080/listings/listing?_method=PATCH" method="post" id="form">
            <div class="formHeading"><h2>Edit Listing</h2></div>
            <div class="title">
                <label for="title">Title : </label>
                <input type="text" name="listing[title]" id="title" value="listing.title">
                <div class="error"></div>
            </div>
            <div class="description">
                <label for="description">Description</label>

                <textarea name="listing[description]" id="description" cols="82" rows="4">listing.description</textarea>
                <div class="error"></div>
            </div>
            <div class="image">
                <label for="image">Image URL : </label>

                <input type="text" name="listing[image]" id="image" value="listing.image">
                <div class="error"></div>
            </div>
            <div class="price">
                <label for="price">Price : </label>

                <input type="text" name="listing[price]" id="price" value="100">
                <div class="error"></div>
            </div>
            <div class="loaction">
                <label for="location">Location</label>

                <input type="text" name="listing[location]" id="location" value="location">
                <div class="error"></div>
            </div>

            <div class="country">
                <label for="country">Country</label>

                <input type="text" name="listing[country]" id="country" value="listing.country">
                <div class="error"></div>
            </div>
            <br>
            <div class="submit">
                <button>Submit</button>
            </div>
           </form>
    </div>
</div>
<script src="/js/script.js"></script>
<%@include file="includes/footer.jsp"%>
</body>
</html>
