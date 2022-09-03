package atm;

import java.sql.*;

public class dbconnection { 
	public static Connection connectdb(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
			return con;
			}catch(Exception ex){
				System.out.println("error the connection is not established");
				return null;
			}
		}
		
	}
