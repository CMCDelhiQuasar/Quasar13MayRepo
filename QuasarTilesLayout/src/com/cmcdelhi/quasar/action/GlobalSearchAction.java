package com.cmcdelhi.quasar.action;

import java.util.ArrayList;
import java.util.List;

import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.service.PaymentService;
import com.cmcdelhi.quasar.service.StudentService;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

public class GlobalSearchAction extends ActionSupport {

	String queryString;
	List<Student> queryResultStudentList;
	List<Payment> queryResultPaymentList;

	@Override
	public String execute() throws Exception {

		queryResultStudentList = new ArrayList<Student>();
		queryResultPaymentList = new ArrayList<Payment>();

		if (!queryString.trim().equals("")) {

			queryString = queryString.trim();

			StudentService ss = new StudentService();
			// q can be email
			if (queryString.contains("@")) {

				queryResultStudentList.addAll(ss.getStudent(null, 0,
						queryString.trim(), 0, null, 0, null, 0));
			}

			try {
				// can be Student Id
				long qvalue = Long.parseLong(queryString);
				queryResultStudentList.addAll(ss.getStudent(null, qvalue, null,
						0, null, 0, null, 0));
				// can be contact no
				queryResultStudentList.addAll(ss.getStudent(null, 0, null, 0,
						null, qvalue, null, 0));
			} catch (NumberFormatException e) {
			}

			try {
				// can be Course Fees
				double qvalueDouble = Double.parseDouble(queryString);
				queryResultStudentList.addAll(ss.getStudent(null, 0, null,
						qvalueDouble, null, 0, null, 0));
			} catch (NumberFormatException e) {
			}

			// Student Name
			queryResultStudentList.addAll(ss.getStudent(queryString.trim(), 0,
					null, 0, null, 0, null, 0));

			// course name
			queryResultStudentList.addAll(ss.getStudent(null, 0, null, 0,
					queryString, 0, null, 0));

			PaymentService ps = new PaymentService();
			// Date of Registration/ Payment Date
			if (queryString.contains("/")) {
				queryResultPaymentList.addAll(ps.getPayment(0, 0, null, 0, 0,
						queryString, null, 0, 0, null, 0, 0, 0, 0, null));
			}
			// Payment ID
			try {
				// can be payment Id
				long qvalue = Long.parseLong(queryString);
				queryResultPaymentList.addAll(ps.getPayment(0, qvalue, null, 0,
						0, null, null, 0, 0, null, 0, 0, 0, 0, null));
				// / DD No
				queryResultPaymentList.addAll(ps.getPayment(0, 0, null, 0, 0,
						null, null, qvalue, 0, null, 0, 0, 0, 0, null));
				// Card Number
				queryResultPaymentList.addAll(ps.getPayment(0, 0, null, 0, 0,
						null, null, 0, 0, null, 0, 0, 0, qvalue, null));

				// Reciept Number
				queryResultPaymentList.addAll(ps.getPayment(0, 0, null, 0, 0,
						null, null, 0, 0, null, 0, qvalue, 0, 0, null));

			} catch (NumberFormatException e) {
			}

			try {
				// can be Proposed Amount
				double qvalueDouble = Double.parseDouble(queryString);
				queryResultPaymentList
						.addAll(ps.getPayment(0, 0, null, 0, qvalueDouble,
								null, null, 0, 0, null, 0, 0, 0, 0, null));

				// can be Deposited Amount Amount
				queryResultPaymentList.addAll(ps.getPayment(0, 0, null,
						qvalueDouble, 0, null, null, 0, 0, null, 0, 0, 0, 0,
						null));

			} catch (NumberFormatException e) {
			}

			// Comments
			queryResultPaymentList.addAll(ps.getPayment(0, 0, null, 0, 0, null,
					null, 0, 0, null, 0, 0, 0, 0, queryString));

			// Bank Name
			queryResultPaymentList.addAll(ps.getPayment(0, 0, null, 0, 0, null,
					null, 0, 0, queryString, 0, 0, 0, 0, null));

			return SUCCESS;
		} else {
			return SUCCESS;
		}

	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public List<Student> getQueryResultStudentList() {
		return queryResultStudentList;
	}

	public void setQueryResultStudentList(List<Student> queryResultStudentList) {
		this.queryResultStudentList = queryResultStudentList;
	}

	public List<Payment> getQueryResultPaymentList() {
		return queryResultPaymentList;
	}

	public void setQueryResultPaymentList(List<Payment> queryResultPaymentList) {
		this.queryResultPaymentList = queryResultPaymentList;
	}

}
