<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
    

body  {
    background: url(zeppelin.png) no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    color: #ec5525;
}   

table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: center;
    padding: 8px;
}

</style>
</head>
<body>

<h2>Song List<br/></h2>


   
	

<form method="Post" action = "list.htm">

<table id="table" bgcolor= "#CBF0BD">

    <tr>
        <th>Name</th>
        <th>Artist</th>
        <th>Release Date</th>
        <th>Rating</th>
    </tr>
	
    
    <c:forEach items="${list}" var="item">
   	

        <tr>
            <td style="text-align: center; vertical-align: middle;" width="400" >
                ${item.name}<BR>
            </td>
            <td style="text-align: center; vertical-align: middle;" width="400" >
                ${item.artist}<BR>
            </td>
            <td style="text-align: center; vertical-align: middle;" width="400" >
                ${item.releaseDate}<BR>
            </td>
            <td style="text-align: center; vertical-align: middle;" width="400" >
                ${item.rating}<BR>
            </td>
        </tr>
    
    </c:forEach>


</table>


<input type="submit" name = "button" value="Sort by Name">
<input type="submit" name = "button" value="Sort by Artist">
<input type="submit" name = "button" value="Sort by Release Date">
<input type="submit" name = "button" value="Sort by Rating"><br>
<input type="submit" name = "button" value="Return">

</form>

</body>
</html>
