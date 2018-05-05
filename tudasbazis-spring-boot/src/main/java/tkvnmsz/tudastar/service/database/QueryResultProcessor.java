package tkvnmsz.tudastar.service.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Endre
 */
@FunctionalInterface
public interface QueryResultProcessor {
	void process(ResultSet resultSet) throws SQLException;
}
