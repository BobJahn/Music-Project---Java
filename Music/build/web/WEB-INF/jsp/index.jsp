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
        <title>~~Music~~</title>
    </head>
    <body>
        <h1>Howdy! What tunes do you want to see?</h1>
        
        <form method="Post" action = "view.htm">
            <label style='float: left; display: block; width: 45px;'>Artist</label>
            <input type="text" name="artist">
            <input type="submit" name="button" value = "Search Artist"><br><br>
            
            <input type="submit" name="button" value = "Show All Songs">
            <input type="submit" name="button" value = "Add Song">
            <input type="submit" name="button" value = "Delete Song">
        </form>
        
        
    </body>
    
    
</html>

