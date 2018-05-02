package tkvnmsz.tudastar.service.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Endre
 */
public class OracleDatabase {

	// REQUEST
	public static void request(String query, StatementParameterizer parameterizer, QueryResultProcessor processor) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");

			OracleDataSource ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:4000:kabinet");
			conn = ods.getConnection("h675212", "almafa22");

			stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			parameterizer.parameterize(stmt);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				processor.process(rs);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public static void execute(String query, StatementParameterizer parameterizer) throws SQLException {
		// System.out.println( query );

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			OracleDataSource ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:4000:kabinet");
			conn = ods.getConnection("h675212", "almafa22");

			stmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			parameterizer.parameterize(stmt);

			boolean result = stmt.execute(query);

			if (!result) {
				JOptionPane.showMessageDialog(null, "SQL kérés sikertelen!\n" + stmt.getWarnings(), "Hiba!",
						JOptionPane.ERROR_MESSAGE);
			}

			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se2) {

			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	/*
	 * class Parameterizer {
	 * 
	 * class Parameter {
	 * 
	 * public String column; public String value;
	 * 
	 * public Parameter(String column, String value) { this.column = column;
	 * this.value = value; }
	 * 
	 * }
	 * 
	 * private String table = "<TABLE NAME>"; private List<Parameter> parameters;
	 * private String where = "<WHERE>";
	 * 
	 * public Parameterizer() { parameters = new ArrayList<>(); }
	 * 
	 * public Parameterizer in(String table) { this.table = table; return this; }
	 * 
	 * public Parameterizer add(String column, String value) { parameters.add(new
	 * Parameter(column, value)); return this; }
	 * 
	 * public Parameterizer add(String column, int value) { parameters.add(new
	 * Parameter(column, Integer.toString(value))); return this; }
	 * 
	 * public Parameterizer add(String column, Date value) { parameters.add(new
	 * Parameter(column, value == null ? null : value.toString())); return this; }
	 * 
	 * public Parameterizer addNull(String column) { parameters.add(new
	 * Parameter(column, null)); return this; }
	 * 
	 * public Parameterizer addIntOrNull(String column, int value) {
	 * parameters.add(new Parameter(column, value == -1 ? null :
	 * Integer.toString(value))); return this; }
	 * 
	 * public Parameterizer where(String column, int value) { where = column + "=" +
	 * Integer.toString(value); return this; }
	 * 
	 * private String quoteValue(String value) { return value == null ? "NULL" : "'"
	 * + value + "'"; }
	 * 
	 * public String insert() { String colums = String.join(", ",
	 * parameters.stream().map(p -> p.column).collect(Collectors.toList())); String
	 * values = String.join(", ", parameters.stream().map(p ->
	 * quoteValue(p.value)).collect(Collectors.toList())); return "INSERT INTO " +
	 * table + "(" + colums + ") VALUES(" + values + ")" + ";"; }
	 * 
	 * public String update() { String values = String.join(", ",
	 * parameters.stream().map(p -> p.column + " = " +
	 * quoteValue(p.value)).collect(Collectors.toList())); return "UPDATE " + table
	 * + " SET " + values + " WHERE " + where + ";"; }
	 * 
	 * public String exists() { return "SELECT * FROM " + table + " WHERE " + where
	 * + ";"; }
	 * 
	 * public String remove() { return "DELETE FROM " + table + " WHERE " + where +
	 * ";"; } }
	 */
}
