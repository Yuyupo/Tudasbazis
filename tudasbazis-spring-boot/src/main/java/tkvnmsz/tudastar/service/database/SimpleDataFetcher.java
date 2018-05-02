package tkvnmsz.tudastar.service.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Endre
 */
public class SimpleDataFetcher<DataType> implements QueryResultProcessor {
	private DataType data = null;
	private Fetcher<DataType> fetcher;

	public SimpleDataFetcher(Fetcher<DataType> fetcher) {
		this.fetcher = fetcher;
	}

	public DataType getData() {
		return data;
	}

	@Override
	public final void process(ResultSet resultSet) throws SQLException {
		data = fetcher.processData(resultSet);
	}
}
