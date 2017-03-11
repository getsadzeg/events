

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
          <div class="eventForm">
              <form>
                  სახელი: <input type="text" name="desc" value="<%=request.getAttribute("name")%>"> <br>   
                  აღწერა: <input type="text" name="name" value="<%=request.getAttribute("desc")%>"> <br>   
                  თარიღი:  <input type="date" name="date" value="<%=request.getAttribute("date")%>"> <br> 
                  ფასი:  <input type="number" name="price" value="<%=request.getAttribute("price")%>" > <br> 
                  კატეგორია: <input type="text" name="categ" value="<%=request.getAttribute("categ")%>"> <br> 
                  ტიპი: <input type="text" name="type" value="<%=request.getAttribute("type")%>"> <br> 
                  ადგილები: <input type="number" name="places" value="<%=request.getAttribute("places")%>"> <br> 
                  <input type="button" value="შეცვლა">
              </form>
          </div>
        
    </body>
</html>
