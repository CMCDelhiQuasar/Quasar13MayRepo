package com.cmcdelhi.quasar.action;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.cmcdelhi.quasar.payMode.PaymentMode;
import com.cmcdelhi.quasar.paymentDetails.FullFeePayment;
import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.paymentDetails.PaymentStatus;
import com.cmcdelhi.quasar.paymentDetails.RegistrationPayment;
import com.cmcdelhi.quasar.student.QuasarConnectionManager;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegistrationAction extends ActionSupport implements
		ServletRequestAware, SessionAware {

	HttpServletRequest request;

	// this is the same session maintained throughout the student registration.
	Map registrationSessionMap;

	@Override
	public String execute() throws Exception {
		System.out.println("Inside execute method  of Registration Action ");

		// check for valid session
		if (registrationSessionMap.get("REGISTERING_STUDENT_EMAIL") == null) {
			// it means no session is associated with the request and return
			// him
			// back
			return "nosession";
		} else {
			try {

				// Establishing the Connection with Quasar Connection Manager
				QuasarConnectionManager quasarConnectionManager = QuasarConnectionManager
						.getInstance();
				Session s = quasarConnectionManager.getSession();
				s.beginTransaction();

				Integer numOfInstallments = (Integer) registrationSessionMap
						.get("NUMBER_OF_INSTALLMENTS");

				System.out.println("Number opf Install :" + numOfInstallments);

				// if available then fetch the student object
				Student loadedStudent = (Student) registrationSessionMap
						.get("shagird");

				PaymentMode registrationPaymentMode = (PaymentMode) registrationSessionMap
						.get("shagirdregistrationpaymentpaymentmode");

				RegistrationPayment loadedRegistrationPayment = (RegistrationPayment) registrationSessionMap
						.get("shagirdregistrationpayment");

				if (numOfInstallments == null) {
					// it means full fee payment
					loadedStudent.setPaymentStatus(PaymentStatus.FULLPAID);
					FullFeePayment loadedffp = (FullFeePayment) registrationSessionMap
							.get("shagirdregistrationfullfeepayment");
					loadedffp.setPaymentStatus(PaymentStatus.PAID);
					s.save(loadedffp);

				} else {
					// installment type of payment is being made
					ArrayList<Payment> allInstallmentsList = (ArrayList<Payment>) registrationSessionMap
							.get("allInstallmentsList");
					if (allInstallmentsList != null) {
						for (Payment p : allInstallmentsList) {
							s.save(p);
						}
					}

				}

				s.save(registrationPaymentMode);
				s.save(loadedRegistrationPayment);
				s.save(loadedStudent);

				s.getTransaction().commit();

				ActionContext.getContext().getValueStack()
						.set("email", loadedStudent.getEmailId());

				// removing the session objects
				registrationSessionMap.remove("NUMBER_OF_INSTALLMENTS");
				registrationSessionMap.remove("shagird");
				registrationSessionMap
						.remove("shagirdregistrationpaymentpaymentmode");
				registrationSessionMap.remove("shagirdregistrationpayment");
				registrationSessionMap
						.remove("shagirdregistrationfullfeepayment");
				registrationSessionMap.remove("allInstallmentsList");
				registrationSessionMap.remove("REGISTERING_STUDENT_EMAIL");

				return SUCCESS;

			} catch (Exception e) {
				System.out.println("Exception " + e.getMessage());
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
}
// /////////Till Now 15 April 2014 1 AM I dont need this shit
// //////////////////////////////////////////////////////////////////////////////
// if (pm instanceof CashMode) {
// CashMode cashMode = (CashMode) pm;
//
// quasarConnectionManager.save(cashMode);
// } else if (pm instanceof CardMode) {
// CardMode cardMode = (CardMode) pm;
// quasarConnectionManager.save(cardMode);
// } else if (pm instanceof OnlineMode) {
// OnlineMode onlineMode = (OnlineMode) pm;
// quasarConnectionManager.save(onlineMode);
// } else if (pm instanceof DDMode) {
// DDMode ddmode = (DDMode) pm;
// quasarConnectionManager.save(ddmode);
// } else if (pm instanceof ChequeMode) {
// ChequeMode chequeMode = (ChequeMode) pm;
// quasarConnectionManager.save(chequeMode);
// }
// /////////////////////////////////////////////////////////////////////////////////
