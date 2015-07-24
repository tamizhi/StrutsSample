<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
<title>Struts Application</title>
</head>
<body>
   Hello ,<s:property value="username"/>
<a href="addbook.jsp">Add Books</a><br/>
<a href="<s:url action="viewbook"/>">View Books</a>
 
 
</body>
</html>