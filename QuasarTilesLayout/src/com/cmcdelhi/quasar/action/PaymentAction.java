/**
 * 
 */
package com.cmcdelhi.quasar.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cmcdelhi.quasar.exceptions.DateException;
import com.cmcdelhi.quasar.paymentDetails.PaymentStatus;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author BHASKAR MILKHA
 * @author Gufran Khurshid
 * 
 */
public class PaymentAction extends ActionSupport implements
		ServletRequestAware, SessionAware {

	private int proposedAmount;
	private int depositedAmount;
	private Date proposedDate;
	private Date paymentDate;
	private String paymentMode;
	private String comments;

	HttpServletRequest request;

	// this is the same session maintained throughout the student registration.
	Map registrationSessionMap;

	public String execute() {

		System.out.println("Inside execute method  of PaymentAction");

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

				// setting the registration payment comment
				loadedStudent.getPaymentsList().get(0)
						.setPaymentComment(comments);

				// setting the registration payment deposited amount
				loadedStudent.getPaymentsList().get(0).getPaymentDetails()
						.setDepositedAmount(depositedAmount);

				// setting the registration payment proposed date
				loadedStudent.getPaymentsList().get(0).getPaymentDetails()
						.setProposedDate(proposedDate);

				// setting the registration payment deposited amount
				loadedStudent.getPaymentsList().get(0).getPaymentDetails()
						.setPaymentDate(paymentDate);

				// setting the registration payment time stamp
				loadedStudent.getPaymentsList().get(0).getPaymentDetails()
						.setTimeStamp(new Date());

				// setting the reg istration payment payment status
				loadedStudent.getPaymentsList().get(0)
						.setPaymentStatus(PaymentStatus.PAID);

				loadedStudent.setPaymentStatus(PaymentStatus.REGISTRATIONPAID);

				Enumeration enm = request.getParameterNames();

				while (enm.hasMoreElements()) {
					String paramName = (String) enm.nextElement();
					String paramValue = request.getParameter(paramName);
					System.out.println(paramName + "  :  " + paramValue);
				}

				switch (paymentMode) {
				case "cash":
					return "kagazkasona";
				case "online":
					return "katarmein";
				case "cheque":
					return "sunishchitkaro";
				case "dd":
					return "ddyadavjiphysicswaale";
				case "card":
					return "taashkepatte";
				default:
					break;
				}

			} catch (DateException e) {
				System.out.println("Date Exception " + e.getMessage());
			} catch (Exception e) {
				System.out.println("Exception " + e.getMessage());
			}

		}

		return "input";
	}

	/**
	 * @return the proposedAmount
	 */
	public int getProposedAmount() {
		return proposedAmount;
	}

	/**
	 * @param proposedAmount
	 *            the proposedAmount to set
	 */
	public void setProposedAmount(int proposedAmount) {
		this.proposedAmount = proposedAmount;
	}

	/**
	 * @return the depositedAmount
	 */
	public int getDepositedAmount() {
		return depositedAmount;
	}

	/**
	 * @param depositedAmount
	 *            the depositedAmount to set
	 */
	public void setDepositedAmount(int depositedAmount) {
		this.depositedAmount = depositedAmount;
	}

	/**
	 * @return the proposedDate
	 */
	public Date getProposedDate() {
		return proposedDate;
	}

	/**
	 * @param proposedDate
	 *            the proposedDate to set
	 */
	public void setProposedDate(Date proposedDate) {
		this.proposedDate = proposedDate;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate
	 *            the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode
	 *            the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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
