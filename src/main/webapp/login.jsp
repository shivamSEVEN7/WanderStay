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
  <% String error = request.getParameter("error"); %>
  <% if(error!=null){ %>
    <div class="alert alert-primary" role="alert"> Wrong Credentials </div>
  <%}%>
  <div class="container d-flex justify-content-center align-items-center">
    <div class="card p-4 shadow" style="width: 20rem;">
      <h4 class="text-center mb-4">Login</h4>
      <form action="login" method="post">
        <div class="mb-3">
          <label for="email" class="form-label">Email address</label>
          <input type="email" name="email" class="form-control" id="email" placeholder="Enter your email" required>
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" name="password" class="form-control" id="password" placeholder="Enter your password" required>
        </div>
        <button type="submit" class="btn btn-primary w-100">Login</button>
      </form>
      <p class="text-center mb-0">Don't have an account? <a href="signup.jsp">Register</a></p>
    </div>
  </div>
  <%@include file="includes/footer.jsp"%>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>
