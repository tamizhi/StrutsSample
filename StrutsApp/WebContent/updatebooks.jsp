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
  $(function confirmDelete() { 
 
  $('#dialog-confirm').css('display','block');
$('#dialog-confirm').dialog({
    resizable: false,
    height:140,
    
    modal: true,
    autoOpen: false,
    buttons: {
      "Delete book": function() {
        $( this ).dialog( "close" );
      },
      Cancel: function() {
        $( this ).dialog( "close" );
      }
    }
  });
  });
 </script>
  <%--  <script>
  $(function() {
    $( "#dialog-confirm" ).dialog({
      resizable: false,
      height:140,
      
      modal: true,
      autoOpen: false,
      buttons: {
        "Delete book": function() {
          $( this ).dialog( "close" );
        },
        Cancel: function() {
          $( this ).dialog( "close" );
        }
      }
    });
  });
  </script> --%>
</head>
<body>
<a href="addbook.jsp">Add Books</a><br/>
<a href="loginForm.jsp">Logout</a><br/>
	<s:if test="%{getBooksList().isEmpty()}">
		<h5>NO BOOKS FOUND</h5>
	</s:if>
	<s:else>
	<div id="dialog-confirm" style="display : none;" title="Delete Book?">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span>These items will be permanently deleted and cannot be recovered. Are you sure?</p>
</div>
	
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
				<s:iterator status="stat" value="booksList" var="book">
					<tr>
						<td><s:textfield value="%{#book.bookname}"  name="mb.bookname" /></td>
						<td><s:textfield value="%{#book.author}"  name="mb.author" /></td>
						<td><s:textfield  value="%{#book.isbn}" name="mb.isbn" readonly="true" /></td>
						<td><s:textfield value="%{#book.genre}" name="mb.genre" /></td>
						<td><s:submit value="Editing" method="editbook" name="editButton"/>
						</td>
						<td><s:submit  value="Deleting" method="deletebook" name="deleteButton"/><div id="myDiv"><h2> </h2></div></td>
						
					</tr>
				</s:iterator>
			</s:form>
		</table>
	</s:else>
</body>
</html>