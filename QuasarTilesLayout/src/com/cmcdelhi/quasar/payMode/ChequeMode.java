package com.cmcdelhi.quasar.payMode;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cmcdelhi.quasar.exceptions.NameException;
import com.cmcdelhi.quasar.validators.NameValidator;

/**
 * 
 * @author Gufran Khurshid
 * @version 1.0
 * @Date 4 December 2013
 * @since 4 April 2013
 */

@Entity
public class ChequeMode extends PaymentMode {

	private long chequeNumber;
	private String bankName;
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	@Temporal(TemporalType.DATE)
	private Date expriyDate;
	@Enumerated(EnumType.STRING)
	private ChequeStatus chequeStatus;

	public long getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(long chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) throws NameException {
		if (new NameValidator().validate(bankName)) {
			this.bankName = bankName;
		} else {
			throw new NameException(bankName + " is invalid .");
		}
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpriyDate() {
		return expriyDate;
	}

	public void setExpriyDate(Date expriyDate) {
		this.expriyDate = expriyDate;
	}

	public ChequeStatus getChequeStatus() {
		return chequeStatus;
	}

	public void setChequeStatus(ChequeStatus chequeStatus) {
		this.chequeStatus = chequeStatus;
	}

}
