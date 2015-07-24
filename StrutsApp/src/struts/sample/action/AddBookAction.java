/**
 * 
 */
package struts.sample.action;

import java.sql.Connection;
import java.sql.Statement;

 
import com.opensymphony.xwork2.ActionSupport;


/**
 * @author Tamizhini
 * Date Jan 21, 2015
 */
public class AddBookAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String bookname;
	String author;
	String isbn;
	String genre;
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	  public void validate()
	   {
		  if(bookname.contains("'"))
    		  bookname.replaceAll("'", "''");
         
		  
	      if (bookname == null || bookname.trim().equals(""))
	      {
	    	  addFieldError("name","The name is required");
	      }
	      if (author == null || author.trim().equals(""))
	      {
	         addFieldError("author","The name is required");
	      }
	      if (genre == null || genre.trim().equals(""))
	      {
	         addFieldError("genre","The genre is required");
	      }
	      if (isbn == null || isbn.trim().equals(""))
	      {
	         addFieldError("isbn","The genre is required");
	      }
	
	      
	   }
	@Override
	public String execute() throws Exception {

	      Connection conn = null;
	
   conn = ConnectionClass.getConnxn();
   
   String sql = "INSERT INTO BOOKS VALUES ('"+isbn+"' , '"+author+"', '"+genre+"' , '"+bookname+"' )"; 
  
   Statement ps = conn.createStatement();
   System.out.println("QUERy:::: "+sql);
  int r=ps.executeUpdate(sql);
 
   
   System.out.println("QUERy:::: "+sql+" RESULT SET "+r);
   
   if (r>0) {
       
      System.out.println("Inserted Rows.,.,.,"+r);
      return SUCCESS;
   }
   else{
	   System.out.println("NO VALUE RETURNED but no exception ");
	   return ERROR;
   }
  	 

	}

	
	
	

}
