<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Bills</title>
<link href="css/addBill.css" rel="stylesheet">
</head>
<body>
<form>
	<table>
		<tr>
			<th>Name</th>
			<th><input type="text" placeholder="Enter Name" name="bName" required></th>
		</tr>
		<tr>
			<th>Status</th>
			<th><input type="text" placeholder="Enter Status" name="bStatus" required></th>
		</tr>
		<tr>
			<th>Start Destination</th>
			<th><input type="text" placeholder="Enter Start Destination" name="bDestStart" required></th>
		</tr>
		<tr>
			<th>Finish Destination</th>
			<th><input type="text" placeholder="Enter Finish Destination" name=bDestFinish required></th>
		</tr>
		<tr>
			<th>Initiation Date</th>
			<th><input type="Date" name="bInitDate" required></th>
		</tr>
		<tr>
			<th>Finish Date</th>
			<th><input type="Date" name="bFinishDate" required></th>
		</tr>
		<tr>
			<th>Ship Brand/Personel</th>
			<th><input type="text" placeholder="Enter Brand or Personel" name="bShipBrand" required></th>
		</tr>
		<tr>
			<th>Description</th>
			<th><input type="text" placeholder="Enter Description" name="bDesc" required></th>
		</tr>
		<tr>
			<th>Weight</th>
			<th><input type="text" placeholder="Enter Weight" name="bWeight" required></th>
		</tr>
		<tr>
			<th>Ship Payment</th>
			<th><input type="text" placeholder="Enter Payment" name="bShipPay" required></th>
		</tr>
		<tr>
			<th>Total Payment</th>
			<th><input type="text" placeholder="Enter Total Payment" name="bTotalPay" required></th>
		</tr>
	</table>
</form>
</body>
</html>