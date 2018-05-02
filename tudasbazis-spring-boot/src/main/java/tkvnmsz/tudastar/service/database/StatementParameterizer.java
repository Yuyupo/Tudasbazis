package tkvnmsz.tudastar.service.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface StatementParameterizer {
	void parameterize(PreparedStatement statement) throws SQLException;
}
