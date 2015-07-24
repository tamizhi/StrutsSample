<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Books</title>
</head>
<body>
<a href="<s:url action="book"/>">View Books</a>
<a href="loginForm.jsp">Logout</a><br/>
<s:form action="addbook" method="post" >
<center><table border="0">
<tr><td><s:label> BookName</s:label></td><td><s:textfield label="BookName" name="bookname" size="20"/></td></tr>
<tr><td><s:label> Author</s:label></td><td><s:textfield label="Author" name="author" size="20"/></td></tr>
<tr><td><s:label> ISBN</s:label></td><td><s:textfield label="ISBN" name="isbn" size="20"/></td></tr>
<tr><td><s:label> Genre</s:label></td><td><s:textfield label="Genre" name="genre" size="20"/></td></tr>
<tr><td></td><td><s:submit  name="submit" label="Submit" align="center" /></td></tr>

</table></center>
</s:form>
</body>
</html>