package com.cmcdelhi.quasar.action;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cmcdelhi.quasar.payMode.CardMode;
import com.cmcdelhi.quasar.payMode.OnlineMode;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

public class OnlineModeAction extends ActionSupport implements
		ServletRequestAware, SessionAware {

	long transactionId;
	// This is not done by Gufran Khurshid
	long reicptNumber;

	HttpServletRequest request;

	// this is the same session maintained throughout the student registration.
	Map registrationSessionMap;

	public String execute() {
		System.out.println("Inside execute method  of OnlineModeAction");

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

				OnlineMode om = new OnlineMode();
				// I expected the Reciept Numbeber to be STring but the guys
				// have made it long
				// exactly I don't know some for time being let it be String
				om.setRecieptNumber(reicptNumber + "");
				om.setTrasactionID(transactionId);
				om.setPayment(loadedStudent.getPaymentsList().get(0));

				loadedStudent.getPaymentsList().get(0).setPaymentMode(om);

				registrationSessionMap.put(
						"shagirdregistrationpaymentpaymentmode", om);

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

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getReicptNumber() {
		return reicptNumber;
	}

	public void setReicptNumber(long reicptNumber) {
		this.reicptNumber = reicptNumber;
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
