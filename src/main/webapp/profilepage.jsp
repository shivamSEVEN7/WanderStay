<%--
  Created by IntelliJ IDEA.
  User: shiva
  Date: 30-12-2024
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous"
  />
  <link rel="stylesheet" href="css/style.css">
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
  if(session.getAttribute("user_id") == null) {
    response.sendRedirect("login.jsp");
  }
%>
<section class="h-100 gradient-custom-2">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center">
      <div class="col col-lg-9 col-xl-8">
        <div class="card">
          <div class="rounded-top text-white d-flex flex-row" style="background-color: #000; height:200px;">
            <div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-profiles/avatar-1.webp"
                   alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"
                   style="width: 150px; z-index: 1">
              <button  type="button" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-dark text-body" data-mdb-ripple-color="dark" style="z-index: 1;">
                Edit profile
              </button>
            </div>
            <div class="ms-3" style="margin-top: 130px;">
              <h5><%=session.getAttribute("first_name")%> <%=session.getAttribute("last_name")%></h5>
              <p>@<%=session.getAttribute("user_name")%></p>
            </div>
          </div>
          <div class="p-4 text-black bg-body-tertiary">
            <div class="d-flex justify-content-end text-center py-1 text-body">
              <div>
                <p class="mb-1 h5">0</p>
                <p class="small text-muted mb-0">Bookings</p>
              </div>
              <div class="px-3">
                <p class="mb-1 h5">0</p>
                <p class="small text-muted mb-0">Listings</p>
              </div>
              <div>
                <p class="mb-1 h5">0</p>
                <p class="small text-muted mb-0">Reviews</p>
              </div>
            </div>
          </div>
          <ul class="list-group list-group-horizontal mt-1">
            <a class="list-group-item" href="newlisting.jsp"><li style="list-style: none">New Listing</li> </a>
            <a class="list-group-item"><li style="list-style: none">My Listings</li> </a>
            <a class="list-group-item"><li style="list-style: none">My Bookings</li> </a>
            <a class="list-group-item"><li style="list-style: none">My Reviews</li> </a>
          </ul>
          <div class="card-body p-4 text-black">
            <div class="mb-5  text-body">
              <p class="lead fw-normal mb-1">Personal Details</p>
              <div class="p-4 bg-body-tertiary">
                <p class="font-italic mb-1"><b>Contact Number</b> : <%=session.getAttribute("mobile")%></p>
                <hr>
                <p class="font-italic mb-1"><b>Email Id</b> : <%=session.getAttribute("email")%></p>
                <hr>
                <p class="font-italic mb-0"><b>Address</b> : <%=session.getAttribute("address")%></p>
                <hr>
                <p class="font-italic mb-0"><b>Date Of Birth</b> : <%=session.getAttribute("dob")%></p>
                <hr>
                <p class="font-italic mb-0"><b>Gender</b> : <%=session.getAttribute("gender")%></p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script src="js/script.js" ></script>
</body>
</html>
