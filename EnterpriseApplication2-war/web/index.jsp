<%-- 
    Document   : index
    Created on : Feb 21, 2012, 1:22:33 PM
    Author     : ablanco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="hellomsg" method="POST" >
            <label title="Name:" >
                <input id="person" name="person"  />
            </label>
            <input type="submit" value="submit" />
            <input type="reset" value="reset" />
        </form>
    </body>
</html>
