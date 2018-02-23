<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Device Allocation</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Device Allocation</h1>
        <form:form action="saveAllocation" method="post" modelAttribute="deviceAllocation">
        <table>
            <form:hidden path="deviceAllocationId"/>
            <tr>
                <td>Device Name:</td>
                <td>
					<form:select path="device" cssStyle="width: 150px;">    
					<option value="-1">Select a device</option>
					<c:forEach items="${deviceList}" var="deviceItem">
					<option value="${deviceItem.id}">${deviceItem.brand}</option>
					</c:forEach>
					</form:select> 
                </td>
            </tr>
            <tr>
                <td>Blocked By:</td>
                <td><form:input path="blockedBy" /></td>
            </tr>
            
            <tr>
                <td>Approved By:</td>
                <td><form:input path="approvedBy" /></td>
            </tr>
                         
             <tr>
                <td>Expire Date:</td>
                <td><form:input path="endDate" /></td>
            </tr>                        
          
                   
            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
                 <td colspan="2" align="center"><a href="<c:url value='/deviceallocation/cancel'/>">
 <input type="button" value="Cancel"/></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>