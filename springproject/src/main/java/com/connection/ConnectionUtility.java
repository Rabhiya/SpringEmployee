package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

	public class ConnectionUtility {
		//public Connection c;
		//public Statement s;
		
		public Connection getConnect()
		{
			try {
			//Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee","root","Riya@1997"); 
		    return con;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return null;
		    
		}

	}



