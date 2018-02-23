<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Device</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Device</h1>
        <form:form action="saveDevice" method="post" modelAttribute="device">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Brand:</td>
                <td><form:input path="brand" /></td>
            </tr>
            <tr>
                <td>Series:</td>
                <td><form:input path="series" /></td>
            </tr>
            
            <tr>
                <td>Colour:</td>
                <td><form:input path="colour" /></td>
            </tr>
            
              <tr>
                <td>Item Model Number:</td>
                <td><form:input path="itemmodelnumber" /></td>
            </tr>
            
             <tr>
                <td>item Height:</td>
                <td><form:input path="itemheight" /></td>
            </tr>
            
             <tr>
                <td>Item Width:</td>
                <td><form:input path="itemwidth" /></td>
            </tr>
            
            <tr>
                <td>Item Weight:</td>
                <td><form:input path="itemweight" /></td>
            </tr>
            <tr>
                <td>Product Dimensions:</td>
                <td><form:input path="productdimensions" /></td>
            </tr>
                                   
               <tr>
                <td>Batteries:</td>
                <td><form:input path="batteries" /></td>
            </tr>
            
               <tr>
                <td>Battery Description:</td>
                <td><form:input path="batterydescription" /></td>
            </tr>
            
            
               <tr>
                <td>Average Battery Life (In Hours):</td>
                <td><form:input path="averagebatterylife" /></td>
            </tr>
            
            
               <tr>
                <td>Lithium Battery Energy Content:</td>
                <td><form:input path="lithiumbatteryenergycontent" /></td>
            </tr>
                       
            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
                 <td colspan="2" align="center"><a href="<c:url value='/cancel'/>">
 <input type="button" value="Cancel"/></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>