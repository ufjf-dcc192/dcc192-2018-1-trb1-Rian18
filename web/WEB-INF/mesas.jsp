<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : mesas
    Created on : 23/04/2018, 12:15:14
    Author     : Rian Alves
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mesas</title>
        <%@include file="/WEB-INF/jspf/bootstrap.jspf" %>>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Mesa</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="mesa" items="${mesas}">
                <tr>
                    <td>${mesa.id}</td>
                    <td>${mesa.descricao}</td>
                    <td><a href = "pedidos.html?mesa=${mesa.id}&operacao=editar">Gerenciamento do Pedido</td>
                <c:if test="${mesa.pedido != null}">
                    <td><a href = "pedidos.html?mesa=${mesa.id}&operacao=visao">Visualizar</td>
                </c:if>
                </tr>
            </c:forEach>

        </tbody>
    </table>




</body>
</html>
