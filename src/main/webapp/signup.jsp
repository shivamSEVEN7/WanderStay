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
  <link rel="stylesheet" href="css/style2.css"/>
  <title>WanderStay - Sign Up</title>
</head>
<body>
<% String error = (String) request.getAttribute("error"); %>
<% if (error != null) { %>
<div style="color:red;"><%= error %></div>
<% } %>
  <div id="signup-form">
    <form class="row g-3" action="signup" method="post">
      <div class="col-md-6">
        <label for="inputFirstName" class="form-label">First Name</label>
        <input name="firstname" type="text" class="form-control" id="inputFirstName">
      </div>
      <div class="col-md-6">
        <label for="inputLastName" class="form-label">Last Name</label>
        <input name="lastname" type="text" class="form-control" id="inputLastName">
      </div>
      <div class="col-md-6">
        <label for="inputGender" class="form-label">Gender</label>
        <select name="gender" id="inputGender" class="form-select">
          <option>Male</option>
          <option>Female</option>
        </select>
      </div>
      <div class="col-md-6">
        <label for="dob" class="form-label">Date Of Birth</label>
        <input name="dob" type="date" class="form-control" id="dob" placeholder="YYYY-MM-DD" required>
      </div>

      <div class="col-md-6">
        <label for="inputUserName" class="form-label">Username</label>
        <input name="username" type="text" class="form-control" id="inputUserName">
      </div>
      <div class="col-md-6">
        <label for="inputPhone" class="form-label">Mobile No.</label>
        <input name="mobile" type="number" class="form-control" id="inputPhone">
      </div>
      <div class="col-md-6">
        <label for="inputEmail4" class="form-label">Email</label>
        <input name="email" type="email" class="form-control" id="inputEmail4">
      </div>
      <div class="col-md-6">
        <label for="inputPassword4" class="form-label">Password</label>
        <input name="password" type="password" class="form-control" id="inputPassword4">
      </div>
      <div class="col-12">
        <label for="inputAddress" class="form-label">Address</label>
        <input name="address" type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
      </div>
      <div class="col-md-6">
        <label for="inputCity" class="form-label">City</label>
        <input name="city" type="text" class="form-control" id="inputCity">
      </div>
      <div class="col-md-4">
        <label for="inputState" class="form-label">State</label>
        <select name="state" id="inputState" class="form-select">
          <option selected>Bihar</option>
          <option>Delhi</option>
        </select>
      </div>
      <div class="col-md-2">
        <label for="inputZip" class="form-label">Zip</label>
        <input name="zip" type="text" class="form-control" id="inputZip">
      </div>
      <div class="col-12">
        <button type="submit" class="btn btn-primary">Sign in</button>
      </div>
    </form>
  </div>
  <div class="login-link">
    <p>Alredy have an account? <a href="login.jsp">Login</a></p>
  </div>


<script src="js/script.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>