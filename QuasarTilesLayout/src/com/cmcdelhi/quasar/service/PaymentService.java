package com.cmcdelhi.quasar.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.paymentDetails.PaymentStatus;
import com.cmcdelhi.quasar.student.QuasarConnectionManager;
import com.cmcdelhi.quasar.student.Student;

public class PaymentService {

	QuasarConnectionManager quasarConnectionManager;

	public PaymentService() {
		quasarConnectionManager = QuasarConnectionManager.getInstance();
	}

	// hey the paymentDate,proposedDate must be in yyyy-MM-dd
	public List<Payment> getPayment(long studentId, long paymentId,
			PaymentStatus paymentStatus, double depositedAmount,
			double proposedAmount, String paymentDate, String proposedDate,
			long ddNumber, double cashAmount, String bankName,
			long chequeNumber, long receiptNumber, long transactionId,
			long cardNumber, String paymentComment) {

		Criteria c = quasarConnectionManager.getSession().createCriteria(
				Payment.class, "payment");
		c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

		if (studentId != 0) {
			c.add(Restrictions.eq("payment.student.studentId", paymentId));
		}

		if (paymentId != 0) {
			c.add(Restrictions.eq("payment.paymentID", paymentId));
		}

		if (paymentStatus != null) {
			c.add(Restrictions.eq("payment.paymentStatus", paymentStatus));
		}

		if (depositedAmount != 0.0) {
			c.add(Restrictions.eq("payment.paymentDetails.depositedAmount",
					depositedAmount));
		}

		if (proposedAmount != 0.0) {
			c.add(Restrictions.eq("payment.paymentDetails.proposedAmount",
					proposedAmount));
		}

		if (paymentComment != null && !paymentComment.equals("")) {
			c.add(Restrictions.eq("payment.paymentComment", paymentComment));
		}

		// //////////////////////////////////////////////////////////

		if (paymentDate != null && !paymentDate.equals("")) {
			// c.add(Restrictions.eq("payment.paymentDetails.paymentDate",
			// paymentDate));
			//

			try {
				;
				Date minDate = new SimpleDateFormat("dd/MM/yyyy")
						.parse(paymentDate);

				Date maxDate = new Date(minDate.getTime()
						+ TimeUnit.DAYS.toMillis(1));

				Conjunction and = Restrictions.conjunction();
				and.add(Restrictions.ge("paymentDetails.paymentDate", minDate));
				and.add(Restrictions.lt("paymentDetails.paymentDate", maxDate));

				c.add(and);

			} catch (Exception e) {
			}

		}

		if (proposedDate != null && !proposedDate.equals("")) {
			// c.add(Restrictions.eq("payment.paymentDetails.proposedDate",
			// proposedDate));

			try {
				;
				Date minDate = new SimpleDateFormat("dd/MM/yyyy")
						.parse(proposedDate);

				Date maxDate = new Date(minDate.getTime()
						+ TimeUnit.DAYS.toMillis(1));

				Conjunction and = Restrictions.conjunction();
				and.add(Restrictions.ge("paymentDetails.proposedDate", minDate));
				and.add(Restrictions.lt("paymentDetails.proposedDate", maxDate));

				c.add(and);

			} catch (Exception e) {
			}

		}

		// /////////////////////////////////////////////////////////////////////////////////

		if (ddNumber != 0) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.DDNumber", ddNumber));
		}

		if (cashAmount != 0.0) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.cashAmount", cashAmount));
		}

		if (bankName != null && !bankName.equals("")) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.bankName", bankName));
		}

		if (chequeNumber != 0) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.chequeNumber", chequeNumber));
		}

		if (cardNumber != 0) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.cardNumber", cardNumber));
		}

		if (receiptNumber != 0) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.recieptNumber", receiptNumber
					+ ""));
		}

		if (transactionId != 0) {
			c.createAlias("payment.paymentMode", "paymentMode");
			c.add(Restrictions.eq("paymentMode.trasactionID", transactionId));
		}

		return c.list();
	}
}
