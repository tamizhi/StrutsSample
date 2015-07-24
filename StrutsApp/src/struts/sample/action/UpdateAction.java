/**
 * 
 */
package struts.sample.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Tamizhini Date Jul 23, 2015
 */

 
public class UpdateAction extends ActionSupport {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	BookBean mb;// = new BookBean();
	String Editing, Deleting;
	ArrayList<BookBean> booksList;
	private int removeIndex;
	
	private String  isbn;
	private String bookname;
	private String author;
	private String genre;
	

	public int getRemoveIndex() {
		return removeIndex;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setRemoveIndex(int removeIndex) {
		this.removeIndex = removeIndex;
	}

	public String getEditing() {
		return Editing;
	}

	public void setEditing(String Editing) {
		this.Editing = Editing;
	}

	public String getDeleting() {
		return Deleting;
	}

	public void setDeleting(String Deleting) {
		this.Deleting = Deleting;
	}

	
int i=0;
	public String editbook() {
	 
		Connection conn = null;
		System.out.println("STATEMENT ::::" +"BOOKNAME" +author +":::ISBN VALUE:::"+isbn);
		conn = ConnectionClass.getConnxn();
		 
		try {
			{
				String s = "update books set author = '"+author+"' , bookname = '"+bookname+"'  , genre =  '"+genre+"'  where isbn = '"+isbn+" '";
				Statement ps;

				ps = conn.createStatement();
				int result=ps.executeUpdate(s);
			/*	ps.setString(1, author);
				ps.setString(2, bookname);
				ps.setString(3, genre);
				ps.setString(4, isbn);
*/
				
				 System.out.println("STATEMENT ::::"+s +"BOOKNAME" +author +":::ISBN VALUE:::"+isbn);
				 i++;
				 conn.commit();

				 System.out.println("INSIDE EDIT BOOK RESULT ::::"+result );
 if (result > 0) 
				{
					String sql = "SELECT * FROM BOOKS ";

					Statement ps1 = conn.createStatement();

					ResultSet rs = ps1.executeQuery(sql);
					System.out
							.println("QUERy:::: " + sql + " RESULT SET " + rs);

					booksList = new ArrayList<BookBean>();
					booksList.clear();
					while (rs.next()) {

						mb = new BookBean();
						System.out.println("BOOK NAME:::" + rs.getString(1));
						// isbn.author,genre,book
						mb.setIsbn(rs.getString("isbn"));

						mb.setAuthor(rs.getString("author"));
						mb.setGenre(rs.getString("genre"));
						mb.setBookname(rs.getString("bookname"));
						booksList.add(mb);

					}
					ps.close();
					ps1.close();
					conn.close();
					System.out.println("Connection book list size:::: "+booksList.size());
					return SUCCESS;
				} else if (result == 0)
					return NONE;
				else
					return ERROR;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;

	}

	public String deletebook() {
		Connection conn = null;

		conn = ConnectionClass.getConnxn();
		// if(EDIT.equals("editButton"))
		try {
			{
				

				 
					String sql = "SELECT * FROM BOOKS ";

					Statement ps1 = conn.createStatement();

					ResultSet rs = ps1.executeQuery(sql);
					System.out
							.println("QUERy:::: " + sql + " RESULT SET " + rs);

					booksList = new ArrayList<BookBean>();

					while (rs.next()) {

						mb = new BookBean();
						System.out.println("BOOK NAME:::" + rs.getString(1));
						// isbn.author,genre,book
						mb.setIsbn(rs.getString("isbn"));

						mb.setAuthor(rs.getString("author"));
						mb.setGenre(rs.getString("genre"));
						mb.setBookname(rs.getString("bookname"));
						booksList.add(mb);

					}
					String s = "delete from books  where isbn = '" + booksList.get(removeIndex).getIsbn() +"' ";
							 
					Statement ps;

					ps = conn.createStatement();

					  ps.executeUpdate(s);
					conn.commit();
					booksList.remove(removeIndex);
					ps.close();
					conn.close();
					return  SUCCESS;
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;

	}

	public String execute() throws Exception {
		Connection conn = null;

		conn = ConnectionClass.getConnxn();
		String sql = "SELECT * FROM BOOKS ";

		Statement ps1 = conn.createStatement();

		ResultSet rs = ps1.executeQuery(sql);
		System.out
				.println("QUERy:::: " + sql + " RESULT SET " + rs);

		booksList = new ArrayList<BookBean>();

		while (rs.next()) {

			mb = new BookBean();
			System.out.println("BOOK NAME:::" + rs.getString(1));
			// isbn.author,genre,book
			mb.setIsbn(rs.getString("isbn"));

			mb.setAuthor(rs.getString("author"));
			mb.setGenre(rs.getString("genre"));
			mb.setBookname(rs.getString("bookname"));
			booksList.add(mb);

		}
	//	ps.close();
		ps1.close();
		conn.close();
		System.out.println("Connection book list size:::: "+booksList.size());
		return SUCCESS;
	
		 
	}

	public ArrayList<BookBean> getBooksList() {
		return booksList;
	}

	public void setBooksList(ArrayList<BookBean> booksList) {
		this.booksList = booksList;
	}

	public BookBean getMb() {
		return mb;
	}

	public void setMb(BookBean mb) {
		this.mb = mb;
	}

}
