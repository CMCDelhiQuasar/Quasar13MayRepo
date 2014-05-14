package com.cmcdelhi.quasar.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.service.PaymentService;
import com.opensymphony.xwork2.ActionSupport;

public class PrepareDuePaymentAction extends ActionSupport implements
		ServletRequestAware, SessionAware {

	long paymentId;

	// the request Object
	HttpServletRequest request;

	// this is for maintaining the sesson throughout the student payment.
	Map duePaymentSessionMap;

	@Override
	public String execute() throws Exception {

		System.out.println("------------------------------------>>>>>>");

		// ///------->>>>> Check for the Key <<<<<-------------///

		System.out.println("Inside Due Payment Session ");

		// First Fire Query to obtain the Student Object
		PaymentService ps = new PaymentService();
		Payment p = ps.getPayment(0, paymentId, null, 0, 0, null, null, 0, 0,
				null, 0, 0, 0, 0, null).get(0);

		// put student email in session key
		duePaymentSessionMap.put("REGISTERING_STUDENT_EMAIL", p.getStudent()
				.getEmailId());

		// put it with the session
		duePaymentSessionMap.put("shagird", p.getStudent());
		
		duePaymentSessionMap.put("payment", p);

		duePaymentSessionMap.put("DUE_TAG",
				"DUE PAYMENT OF  PAYMENT ID " + p.getPaymentID());

		// setting the student object in session
		// registrationSessionMap.put("REGISTERING_STUDENT_EMAIL",
		// getStudentemail());
		// registrationSessionMap.put("shagird", s);
		// registrationSessionMap
		// .put("shagirdregistrationpayment", rp);
		//
		// registrationSessionMap.put(
		// "shagirdregistrationfullfeepayment", ffp);

		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		duePaymentSessionMap = arg0;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

}
