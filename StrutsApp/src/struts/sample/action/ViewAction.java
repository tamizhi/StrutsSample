/**
 * 
 */
package struts.sample.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Tamizhini Date Jun 17, 2015
 */
public class ViewAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<BookBean> booksList;
	BookBean mb;
	

	public BookBean getMb() {
		return mb;
	}

	public void setMb(BookBean mb) {
		this.mb = mb;
	}

	public String execute() throws Exception {

		Connection conn = null;
		try {
			// Class.forName(driver);

			conn = ConnectionClass.getConnxn();// DriverManager.getConnection(dbURL,
												// login, password1);
			String sql = "SELECT * FROM BOOKS ";

			Statement ps = conn.createStatement();

			ResultSet rs = ps.executeQuery(sql);
			System.out.println("QUERy:::: " + sql + " RESULT SET " + rs);
			boolean flag = false;
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
				flag = true;
			}

			if (flag) {
				// ViewForm form=(ViewForm)form;
				return SUCCESS;

			}
			return SUCCESS;

		} catch (Exception e) {
			System.out.print("Exception so....returning " + ERROR);
		} finally {
			if (conn != null) {
				try {
					conn.close();

				} catch (Exception e) {
				}
			}
		}
		return ERROR;
	}

	public ArrayList<BookBean> getBooksList() {
		return booksList;
	}

	public void setBooksList(ArrayList<BookBean> booksList) {
		this.booksList = booksList;
	}
}
