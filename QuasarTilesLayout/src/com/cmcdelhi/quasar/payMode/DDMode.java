/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmcdelhi.quasar.payMode;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Gufran Khurshid
 * @version 1.0
 * @Date 4 April 2013
 */

@Entity
public class DDMode extends PaymentMode {

	private long DDNumber;
	@Column(name = "DDIssuerBank")
	private String bankName;
	@Temporal(TemporalType.DATE)
	@Column(name = "DDIssueDate")
	private Date issueDate;
	@Temporal(TemporalType.DATE)
	private Date ddExpiryDate;

	public void setDDNumber(long DDNumber) {
		this.DDNumber = DDNumber;
	}

	public long getDDNumber() {
		return DDNumber;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankName() {
		return bankName;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getDdExpiryDate() {
		return ddExpiryDate;
	}

	public void setDdExpiryDate(Date ddExpiryDate) {
		this.ddExpiryDate = ddExpiryDate;
	}

}
