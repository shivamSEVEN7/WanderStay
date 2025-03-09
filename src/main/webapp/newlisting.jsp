
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
<%if(session.getAttribute("user_id")==null){
    response.sendRedirect("login.jsp");
}%>
<%@include file="includes/navbar.jsp"%>

<div class="listing-form">
    <form method="post" action="listing" id="form">
        <div class="title">
            <label for="title">Title : </label>
            <input type="text" name="title" id="title" />
            <div class="error"></div>
        </div>
        <div class="description">
            <label for="description">Description : </label>
            <textarea
                    name="description"
                    id="description"
                    cols="76"
                    rows="7"
            ></textarea>
            <div class="error"></div>
        </div>
        <div class="image">
            <label for="image">Image URL : </label>

            <input type="text" name="image" id="image" />
            <div class="error"></div>
        </div>
        <div class="price">
            <label for="price">Price : </label>
            <input type="number" name="price" id="price" />
            <div class="error"></div>
        </div>
        <div class="loaction">
            <label for="location">Location</label>
            <input type="text" name="location" id="location" />
            <div class="error"></div>
        </div>

        <div class="country">
            <label for="country">Country</label>
            <input type="text" name="country" id="country" />
            <div class="error"></div>
        </div>
        <br />
        <div class="submit">
            <button type="submit">Submit</button>
        </div>
    </form>
</div>
<script src="js/script.js"></script>
</body>
</html>
