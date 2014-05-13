package com.cmcdelhi.quasar.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.student.QuasarConnectionManager;

public class QuasarService {

	QuasarConnectionManager connectionManager;

	public QuasarService() {
		// Establishing the Connection with Quasar Connection Manager
		connectionManager = QuasarConnectionManager.getInstance();

	}

	// This is class simply returns all the Pending Payments
	public List<Payment> getPendingPayments() {

		Query query = connectionManager.getSession().createQuery(
				" from Payment where paymentStatus='PAID'");
		System.out.println("Payment Objects Size : " + query.list().size());
		return query.list();

	}

	// This is class simply returns certain number the Pending Payments
	ArrayList<Payment> getPendingPayments(int noOfResult) {
		return null;
	}

	// This is class simply returns certain number the Pending Payments from
	// start to end
	ArrayList<Payment> getPendingPayments(int startResult, int noOfResult) {
		return null;
	}

	// This is class simply returns all the Pending Payments based on a Date
	ArrayList<Payment> getPendingPayments(Date d) {
		return null;
	}

	ArrayList<Payment> getPendingPayments(Date d, int noOfResult) {
		return null;
	}

	ArrayList<Payment> getPendingPayments(Date d, int startResult,
			int noOfResult) {
		return null;
	}

	ArrayList<Payment> getPendingPayments(Date startDate, Date endDate) {
		return null;
	}

	ArrayList<Payment> getPendingPayments(Date startDate, Date endDate,
			int noOfResult) {
		return null;
	}

	ArrayList<Payment> getPendingFees(Date startDate, Date endDate,
			int noOfResultint, int startResult) {
		return null;
	}

}
