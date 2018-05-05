package tkvnmsz.tudastar.service;

import java.util.List;
import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.report.Report;
import tkvnmsz.tudastar.report.ReportPostData;
import tkvnmsz.tudastar.report.ReportService;
import tkvnmsz.tudastar.service.database.ListDataFetcher;
import tkvnmsz.tudastar.service.database.OracleDatabase;
import tkvnmsz.tudastar.service.database.Parser;
import tkvnmsz.tudastar.service.database.SimpleDataFetcher;

@Service
public class ReportServiceDummy implements ReportService {
	

	@Override
	public void report(ReportPostData reportPostData, int senderId) {
		int mistakeID;
		int reportID;
		
		
		SimpleDataFetcher<Integer> idFetcher = new SimpleDataFetcher<>(resultSet -> resultSet.getInt(1));
		OracleDatabase.request("SELECT MAX(ID) FROM W_MISTAKE", idFetcher);
		mistakeID = idFetcher.getData();
		
		SimpleDataFetcher<Integer> idFetcher2 = new SimpleDataFetcher<>(resultSet -> resultSet.getInt(1));
		OracleDatabase.request("SELECT MAX(REPORT_ID) FROM W_REPORT", idFetcher2);
		reportID = idFetcher2.getData();
		
		
		OracleDatabase.execute(
				"Insert into H675212.W_MISTAKE (ID, DESCRIPTION, APPROVED, TARGET_ARTICLE_ID) values (?,?,?,?)",
				stmt -> {
					int index = 0;
					stmt.setInt(++index, mistakeID + 1);
					stmt.setString(++index, reportPostData.getDescription());
					stmt.setInt(++index, 1);
					stmt.setInt(++index, reportPostData.getTargetId());
					
				});
		
		
		
		OracleDatabase.execute(
				"Insert into H675212.W_REPORT (REPORT_ID, MISTAKE_ID, USER_ID) values (?,?,?)",
				stmt -> {
					int index = 0;
					stmt.setInt(++index, reportID + 1);
					stmt.setInt(++index, mistakeID + 1);
					stmt.setInt(++index, senderId);
					
				});
	}

	@Override
	public List<Report> listReports() {

		ListDataFetcher<Report> categoryFetcher = new ListDataFetcher<>(Parser::Report);
		OracleDatabase.request(
				"SELECT W_MISTAKE.ID, W_MISTAKE.DESCRIPTION, W_MISTAKE.TARGET_ARTICLE_ID, W_REPORT.USER_ID  FROM W_MISTAKE, W_REPORT WHERE W_REPORT.MISTAKE_ID = W_MISTAKE.ID",
				categoryFetcher);
		return categoryFetcher.getData();

	}

	@Override
	public void deleteReport(int reportId) {
		OracleDatabase.execute("DELETE FROM W_REPORT WHERE W_REPORT.MISTAKE_ID = ? ", stmt -> stmt.setInt(1, reportId));
		OracleDatabase.execute("DELETE FROM W_MISTAKE WHERE W_MISTAKE.ID = ? ", stmt -> stmt.setInt(1, reportId));
		
	}

}
