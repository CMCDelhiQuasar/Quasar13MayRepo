package com.cmcdelhi.quasar.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.student.QuasarConnectionManager;
import com.opensymphony.xwork2.ActionSupport;

public class DuePaymentAction extends ActionSupport implements
		ServletRequestAware, SessionAware {

	// the request Object
	HttpServletRequest request;

	// this is for maintaining the sesson throughout the student payment.
	Map duePaymentSessionMap;

	@Override
	public String execute() throws Exception {

		System.out.println("------------------------------------>>>>>>");

		// ///------->>>>> Check for the Key <<<<<-------------///

		System.out.println("Inside Due Payment Action ");

		System.out
				.println("Raat ho chuki hai .. .. . around 1:50 ho raha hai .. . . the song is sexy. . .. isko jaldi se khatam karta hu. . ..  bhuk bhi lagi hai . . . kahana to kisi tarah bana liya hai. . . . khana kahana bhi padega na !. .. . .. but  kuch bhi ho .  .. .  this feeling is unparallel ! ");

		// check for valid session
		if (duePaymentSessionMap.get("REGISTERING_STUDENT_EMAIL") == null) {
			// it means no session is associated with the request and return
			// him
			// back
			return "nosession";
		} else {

			Payment p = null;
			// searching for whether is this registration paymnent or due
			// payment
			String dueTag = (String) duePaymentSessionMap.get("DUE_TAG");
			if (dueTag == null) {
				// it means no session is associated with the request and return
				// him
				// back
				return "nosession";
			} else {
				p = (Payment) duePaymentSessionMap.get("payment");
				System.out.println("This is Due Payment  " + dueTag);

				System.out
						.println("Trying to insert the updated  Pament Object ");

				Session session = QuasarConnectionManager.getInstance()
						.getSession();
				session.beginTransaction();

				Query q = session
						.createQuery("from Payment where paymentId = :paymentId ");
				q.setParameter("paymentId", p.getPaymentID());

				Payment p2 = (Payment) q.list().get(0);

				p2.setPaymentComment(p.getPaymentComment());
				p2.setPaymentDetails(p.getPaymentDetails());

				session.update(p2);
				session.getTransaction().commit();

				return SUCCESS;
			}

		}

		// setting the student object in session
		// registrationSessionMap.put("REGISTERING_STUDENT_EMAIL",
		// getStudentemail());
		// registrationSessionMap.put("shagird", s);
		// registrationSessionMap
		// .put("shagirdregistrationpayment", rp);
		//
		// registrationSessionMap.put(
		// "shagirdregistrationfullfeepayment", ffp);

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		duePaymentSessionMap = arg0;
	}

}
