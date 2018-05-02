package tkvnmsz.tudastar.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.pool.OracleDataSource;

public class OracleDatabaseConnection {
	public void connect() {
		
		System.out.println("Most");
		try { 
		    OracleDataSource ods = new OracleDataSource(); 
		    Class.forName ("oracle.jdbc.OracleDriver"); 
		    ods.setURL("jdbc:oracle:thin:@localhost:4000:kabinet"); 
		    Connection conn = ods.getConnection("h675212","almafa22"); 
		    Statement createStatement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,  ResultSet.CONCUR_READ_ONLY);
		    ResultSet executeQuery = createStatement.executeQuery("SELECT * FROM W_LANGUAGE");
		    while(executeQuery.next()) {
		    	System.out.println(executeQuery.getString(2));
		    }
		} catch ( Exception ex ) { 
		    ex.printStackTrace(); 
		}
	}
}
