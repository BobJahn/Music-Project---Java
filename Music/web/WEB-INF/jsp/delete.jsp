<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
body  {
    background: url(light.png) no-repeat center center fixed;
    -webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
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

<form method="Post" action = "delete.htm">
<table>

    <tr>
        <th>Check</th>
        <th>Name</th>
        <th>Artist</th>
        <th>Release Date</th>
        <th>Rating</th>
    </tr>
	
    
    <c:forEach items="${list}" var="item">
   	

        <tr bgcolor= "#CBF0BD" >
            <td style="text-align: center; vertical-align: middle;" width="400" >
                <input type="checkbox" name="id" value="${item.name}"><BR>
            </td>
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

<input type="submit" name = "button" value="Delete Selected">
<input type="submit" name = "button" value="Return">
</form>
</body>
</html>

