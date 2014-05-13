package com.cmcdelhi.quasar.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.student.QuasarConnectionManager;

///Author Gufran Khurshid 29 April 2014 

public class GraphingService {

	QuasarConnectionManager quasarConnectionManager;

	public GraphingService() {
		quasarConnectionManager = QuasarConnectionManager.getInstance();
	}

	public int getTotalStudentNoOfStudent() {
		return 0;
	}

	public int getTotalStudentNoOfStudentRegisteredOnADate(Date specifiedate) {
		Criteria c = quasarConnectionManager.getSession().createCriteria(
				Payment.class);
		c.add(Restrictions.eq("class", "RegistrationPayment"));
		try {

			Date minDate = specifiedate;

			Date maxDate = new Date(minDate.getTime()
					+ TimeUnit.DAYS.toMillis(1));

			Conjunction and = Restrictions.conjunction();
			and.add(Restrictions.ge("paymentDetails.paymentDate", minDate));
			and.add(Restrictions.lt("paymentDetails.paymentDate", maxDate));

			c.add(and);

			return c.list().size();

		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
			return 0;
		}

	}

	// // date in yyyy-MM-dd format 2014-04-30
	// public int getTotalStudentNoOfStudentRegisteredOnADate(String
	// specifiedate) {
	// Criteria c = quasarConnectionManager.getSession().createCriteria(
	// Payment.class);
	// try {
	//
	// Date minDate = new SimpleDateFormat("yyyy-MM-dd")
	// .parse(specifiedate);
	//
	// Date maxDate = new Date(minDate.getTime()
	// + TimeUnit.DAYS.toMillis(1));
	//
	// System.out.println(minDate);
	// System.out.println(maxDate);
	//
	// // System.out.println();
	//
	// Conjunction and = Restrictions.conjunction();
	// and.add(Restrictions.ge("paymentDetails.proposedDate", minDate));
	// and.add(Restrictions.lt("paymentDetails.proposedDate", maxDate));
	//
	// c.add(and);
	//
	// return c.list().size();
	//
	// } catch (Exception e) {
	// System.out.println("Exception " + e.getMessage());
	// return 0;
	// }
	//
	// }

	// date in yyyy-MM-dd format
	public int getTotalStudentNoOfStudentRegisteredBetwenDates(Date startDate,
			Date endDate) {

		Criteria c = quasarConnectionManager.getSession().createCriteria(
				Payment.class);
		c.add(Restrictions.eq("class", "RegistrationPayment"));

		try {

			Date minDate = startDate;

			Date maxDate = endDate;
			// increasing for next day
			maxDate = new Date(maxDate.getTime() + TimeUnit.DAYS.toMillis(1));

			System.out.println(minDate);
			System.out.println(maxDate);

			// System.out.println();

			Conjunction and = Restrictions.conjunction();
			and.add(Restrictions.ge("paymentDetails.paymentDate", minDate));
			and.add(Restrictions.lt("paymentDetails.paymentDate", maxDate));

			c.add(and);

			return c.list().size();

		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
			return 0;
		}

	}

	public int getTotalStudentNoOfStudentRegisteredOnADateForACourse(
			Date specifiedate, String courseName) {
		Criteria c = quasarConnectionManager.getSession().createCriteria(
				Payment.class, "payment");
		
		c.createAlias("payment.student", "student");
		c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		
		c.add(Restrictions.eq("class", "RegistrationPayment"));
		c.add(Restrictions.eq("student.courseName", courseName));
		try {

			Date minDate = specifiedate;

			Date maxDate = new Date(minDate.getTime()
					+ TimeUnit.DAYS.toMillis(1));

			Conjunction and = Restrictions.conjunction();
			and.add(Restrictions.ge("paymentDetails.paymentDate", minDate));
			and.add(Restrictions.lt("paymentDetails.paymentDate", maxDate));

			c.add(and);

			return c.list().size();

		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
			return 0;
		}

	}

}
