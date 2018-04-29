package tkvnmsz.tudastar.report;

import java.util.List;

public interface ReportService {
	/**
	 * Send report
	 * @param reportPostData
	 * @param senderId TODO
	 */
	void report(ReportPostData reportPostData, int senderId);
	
//	/**
//	 * Confirm the report
//	 * @param reportId
//	 */
//	void confirm(int reportId);
//	
//	/**
//	 * Correcting the reported mistake
//	 * @param reportId
//	 */
//	void correct(int reportId);
//	
//	/**
//	 * List the reports that are not confirmed yet
//	 * @return list of reports
//	 */
//	List<Report> listNotConfirmed();
//	
//	/**
//	 * List the reports that are not corrected yet
//	 * @return list of reports
//	 */
//	List<Report> listNotCorrected();
	
	/**
	 * List reports that can be seen by the user
	 * @return
	 */
	List<Report> listReports();
	
	void deleteReport(int reportId);
	
}
