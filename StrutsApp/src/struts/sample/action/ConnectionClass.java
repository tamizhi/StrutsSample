/**
 * 
 */
package struts.sample.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Tamizhini
 * Date Jan 21, 2015
 */
public class ConnectionClass {
	   private static final String driver="oracle.jdbc.driver.OracleDriver";
			private static final String dbURL="jdbc:oracle:thin:@localhost:1521:xe";
			private static final String login="system";
			private static final String password1="system";
			
			public static Connection getConnxn(){
				  Connection conn = null;							
			     try {
			    		Class.forName(driver);
					conn = DriverManager.getConnection(dbURL, login, password1);
				} catch (SQLException e) {					
					e.printStackTrace();
				} catch (ClassNotFoundException e) {					
					e.printStackTrace();
				}
			 return conn;
			}


}
