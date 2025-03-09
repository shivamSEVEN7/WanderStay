<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/style.css"/>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
            integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
            crossorigin="anonymous"
            referrerpolicy="no-referrer"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:ital,wght@0,200..800;1,200..800&display=swap"
            rel="stylesheet"
    />
    <title>Document</title>
</head>
<%@include file="includes/navbar.jsp" %>
<body>
<%
    ResultSet listing = (ResultSet) request.getAttribute("result");
    LocalDate today = LocalDate.now();
    Integer avlError = (Integer) request.getAttribute("avlError");

%>
<div class="container">
    <div class="outerbox">
        <div class="boxtitle">
            <h2><%=listing.getString("title")%>
            </h2>
        </div>
        <div class="showimage">
            <img src="<%=listing.getString("image_url")%>" alt="">
        </div>
        <div class="mboxtitle">
            <h2>listing.title</h2>
        </div>
        <div class="location"><%=listing.getString("location")%>, <%=listing.getString("country")%>
        </div>
        <div class="price">&#8377 <%=listing.getString("price")%>
        </div>
        <hr>
        <div class="ownerDetails">
            <div class="ownerImage"><img
                    src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-profiles/avatar-1.webp" alt="">
            </div>
            <div class="ownerName">Listed By : Shivam</div>
        </div>
        <hr>
        <div class="description">
            <%=listing.getString("description")%>
        </div>
        <div class="availabilityForm">
            <%if(avlError!=null){ %>
                <p>NOT AVAILABLE</p>
            <%};%>
            <form action="checkavb" method="post">
                <div class="inputDate">
                    <label for="checkin">Check-In  </label>
                    <input type="date" id="checkin" name="checkin" min="<%=today%>">
                </div>
                <div class="inputDate">
                    <label for="checkout">Checkout  </label>
                    <input type="date" id="checkout" name="checkout" min="<%=today%>">
                </div>
                <div class="inputDate">
                    <label for="guests">Guests  </label>
                    <input type="number" id="guests" name="guests" min="1" max="8">
                </div>
                <button id="availabilityBtn" type="submit">Check Availability</button>
            </form>
        </div>
    </div>
</div>
<%@include file="includes/footer.jsp" %>
</body>
</html>
