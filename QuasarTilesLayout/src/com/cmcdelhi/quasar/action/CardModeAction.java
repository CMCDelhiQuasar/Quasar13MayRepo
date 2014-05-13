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

import com.cmcdelhi.quasar.exceptions.DateException;
import com.cmcdelhi.quasar.payMode.CardMode;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author BHASKAR MILKHA
 * 
 */
public class CardModeAction extends ActionSupport implements
		ServletRequestAware, SessionAware {
	private String cardType;
	private long cardNumber;
	private long transactionId;
	private Date cardExpiryDate;

	HttpServletRequest request;
	
	
	//Simple 

	// this is the same session maintained throughout the student registration.
	Map registrationSessionMap;

	public String execute() {
		System.out.println("Inside execute method  of CardModeAction");

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

				CardMode cm = new CardMode();
				cm.setCardNumber(cardNumber);
				cm.setTransactionID(transactionId);
				cm.setCardExpiryDate(cardExpiryDate);
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
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @param cardType
	 *            the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the cardNumber
	 */
	public long getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber
	 *            the cardNumber to set
	 */
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the transactionId
	 */
	public long getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId
	 *            the transactionId to set
	 */
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the cardExpiryDate
	 */
	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}

	/**
	 * @param cardExpiryDate
	 *            the cardExpiryDate to set
	 */
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
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
