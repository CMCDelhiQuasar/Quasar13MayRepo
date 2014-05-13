package com.cmcdelhi.quasar.student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.cmcdelhi.quasar.exceptions.NameException;
import com.cmcdelhi.quasar.fee.FeeDetails;
import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.paymentDetails.PaymentStatus;
import com.cmcdelhi.quasar.validators.EmailValidator;
import com.cmcdelhi.quasar.validators.NameValidator;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "emailId" }))
public class Student implements Comparable<Student>,Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;
	private FeeDetails feeDetails;

	@OneToMany
	private List<Payment> paymentsList = new ArrayList<Payment>();
	private String name;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus = PaymentStatus.UNPAID;
	private long contactNumber;
	private String courseName = "";

	private String emailId;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public FeeDetails getFeeDetails() {
		return feeDetails;
	}

	public void setFeeDetails(FeeDetails feeDetails) {
		this.feeDetails = feeDetails;
	}

	public List<Payment> getPaymentsList() {
		return paymentsList;
	}

	public void setPaymentsList(List<Payment> paymentsList) {
		this.paymentsList = paymentsList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws NameException {
		if (new NameValidator().validate(name)) {
			this.name = name;
		} else {
			throw new NameException(name + "  is a invalid Student name .");
		}

	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setEmailId(String emailId) throws NameException {
		if (new EmailValidator().validate(emailId)) {
			this.emailId = emailId;
		} else {
			throw new NameException("Email Id is invalid ");
		}

	}

	@Override
	public int compareTo(Student st) {
		if (this.studentId > st.studentId) {
			return 1;
		} else if (this.studentId < st.studentId) {
			return -1;
		} else {
			return 0;
		}

	}
}
