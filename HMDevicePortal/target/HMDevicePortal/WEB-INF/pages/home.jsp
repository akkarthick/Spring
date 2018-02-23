<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Device Management Portal</title>
</head>
<body>
	<div align="center">
		<h1>Device List</h1>
		
			<h4>
			Add New Device <a href="newDevice">here</a>
		</h4>
			<h4>
			Device Allocation List 
			<a href="<c:url value='/deviceallocation/listAllocation'/>"> here </a>			
		</h4>
		<table border="1">

			<th>Brand</th>
			<th>Series</th>
			<th>Colour</th>
			<th>Item Model Number</th>
			<th> Device Status </th>
			<th>Action</th>

			<c:forEach var="device" items="${listDevice}">
				<tr>

					<td>${device.brand}</td>
					<td>${device.series}</td>
					<td>${device.colour}</td>
					<td>${device.itemmodelnumber}</td>
					<td>
						<c:choose>
							<c:when test="${device.active == 1}">
								Active
							</c:when>	
							<c:when test="${device.active == 0}">
								Inactive
							</c:when>
						</c:choose>	
					</td>					
					<td><a href="editDevice?id=${device.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteDevice?id=${device.id}">Delete</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
						<c:choose>
							<c:when test="${device.active == 1}">
								<a href="setDeviceActive?id=${device.id}&value=0">Inactive</a> 
							</c:when>	
							<c:when test="${device.active == 0}">
								<a href="setDeviceActive?id=${device.id}&value=1">Active</a>
							</c:when>
						</c:choose>	
						
						</td>
				</tr>
			</c:forEach>
		</table>
	
	</div>
</body>
</html>