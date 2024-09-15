package DBconnectionRestAssured;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DBconnection {
   @Test
	public static void getconnection() throws SQLException
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
    	 obj=myrs.getString(2);//value of row
     }
     System.out.println(obj);
   
   
	}

}
