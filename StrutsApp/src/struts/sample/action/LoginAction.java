/**
 * 
 */
package struts.sample.action;

 
import java.sql.Connection;
import java.sql.ResultSet;



 
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Tamizhini
 * Date Jan 7, 2015
 */
public class LoginAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	   private String password;
	   private String username;
	   
	/*   private static final String driver="oracle.jdbc.driver.OracleDriver";
		private static final String dbURL="jdbc:oracle:thin:@localhost:1521:xe";
		private static final String login="system";
		private static final String password1="system";
	*/	

	public String getUser() {
			return user;
		}


		public void setUser(String user) {
			this.user = user;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}

		
		public String  execute(){
			 
			return SUCCESS;			
		}
		  public String register()  
	      {
			  Connection conn = null;
				try {
			   conn = ConnectionClass.getConnxn();
			   
			   String sql = "INSERT INTO login(USERNAME,PASSWORD,USERTYPE) VALUES ('"+username+"' , '"+password+ "' , 'ADMIN' )"; 
			  
			   Statement ps;
		
				ps = conn.createStatement();
			
			   System.out.println("QUERy:::: "+sql);
			  int r=ps.executeUpdate(sql);
			 conn.commit();
			   
			   System.out.println("QUERy:::: "+sql+" RESULT SET "+r);
			   
			   if (r>0) {
			       
			      System.out.println("Inserted Rows.,.,.,"+r);
			      return SUCCESS;
			   }
			   else{
				   System.out.println("NO VALUE RETURNED but no exception ");
				   return ERROR;
			   }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ERROR;
  
	      }
		  
   public String login(){
	   Connection conn = null;
	   try{
	   	//Class.forName(driver);
	   	
	        conn = ConnectionClass.getConnxn();//DriverManager.getConnection(dbURL, login, password1);
	        String sql = "SELECT name FROM login WHERE";
	        sql+=" username = '"+username+"' AND password = '"+password+"' ";
	        Statement ps = conn.createStatement();
	       
	        ResultSet rs = ps.executeQuery(sql);
	        
	        System.out.println("QUERy:::: "+sql+" RESULT SET "+rs);
	        
	        if (rs.next()) {
	           username = rs.getString(1); 
	           System.out.println("username**********.,.,.,"+username);
	           return SUCCESS;
	        }
	        else
	       	 System.out.println("NO VALUE RETURNED but no exception ");
	     } catch (Exception e) {
	   	  System.out.print("Exception so....returning "+ERROR);
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
	 

}
