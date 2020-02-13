<%-- 
    Document   : shoppingList
    Created on : Feb 10, 2020, 10:25:09 AM
    Author     : 794456
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello,${username}</p>     <a href="shoppingList?logout">Logout</a>
        
        <h2>List</h2>
        <form action="shoppingList" method="post" id="shoppingList">
            
         Item:<input name="item" type="text">
         <input name="additem" type="submit" value="Add">
        </form>
        
        <br>
        <form action="shoppingList" method="post">
            <input type="hidden" name="action" value="delete" />
      

      
        </form> 
                <form method="POST">
         
            <c:forEach var="thing" items="${things}" varStatus="status">
                  <c:if test="${things.size() > 0}">
                <input type="radio" name="radSelect" value="${status.index}" />${thing}<br />
                      </c:if>
            </c:forEach>
         
                  <input type="submit" name="btnSubmit" value="Delete" />
                </form>
    </body>
</html>
