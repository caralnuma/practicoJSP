<%-- 
    Document   : PublicacionRegistrationResult
    Created on : 22/04/2019, 06:59:15 PM
    Author     : Carlox
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publicaciones</title>
    </head>
    <body>

<h4>Publicaciones</h4>
<table class="simpletablestyle">
<thead>
<tr>
<th>id</th>
<th>Tipo</th>
<th>URL</th>
</tr>
</thead>
<tbody>
<!--  iterate on the member list @named attribute and display name,email and phone number -->
<c:forEach items="${publicaciones}" var="noticia">
	<tr>
		<td><c:out value="${publicaciones.id}"/></td>
		<td><c:out value="${publicaciones.tpo}"/></td>
		<td><c:out value="${publicaciones.URL}"/></td>
	</tr>
</c:forEach>
</tbody>
</table>	

</body>
</html>
