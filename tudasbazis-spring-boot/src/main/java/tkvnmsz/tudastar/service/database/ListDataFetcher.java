package tkvnmsz.tudastar.service.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Endre
 */
public class ListDataFetcher<DataType> implements QueryResultProcessor {

	private List<DataType> data;
	private Fetcher<DataType> fetcher;

	public ListDataFetcher(Fetcher<DataType> fetcher) {
		data = new ArrayList<>();
		this.fetcher = fetcher;
	}

	public List<DataType> getData() {
		return data;
	}

	@Override
	public void process(ResultSet resultSet) throws SQLException {
		data.add(fetcher.processData(resultSet));
	}

}
