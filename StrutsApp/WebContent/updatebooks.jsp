<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BOOK STORE</title>
   
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 <script>
  function setRemoveIndex(val,bookname)
   {    
       alert("Delete Book , ?? "+bookname);
    
       document.getElementById("removeIndex").value=val;
       
       document.myform.action="deletebook.action";
       document.myform.submit();
        return true;
   }
  function setEditBook(isbn,bookname,author,genre)
  {    
      
	  alert("Edit Book , ?? "+bookname);
      document.getElementById("isbn").value=isbn+"";
      document.getElementById("bookname").value=bookname+"";
      document.getElementById("author").value=author+"";
      document.getElementById("genre").value=genre+"";
       
      document.myform.action="editbook.action";
      document.myform.submit();
       return true;
  }
</script>
</head>
<body>
<a href="addbook.jsp">Add Books</a><br/>
<a href="loginForm.jsp">Logout</a><br/>
	<s:if test="%{getBooksList().isEmpty()}">
		<h5>NO BOOKS FOUND</h5>
	</s:if>
	<s:else>
	 
	
		<table>
			<tr>
				<th>NAME</th>
				<th>AUTHOR</th>
				<th>ISBN</th>
				<th>GENRE</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>
			
			<s:form action="book">
			<s:hidden name="removeIndex" id="removeIndex"/>
			<s:hidden name="isbn" id="isbn"/>
			<s:hidden name="bookname" id="bookname"/>
			<s:hidden name="author" id="author"/>
			<s:hidden name="genre" id="genre"/>
				<s:iterator status="stat" value="booksList" var="book" status="status">
					<tr>
						<td><s:textfield value="%{#book.bookname}"  name="mb.bookname" /></td>
						<td><s:textfield value="%{#book.author}"  name="mb.author" /></td>
						<td><s:textfield  value="%{#book.isbn}" name="mb.isbn" readonly="true" /></td>
						<td><s:textfield value="%{#book.genre}" name="mb.genre" /></td>
						<td><s:submit value="Editing" method="editbook" name="editButton"  onclick="return setEditBook('%{#book.isbn}','mb.bookname','%{#book.author}','%{#book.genre}')"/>
						</td>
						<td><s:submit  value="Deleting" method="deletebook" name="deleteButton"  onclick="return setRemoveIndex('%{#status.index}','%{#book.bookname}')"/> </td>
						
					</tr>
				</s:iterator>
			</s:form>
		</table>
	</s:else>
</body>
</html>