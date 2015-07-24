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

	BookBean mb = new BookBean();
	String Editing, Deleting;
	ArrayList<BookBean> booksList;

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

	

	public String editbook() {

		Connection conn = null;

		conn = ConnectionClass.getConnxn();
		// if(EDIT.equals("editButton"))
		try {
			{
				String s = "update books set author = ? , bookname = ?  , genre =  ?  where isbn = ? ";
				PreparedStatement ps;

				ps = conn.prepareStatement(s);

				ps.setString(1, mb.getAuthor());
				ps.setString(2, mb.getBookname());
				ps.setString(3, mb.getGenre());
				ps.setString(4, mb.getIsbn());

				int result = ps.executeUpdate();
				conn.commit();

				ps.close();

				if (result > 0) {
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
					conn.close();
					return "edit";
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
				String s = "delete from books  where isbn = '" + mb.getIsbn()
						+ " '";
				Statement ps;

				ps = conn.createStatement();

				int result = ps.executeUpdate(s);
				conn.commit();

				ps.close();

				if (result > 0) {
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
					conn.close();
					return "delete";
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

	public String execute() throws Exception {
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
