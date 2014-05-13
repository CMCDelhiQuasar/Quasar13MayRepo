/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmcdelhi.quasar.payMode;

import javax.persistence.Entity;

/**
 * 
 * @author Gufran Khurshid
 * @version 1.0
 * @Date 4 April 2013
 */

@Entity
public class OnlineMode extends PaymentMode {
	private long trasactionID;
	private String recieptNumber;

	public void setTrasactionID(long trasactionID) {
		this.trasactionID = trasactionID;
	}

	public long getTrasactionID() {
		return trasactionID;
	}

	public String getRecieptNumber() {
		return recieptNumber;
	}

	public void setRecieptNumber(String recieptNumber) {
		this.recieptNumber = recieptNumber;
	}

}
