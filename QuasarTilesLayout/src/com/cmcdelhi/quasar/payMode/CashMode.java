/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmcdelhi.quasar.payMode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinTable;

import com.cmcdelhi.quasar.exceptions.CashAmountException;
import com.cmcdelhi.quasar.exceptions.CashDetailException;

/**
 * 
 * @author Gufran Khurshid
 * @version 1.0
 * @Date 4 April 2013
 */
@Entity
public class CashMode extends PaymentMode {

	private double cashAmount;

	@ElementCollection
	@JoinTable(name = "CASH_DETAILS")
	private Map<Note, Integer> cashDetail = new HashMap<Note, Integer>();

	public void setCashAmount(double cashAmount) throws CashAmountException {
		if (cashAmount > 0) {
			this.cashAmount = cashAmount;
		} else {
			throw new CashAmountException(
					"Cash amount cannot be less than zero.");
		}
	}

	public double getCashAmount() {
		return cashAmount;
	}

	public Map<Note, Integer> getCashDetail() {
		return cashDetail;
	}

	public void setCashDetail(Map<Note, Integer> cashDetail)
			throws CashDetailException {
		// calculating cashDetail is in accordance with the cash Set.
		int cashTotal = 0;
		Set<Note> allNotes = (Set<Note>) cashDetail.keySet();

		Iterator i = allNotes.iterator();

		while (i.hasNext()) {
			Note note = (Note) i.next();
			Integer numberOfNotes = cashDetail.get(note);
			cashTotal = cashTotal + (note.getNoteValue() * numberOfNotes);
		}

		if (cashTotal != getCashAmount()) {
			throw new CashDetailException(
					"Cash Details DOESNOT MATCH with the cash amount .CASH : "
							+ getCashAmount() + "& Cash Detail Total : "
							+ cashTotal);
		}

		this.cashDetail = cashDetail;
	}
}
