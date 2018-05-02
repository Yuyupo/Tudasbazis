package tkvnmsz.tudastar.service;

import java.util.List;

import tkvnmsz.tudastar.report.Report;
import tkvnmsz.tudastar.report.ReportPostData;
import tkvnmsz.tudastar.report.ReportService;

public class ReportServiceOracle implements ReportService{

	@Override
	public void report(ReportPostData reportPostData, int senderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Report> listReports() {
//		SELECT W_REPORT.REPORT_ID REPORT_ID,
//		W_MISTAKE.DESCRIPTION DESCRIPTION,
//		W_MISTAKE.TARGET_ARTICLE_ID TARGET_ARTICLE_ID,
//		
//		W_REPORT.USER_ID USER_ID FROM W_MISTAKE LEFT OUTER JOIN W_REPORT ON W_REPORT.MISTAKE_ID = W_MISTAKE.ID
		return null;
	}

	@Override
	public void deleteReport(int reportId) {
		// TODO Auto-generated method stub
		
	}

}
