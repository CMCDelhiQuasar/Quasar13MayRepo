package com.cmcdelhi.quasar.payMode;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmcdelhi.quasar.exceptions.InvalidNumberException;
import com.cmcdelhi.quasar.exceptions.PaymentModeNumberException;

/**
 * 
 * @author Gufran Khurshid
 * @version 1.0
 * @Date 4 April 2013
 */

@Entity
public class CardMode extends PaymentMode {

	private long cardNumber;
	private long transactionID;
	@Temporal(TemporalType.DATE)
	private Date cardExpiryDate;

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) throws InvalidNumberException {
		if (cardNumber > 0) {
			this.cardNumber = cardNumber;
		} else {
			throw new InvalidNumberException(
					"The Card Number cannot be less than ZERO");
		}

	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) throws InvalidNumberException {

		if (transactionID > 0) {
			this.transactionID = transactionID;
		} else {
			throw new InvalidNumberException(
					"The Card Number cannot be less than ZERO");
		}

	}

	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

}
