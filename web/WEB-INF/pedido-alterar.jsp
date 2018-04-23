<%-- 
    Document   : novoPedido
    Created on : 20/04/2018, 21:56:40
    Author     : Rian Alves
--%>
<%@page import="Modelos.ListadeItens"%>
<%@page import="Modelos.Item"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedido</title>
    </head>
    <body>
        
        <h1>Pedido</h1>
        
       <h2> Abertura do Pedido : ${pedido.horaInicio} </h2>
       <h2> Fechamento do Pedido : ${pedido.horaFim} </h2>
       
       
       
      <form method = "post">
          <input type="hidden" name = "idmesa" value="${idMesa}">
          <table border = '1'>
                <thead>
                <th>Nome do Item</th>
                <th>Quantidade</th>
                </thead>
                
                <tbody>
                    <c:forEach var="item" items="${pedido.itens}">
                    
                    <tr>
                        <td>${item.produto.descricao}</td> 
                        <td><input required="true" type="number" value="${item.quantidade}" min= "0" name ="${item.produto.codigo}"/></td>            
                    </tr>
                    </c:forEach>
                </tbody>
                
            </table>
            
            <input type = "submit">
            <input type = "reset">
            
      </form>>


    </body>
</html>
