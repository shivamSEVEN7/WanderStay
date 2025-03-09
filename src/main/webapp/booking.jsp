<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.time.LocalDate"%>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@page import="java.text.NumberFormat" %>
<%@page import="java.util.Locale" %>
<%@ page import="java.util.Currency" %>
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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0&icon_names=person" />
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
<%
    LocalDate checkin = (LocalDate) request.getAttribute("checkin");
    LocalDate checkout = (LocalDate) request.getAttribute("checkout");
    long totalDays = ChronoUnit.DAYS.between(checkin, checkout);
    int price = (int) request.getAttribute("price");
    long totalPrice = price * totalDays;
    double serviceCharges = 0.14 * totalPrice;
    double totalAmount = totalPrice + serviceCharges;

    Currency inr = Currency.getInstance("INR");
    Locale inrLocale = new Locale("hi", "IN");
    NumberFormat inrCurrencyFormat = NumberFormat.getCurrencyInstance(inrLocale);
    inrCurrencyFormat.setCurrency(inr);

%>
<div class="bookingBox">
    <div class="bookingDetails">
        <div class="boxTitle">Booking Details</div>
        <div class="innerBookingDetail">
            <div class="innerBookingImage">
                <img src= ${imageUrl} alt="">
            </div>
            <div class="innerBookingTitle">
                <div class="ibTitle">
                    <b> ${listingTitle} </b>
                </div>
                <div class="innerHostName">
                    Host : @${host}
                </div>
            </div>
        </div>
        <hr>
        <div class="tripDetails">
            <div class="fxBox"><div><b>Dates </b></div>
                <div>
                    <% if (checkin.getMonth()==checkout.getMonth()){%>
                        <%=checkin.getDayOfMonth()%> - <%=checkout.getDayOfMonth()%> <span class="titleCase"><%=(checkin.getMonth()).toString().toLowerCase()%></span>
                    <%} else{%>
                    <%=checkin.getDayOfMonth()%> <span class="titleCase"><%=(checkin.getMonth()).toString().toLowerCase()%></span> - <%=checkout.getDayOfMonth()%> <span class="titleCase"><%=(checkout.getMonth()).toString().toLowerCase()%></span>
                    <%}%>

                </div>
            </div>
            <div class="fxBox"><div><b>Guests </b> </div>${guests} Guest</div>
        </div>
    </div>

    <div class="priceDetails">
        <div class="boxTitle">Price Details</div>
        <div class="fxBox"><div><%=inrCurrencyFormat.format(price)%> x <%=totalDays%> nights &nbsp;&nbsp; </div> <div><%=inrCurrencyFormat.format(totalPrice)%></div></div>
        <div class="fxBox"><div>Service fee </div> <div><%=inrCurrencyFormat.format(serviceCharges)%></div></div>
        <hr>
        <div class="fxBox"><div><b>Total (INR) &nbsp; </b> </div> <div><%=inrCurrencyFormat.format(totalAmount)%></div></div>
    </div>
    <div id="bookingBtn">
        <form action="book" method="post">
            <input type="hidden" name="totalAmount" value = <%=totalAmount%> >
            <input type="hidden" name="checkin" value = <%=checkin%> >
            <input type="hidden" name="checkout" value = <%=checkout%> >
            <input type="hidden" name="userID" value = ${userId} >
            <input type="hidden" name="listingID" value = ${listingId} >
            <input type="hidden" name="listingTitle" value = "${listingTitle}" >

            <button id="confirmBtn" type="submit">Confirm</button>
        </form></div>
</div>
<%@include file="includes/footer.jsp"%>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"
></script>
</body>
</html>
