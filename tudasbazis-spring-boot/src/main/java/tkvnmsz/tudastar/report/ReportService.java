package tkvnmsz.tudastar.report;

import java.util.List;

public interface ReportService {
	/**
	 * Send report
	 * @param reportPostData
	 * @return the newly created report's id
	 */
	int report(ReportPostData reportPostData);
	
	/**
	 * Confirm the report
	 * @param reportId
	 */
	void confirm(int reportId);
	
	/**
	 * Correcting the reported mistake
	 * @param reportId
	 */
	void correct(int reportId);
	
	/**
	 * List the reports that are not confirmed yet
	 * @return list of reports
	 */
	List<Report> listNotConfirmed();
	
	/**
	 * List the reports that are not corrected yet
	 * @return list of reports
	 */
	List<Report> listNotCorrected();
}
