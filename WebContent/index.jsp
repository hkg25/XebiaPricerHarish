<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h4> Login as : </h4>
<ul>
	<li><a href="${pageContext.request.contextPath}/jsp/product/newProduct.jsp">Agent</a></li>
	<li><a href="${pageContext.request.contextPath}/jsp/admin/productList.jsp">Admin</a></li>
</ul>

</body>
</html>