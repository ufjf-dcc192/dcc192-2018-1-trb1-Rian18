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
        <%@include file="/WEB-INF/jspf/bootstrap.jspf" %>

    </head>
    <body>
        <table class="table table-hover">
            <thead>

                <tr class="table-primary">
                    <th>Código</th>
                    <th>Mesa</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="mesa" items="${mesas}">
                    <c:choose >
                        <c:when test="${mesa.pedido != null}">
                            <tr>
                                <td class="table-danger">${mesa.id}</td>
                                <td class="table-danger">${mesa.descricao}</td>
                                <td class="table-danger"><a href = "pedidos.html?mesa=${mesa.id}&operacao=editar">Gerenciamento do Pedido</td>
                                <td class="table-danger"><a href = "pedidos.html?mesa=${mesa.id}&operacao=visao">Visualizar</td>
                            </tr>

                        </c:when>

                        <c:when test="${mesa.pedido == null}">

                            <tr>
                                <td class="table-success">${mesa.id}</td>
                                <td class="table-success">${mesa.descricao}</td>
                                <td class="table-success"><a href = "pedidos.html?mesa=${mesa.id}&operacao=editar">Gerenciamento do Pedido</td>
                            </tr>

                        </c:when>
                    </c:choose>
                </c:forEach>
            </tbody>
        </table>




    </body>
</html>
