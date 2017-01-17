<%-- 
    Document   : add
    Created on : Jan 14, 2016, 7:32:56 PM
    Author     : Bob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
        body  {
            background: url(zeppelin.png) no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            color: #e9f018;
        }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Song Addition</title>
    </head>
    <body>
        <h1>Please insert the song data below.</h1>
        
        <form method="Post" action = "add.htm">           
            <label style='float: left; display: block; width: 100px;'>Name</label>
            <input type="text" name="name"><br>
            
            <label style='float: left; display: block; width: 100px;'>Artist</label>
            <input type="text" name="artist"><br>
            
            <label style='float: left; display: block; width: 100px;'>Release Date</label>
            <input type="date" name="date"><br>
            
            <label style='float: left; display: block; width: 100px;'>Rating</label>
            <input type="number" name="rating" min="1" max="10" step=".25"><br>
            
            <input type="submit" name="button" value = "Submit">
            <input type="submit" name="button" value = "Return">
        </form>
        
        <h2><br>${message}</h2>
        
    </body>
</html>

