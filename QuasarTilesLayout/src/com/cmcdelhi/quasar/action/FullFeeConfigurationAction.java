package com.cmcdelhi.quasar.action;

import java.text.ParseException;
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
 * 
 * @author Gufran Khurshid
 * 
 */

public class FullFeeConfigurationAction extends ActionSupport implements
		ServletRequestAware, SessionAware {

	double proposedAmount;
	Date proposedDate;
	String comment;

	HttpServletRequest request;

	// this is the same session maintained throughout the student registration.
	Map registrationSessionMap;

	public String execute() {

		System.out
				.println("Inside execute method  of FullFeeConfigurationAction");

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

				loadedStudent.getPaymentsList().get(1).getPaymentDetails()
						.setDepositedAmount(0);
				loadedStudent.getPaymentsList().get(1).getPaymentDetails()
						.setProposedAmount(proposedAmount);
				loadedStudent.getPaymentsList().get(1).getPaymentDetails()
						.setProposedDate(proposedDate);
				loadedStudent.getPaymentsList().get(1)
						.setPaymentComment(comment);
				loadedStudent.setPaymentStatus(PaymentStatus.FULLPAID);

				Enumeration enm = request.getParameterNames();

				while (enm.hasMoreElements()) {
					String paramName = (String) enm.nextElement();

					String paramValue = request.getParameter(paramName);

					System.out.println(paramName + "  :  " + paramValue);
				}

				return "success";

			} catch (DateException e) {
				e.printStackTrace();
			}
		}

		return ERROR;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		registrationSessionMap = arg0;
	}

	public double getProposedAmount() {
		return proposedAmount;
	}

	public void setProposedAmount(double proposedAmount) {
		this.proposedAmount = proposedAmount;
	}

	public Date getProposedDate() {
		return proposedDate;
	}

	public void setProposedDate(Date proposedDate) {
		this.proposedDate = proposedDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
