<%-- 
    Document   : PublicacionRegistrationForm
    Created on : 22/04/2019, 06:58:11 PM
    Author     : Carlox
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form id="reg" action="publicacionRegister.do" method="POST">
        <h2>Publicacion Registration</h2>
        <table>
            <tr>
                <td style="text-align: right;"><label for="name">Id:</label>
                </td>
                <td><input type="number" id=name name="id"
                    value="${newPublicacion.id}" /></td>
            </tr>
            <tr>
                <td style="text-align: right;"><label for="name">Tipo:</label>
                </td>
                <td><input type="text" id=name name="tipo"
                    value="${newPublicacion.tipo}" /></td>
            </tr>
            <tr>
                <td style="text-align: right;"><label for="email">URL:</label>
                </td>
                <td><input type="hidden" value="<%=request.getParameter("idNoticia")%>" name="idNoticia"/></td>

                <td><input type="text" id="email" name="URL"
                    value="${newPublicacion.URL}" /></td>
            </tr>
        </table>
        <p>
            <input id="register" type="submit" value="Register" /> 
        </p>
        <p>
            <label style="color: green;width: 100%;text-align: left;">${infoMessage}</label> 
        </p>
        <p>
             <label style="color: red; width: 100%;text-align: left;">${errorMessage}</label>
        </p>
    </form>
</body>
</html>
