/**
 * 
 */
package com.cmcdelhi.quasar.action;

import java.util.Date;

/**
 * @author BHASKAR MILKHA
 *
 */
public class RegistrationDetails {
	private String studentName;
	private String studentEmail;
	private String courseName;
	private long contactNumber;
	private int courseFee;
	private float serviceTax;
	private float discount;
	private float total;
	private Date proposedDate;
	private Date paymentDate;
	private int proposedAmount;
	private int depositedAmount;

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName
	 *            the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentEmail
	 */
	public String getStudentEmail() {
		return studentEmail;
	}

	/**
	 * @param studentEmail
	 *            the studentEmail to set
	 */
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName
	 *            the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the contactNumber
	 */
	public long getContactNumber() {
		return contactNumber;
	}

	/**
	 * @param contactNumber
	 *            the contactNumber to set
	 */
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	/**
	 * @return the courseFee
	 */
	public int getCourseFee() {
		return courseFee;
	}

	/**
	 * @param courseFee the courseFee to set
	 */
	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	/**
	 * @return the serviceTax
	 */
	public float getServiceTax() {
		return serviceTax;
	}

	/**
	 * @param serviceTax the serviceTax to set
	 */
	public void setServiceTax(float serviceTax) {
		this.serviceTax = serviceTax;
	}

	/**
	 * @return the discount
	 */
	public float getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}

	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * @return the proposedDate
	 */
	public Date getProposedDate() {
		return proposedDate;
	}

	/**
	 * @param proposedDate the proposedDate to set
	 */
	public void setProposedDate(Date proposedDate) {
		this.proposedDate = proposedDate;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * @return the proposedAmount
	 */
	public int getProposedAmount() {
		return proposedAmount;
	}

	/**
	 * @param proposedAmount the proposedAmount to set
	 */
	public void setProposedAmount(int proposedAmount) {
		this.proposedAmount = proposedAmount;
	}

	/**
	 * @return the depositedAmount
	 */
	public int getDepositedAmount() {
		return depositedAmount;
	}

	/**
	 * @param depositedAmount the depositedAmount to set
	 */
	public void setDepositedAmount(int depositedAmount) {
		this.depositedAmount = depositedAmount;
	}
	

}
