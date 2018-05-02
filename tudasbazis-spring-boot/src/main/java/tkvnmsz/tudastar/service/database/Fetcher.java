package tkvnmsz.tudastar.service.database;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface Fetcher<DataType> {
	DataType processData(ResultSet resultSet) throws SQLException;
}
