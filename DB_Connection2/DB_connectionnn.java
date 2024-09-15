package DB_Connection2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import DBconnectionRestAssured.SQL_Querry;

public class DB_connectionnn {

		   @Test
			public static Object getconnection(int x) throws SQLException
			{
				Connection mycon=null;
				Statement mystmt=null;
				ResultSet myrs=null;
				Object obj=null;
				
				mycon=	DriverManager.getConnection("jdbc:mysql://localhost:3306/student11","root","root");
				
		     System.out.println("connection successfully");
		   
		   
		     mystmt=mycon.createStatement();
		    // myrs=mystmt.executeQuery("Select* from Student11.persons limit 1");//limit 1 is column value
		     myrs=mystmt.executeQuery(SQL_Querry.SelectQuerry1());
		     while(myrs.next())
		     {
		    	 obj=myrs.getString(x);//value of row
		     }
		     System.out.println(obj);
			return obj;
		   
		   
			}

		}

	