<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.foodcourt.common.UserType" %>
<%@ page import="com.foodcourt.common.model.Meal" %>

<%@page import="java.util.List"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>This is the main page for the customer</h1>
	<form action="<%=request.getContextPath()%>/profile" method="post">
		<button type="submit" value="viewProfile" name="viewProfile">View Profile</button>
	</form>
	<form action="viewOrder" method="post">
		<button type="submit" value="viewOrder" name="viewOrder">View Paid Order</button>
	</form>
	<form action="recharge" method="post">
		<button type="submit" value="recharge" name="recharge">Recharge</button>
	</form>
	<h2>Meals for today</h2>
	<form name="ItemQuantity" id="form1" action="confirmOrderController">
		<table border ="1" width="500" align="center"> 
	         <tr bgcolor="00FF7F"> 
	          <th><b>Food Name</b></th> 
	          <th><b>ID</b></th> 
	          <th><b>Price</b></th>
	          <th><b>ETA</b></th>
	          <th><b>Enter Quantity</b></th>
	         </tr>  
	
			<c:forEach items="${mealList}" var="meal" varStatus="loop">
	            <tr> 
	                <td>${meal.name}</td> 
	                <td>${meal.id}</td> 
	                <td>${meal.price}</td> 
	                <td>${meal.eta}</td>
	                <td><input type="number" name="quantity${meal.id}" id="quantity${meal.id}" value="0" min ="0" max="200"></td>
	               
	                
	            </tr> 
	          </c:forEach>
	          <tr>
	          	<td></td>
	   			<td></td>
	   			<td></td>
	   			<td></td>
	   			<td><input type="submit" name="confirmOrder" value="Confirm Order">	</td>
	          </tr>
	    </table>  
    </form>
    
    
    

</body>
</html>