
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Event</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>


        <div class="eventForm">
            <form action = "EventCreateServlet" method = "post">
                სახელი: <input type="text" name="name"> <br>   
                აღწერა: <input type="text" name="desc"> <br>   
                თარიღი:  <input type="date" name="date"> <br> 
                ფასი:  <input type="number" name="price"> <br> 
                კატეგორია: <input type="text" name="category"> <br> 
                ტიპი: <input type="text" name="type"> <br> 
                ადგილები: <input type="number" name="places"> <br> 
                <input type="submit" value="შექმნა">
            </form>
        </div>

    </body>
</html>
