<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SUCCESS</title>
<link href="css/success.css" rel="stylesheet">
</head>
<body>
<table>
	<tr>
		<th>ID</th>
   	 	<th>Name</th>
    	<th>Status</th>
    	<th>Start Destination</th>
	    <th>Finish Destination</th>
	    <th>Start Date</th>
	    <th>Finish Date</th>
	    <th>Ship Brand/Personel</th>
	    <th>Description</th>
	    <th>Weight</th>
    	<th>Ship Payment</th>
    	<th>Total Payment</th>
	</tr>
	
	<c:forEach items="${billList}" var="bill">
		<tr>
			<td>${bill.bId}</td>
			<td>${bill.bName}</td>
			<td>${bill.bStatus}</td>
			<td>${bill.bDestStart}</td>
			<td>${bill.bDestFinish}</td>
			<td>${bill.bInitDate}</td>
			<td>${bill.bFinishDate}</td>
			<td>${bill.bShipBrand}</td>
			<td>${bill.bDesc}</td>
			<td>${bill.bWeight}</td>
			<td>${bill.bShipPay}</td>
			<td>${bill.bTotalPay}</td>
		</tr>
	</c:forEach>
</table>

<div class="addContainer">
	<div class="labelBills">
		<label><b>Manage Bills</b></label>
	</div>
	<div class="addButton-containter">
		<a href="/Transport-jsp-servlet/abc" class="button">Add Bills</a>
	</div>
</div>
</body>
</html>