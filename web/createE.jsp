
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
                Name: <input type="text" name="name"> <br>   
                Description: <input type="text" name="desc"> <br>   
                Date:  <input type="date" name="date"> <br> 
                Price:  <input type="number" name="price"> <br> 
                Category: <input type="text" name="category"> <br> 
                Type: <input type="text" name="type"> <br> 
                Places: <input type="number" name="places"> <br> 
                <input type="submit" value="Create">
            </form>
        </div>
      <a href="index.jsp" class="btnform">
                        <div class="diForm"> 
                            <h5>Homepage</h5> 
                        </div> 
    </body>
</html>
