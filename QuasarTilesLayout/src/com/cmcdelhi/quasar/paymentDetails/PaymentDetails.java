package com.cmcdelhi.quasar.paymentDetails;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmcdelhi.quasar.exceptions.DateException;

@Embeddable
public class PaymentDetails {

	@Temporal(TemporalType.DATE)
	private Date proposedDate;
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	private double proposedAmount;
	private double depositedAmount;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	public Date getProposedDate() {
		return proposedDate;
	}

	public void setProposedDate(Date proposedDate) throws DateException {
		if (proposedDate.after(new Date())) {
			this.proposedDate = proposedDate;
		} else {
			throw new DateException(
					"Proposed Date cannot be before todays date .");
		}

	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) throws DateException {

		if (paymentDate.after(new Date())) {
			this.paymentDate = paymentDate;
		} else {
			throw new DateException(
					"Payment Date cannot be before todays date .");
		}

	}

	public double getProposedAmount() {
		return proposedAmount;
	}

	public void setProposedAmount(double proposedAmount) {
		this.proposedAmount = proposedAmount;
	}

	public double getDepositedAmount() {
		return depositedAmount;
	}

	public void setDepositedAmount(double depositedAmount) {
		this.depositedAmount = depositedAmount;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
