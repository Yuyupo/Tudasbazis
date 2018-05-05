package tkvnmsz.tudastar.service.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Endre
 */
public class EmptyResultProcessor implements QueryResultProcessor {

	@Override
	public void process(ResultSet resultSet) throws SQLException {
		
	}

}
