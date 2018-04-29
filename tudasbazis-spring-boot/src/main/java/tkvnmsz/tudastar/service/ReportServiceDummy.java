package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.report.Report;
import tkvnmsz.tudastar.report.ReportPostData;
import tkvnmsz.tudastar.report.ReportService;

@Service
public class ReportServiceDummy implements ReportService{
	private List<Report> reports = new ArrayList<>();
	
	public ReportServiceDummy() {
		populate();
	}
		
	private void populate() {
		Report report;
		
		report = new Report();
		report.setDescription("leiras");
		report.setTargetId(0);
		report.setUserId(1);
		report.setId(reports.size());
		reports.add(report);
	}

	@Override
	public void report(ReportPostData reportPostData, int senderId) {
		Report report = new Report();
		report.setDescription(reportPostData.getDescription());
		report.setTargetId(reportPostData.getTargetId());
		report.setUserId(senderId);
		report.setId(reports.size());
		
		reports.add(report);
	}

	@Override
	public List<Report> listReports() {
		return reports;
	}

	@Override
	public void deleteReport(int reportId) {
		reports.remove(reportId);
	}
	
}
