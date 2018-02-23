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
		<h1>Device Allocation List</h1>
		
		<h4>
			Add New Device Allocation <a href="<c:url value='/deviceallocation/newAllocation'/>"> here </a>	
		</h4>
			
		<table border="1">

			<th>Brand</th>
			<th>Item Model Number</th>
			<th>Blocked By</th>
			<th>Approved By</th>
			<th>End Date </th>
			<th> Is Available </th>
			<th>Action</th>

			<c:forEach var="deviceAllocation" items="${listAllocation}">
				<tr>

					<td>${deviceAllocation.device.brand}</td>
					<td>${deviceAllocation.device.itemmodelnumber}</td>
					<td>${deviceAllocation.blockedBy}</td>
					<td>${deviceAllocation.approvedBy}</td>
					<td>${deviceAllocation.endDate}</td>
					<td>
						<c:choose>
							<c:when test="${deviceAllocation.device.isAvailable == 1}">
								Not Available. 
							</c:when>	
							<c:when test="${deviceAllocation.device.isAvailable == 0}">
							Available. 
							</c:when>
						</c:choose>	
					</td>					
					<td><a href="<c:url value='/deviceallocation/editAllocation?id=${deviceAllocation.deviceAllocationId}'/>">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="<c:url value='/deviceallocation/deleteAllocation?id=${deviceAllocation.deviceAllocationId}'/>">Delete</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<c:choose>
							<c:when test="${deviceAllocation.device.isAvailable == 1}">
								<a href="<c:url value='/deviceallocation/setdeviceReallocation?id=${deviceAllocation.device.id}&value=0'/>">Make it Available</a> 
							</c:when>	
							<c:when test="${deviceAllocation.device.isAvailable == 0}">
								<a href="<c:url value='/deviceallocation/setdeviceReallocation?id=${deviceAllocation.device.id}&value=0'/>">Make it Used</a>
							</c:when>
						</c:choose>	
						</td>
				</tr>   
			</c:forEach>
		</table>
	
	</div>
</body>
</html>