/**
 * 
 */
package com.cmcdelhi.quasar.action;

import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cmcdelhi.quasar.payMode.CardMode;
import com.cmcdelhi.quasar.payMode.ChequeMode;
import com.cmcdelhi.quasar.payMode.ChequeStatus;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author BHASKAR MILKHA
 * @author Gufran Khurshid
 * 
 */
public class ChequeAction extends ActionSupport implements ServletRequestAware,
		SessionAware {
	private long chequeNumber;
	private String bankName;
	private Date issueDate;

	HttpServletRequest request;

	// this is the same session maintained throughout the student registration.
	Map registrationSessionMap;

	public String execute() {
		System.out.println("Inside execute method  of ChequeModeAction");

		// check for valid session
		if (registrationSessionMap.get("REGISTERING_STUDENT_EMAIL") == null) {
			// it means no session is associated with the request and return
			// him
			// back
			return "nosession";
		} else {
			try {

				// if available then fetch the student object
				Student loadedStudent = (Student) registrationSessionMap
						.get("shagird");

				System.out.println("Size : "
						+ loadedStudent.getPaymentsList().size());

				ChequeMode cm = new ChequeMode();
				cm.setBankName(bankName);
				cm.setChequeNumber(chequeNumber);
				cm.setChequeStatus(ChequeStatus.UNCLEARED);
				cm.setIssueDate(issueDate);
				cm.setExpriyDate(null);
				cm.setPayment(loadedStudent.getPaymentsList().get(0));

				loadedStudent.getPaymentsList().get(0).setPaymentMode(cm);

				registrationSessionMap.put(
						"shagirdregistrationpaymentpaymentmode", cm);

				Enumeration enm = request.getParameterNames();

				while (enm.hasMoreElements()) {
					String paramName = (String) enm.nextElement();
					String paramValue = request.getParameter(paramName);
					System.out.println(paramName + "  :  " + paramValue);
				}

				return SUCCESS;
			} catch (Exception e) {
				System.out.println("Exception " + e.getMessage());
			}

		}

		return INPUT;

	}

	/**
	 * @return the chequeNumber
	 */
	public long getChequeNumber() {
		return chequeNumber;
	}

	/**
	 * @param chequeNumber
	 *            the chequeNumber to set
	 */
	public void setChequeNumber(long chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName
	 *            the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the issueDate
	 */
	public Date getIssueDate() {
		return issueDate;
	}

	/**
	 * @param issueDate
	 *            the issueDate to set
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		registrationSessionMap = arg0;
	}

}
