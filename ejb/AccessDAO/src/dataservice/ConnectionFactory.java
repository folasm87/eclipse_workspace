package dataservice;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


/*Factory design pattern thats responsible for returning connections
 * */
public class ConnectionFactory {
	public static Connection getConnection(){
		Connection conn = null;
		
		try{
			//java class that understands how to read a *.properties file.
			Properties prop = new Properties();
			//connect prop to a file on disk
			//C:\eclipse_workspace\ejb\AccessDAO\src\dataservice\database.properties
			prop.load(new FileReader("C:\\eclipse_workspace\\ejb\\AccessDAO\\src\\dataservice\\database.properties"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("pwd"));
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return conn;
	}

}
