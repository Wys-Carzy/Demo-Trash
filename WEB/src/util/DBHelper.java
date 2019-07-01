package util;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * ��������
 * @author Wys
 *
 */
public class DBHelper {
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			Context c = new InitialContext();
			DataSource d = (DataSource) c.lookup("java:comp/env/abc");
			conn = d.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e){
			System.out.println("adsfadsfasdf");
			e.printStackTrace();
		}
		return conn;
	}
}
