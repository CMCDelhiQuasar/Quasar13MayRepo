package com.cmcdelhi.quasar.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cmcdelhi.quasar.exceptions.NameException;
import com.cmcdelhi.quasar.fee.FeeDetails;
import com.cmcdelhi.quasar.paymentDetails.FullFeePayment;
import com.cmcdelhi.quasar.paymentDetails.InstallmentPayment;
import com.cmcdelhi.quasar.paymentDetails.InstallmentType;
import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.paymentDetails.PaymentDetails;
import com.cmcdelhi.quasar.paymentDetails.PaymentStatus;
import com.cmcdelhi.quasar.paymentDetails.RegistrationPayment;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

public class StudentRegistrationDetailAction extends ActionSupport implements
		ServletRequestAware, SessionAware {

	String studentname;
	String studentemail;
	String coursename;
	long contact;
	long coursefee;
	double servicetax;
	double discount;
	long fine;
	String paymenttype;
	int totalinstallments;
	long registrationamount;

	// the request Object
	HttpServletRequest request;

	// this is for maintaining the sesson throughout the student registration.
	Map registrationSessionMap;

	// this list will contain the unexpected exceptions
	List<String> errorsList = new ArrayList<String>();

	public String execute() {

		Enumeration enm = request.getParameterNames();

		while (enm.hasMoreElements()) {
			String paramName = (String) enm.nextElement();
			String paramValue = request.getParameter(paramName);

			System.out.println(paramName + "  :  " + paramValue);

		}

		System.out.println("------------------------------------>>>>>>");

		return "success";
	}

	public String startRegistrationSession() {

		Enumeration enm = request.getParameterNames();

		while (enm.hasMoreElements()) {
			String paramName = (String) enm.nextElement();
			String paramValue = request.getParameter(paramName);

			System.out.println(paramName + "  :  " + paramValue);

		}

		System.out.println("------------------------------------>>>>>>");

		// ///------->>>>> Check for the Key <<<<<-------------///

		System.out.println("Inside REg Session ");

		// String registeringStudentEmail = null;
		//
		// if (registrationSessionMap.containsKey("REGISTERING_STUDENT_EMAIL"))
		// {
		// registeringStudentEmail = (String) registrationSessionMap
		// .get("REGISTERING_STUDENT_EMAIL");
		//
		// }
		//
		// if (registeringStudentEmail != null) {
		// return SUCCESS;
		// }

		// ---- In future I will also check for the key(password)
		if (getStudentemail() != null) {
			// then create a student object and put it inside the session

			try {
				Student s = new Student();
				s.setName(getStudentname());
				s.setEmailId(getStudentemail());
				s.setCourseName(getCoursename());
				s.setContactNumber(getContact());

				// Fee Detail Object
				FeeDetails studentFeeDetail = new FeeDetails();
				studentFeeDetail.setCourseFees(getCoursefee());
				studentFeeDetail.setServiceTax(getServicetax());
				studentFeeDetail.setDiscountAvailable(getDiscount());
				studentFeeDetail.setFine(getFine());

				// setting fee detail in Student
				s.setFeeDetails(studentFeeDetail);

				// ////////////////////////////////---------------->>>TO DO :
				// Add the registration payment
				// object in Arraylist of
				// Student<<<<<-------------------------//
				RegistrationPayment rp = new RegistrationPayment();
				rp.setPaymentStatus(PaymentStatus.UNPAID);// Student has not
															// paid the
															// registration fee
															// till now
				// RegistrationPayment Details
				PaymentDetails redgpd = new PaymentDetails();
				redgpd.setProposedAmount(getRegistrationamount());// Student has
																	// provided
																	// the
																	// registration
																	// amount
																	// information
				redgpd.setDepositedAmount(0);// Student has not paid the
												// registration fee till now

				// setting the Registarion payment detail object in registration
				// paymnet object
				rp.setPaymentDetails(redgpd);

				// setting student info in RegistrationPayment Object
				rp.setStudent(s);

				s.getPaymentsList().add(rp);

				// ////////////////////////////////RegistrationPaymentObject SET

				// if student opted for full fees then directly take him to
				// registration payment page
				if (getPaymenttype().equals("Full Fees")) {
					// create a full fee payment object
					FullFeePayment ffp = new FullFeePayment();
					ffp.setPaymentStatus(PaymentStatus.UNPAID);
					ffp.setStudent(s);

					PaymentDetails fullFeePaymentDetails = new PaymentDetails();
					fullFeePaymentDetails.setTimeStamp(new Date());
					ffp.setPaymentDetails(fullFeePaymentDetails);

					s.getPaymentsList().add(ffp);

					// setting the student object in session
					registrationSessionMap.put("REGISTERING_STUDENT_EMAIL",
							getStudentemail());
					registrationSessionMap.put("shagird", s);
					registrationSessionMap
							.put("shagirdregistrationpayment", rp);

					registrationSessionMap.put(
							"shagirdregistrationfullfeepayment", ffp);

					return "gotofullfeeconfigpage";
					// otherwise go to installment configuration page
				} else {

					// /////////////////////////////////////////
					// This is the Array List that will store all Installment
					// payment objects
					// So that I can access them
					// ///////////////////////////////////////
					ArrayList<InstallmentPayment> allInstallments = new ArrayList<InstallmentPayment>();

					// create installment payment object
					for (int i = 1; i <= getTotalinstallments(); i++) {
						InstallmentPayment insp = new InstallmentPayment();
						insp.setPaymentStatus(PaymentStatus.UNPAID);
						// Installment Payment Details
						PaymentDetails insppd = new PaymentDetails();
						insppd.setProposedAmount(0);// Student has
													// provided
													// the
													// installment
													// amount
													// information
						insppd.setDepositedAmount(0);// Student has not paid the
														// installment fee till
														// now

						// setting the Inst6allment payment detail object in
						// installment
						// paymnet object
						insp.setPaymentDetails(insppd);

						// setting installment type of an installment object
						switch (i) {
						case 1:
							insp.setInstallmentType(InstallmentType.FIRST);
							break;
						case 2:
							insp.setInstallmentType(InstallmentType.SECOND);
							break;
						case 3:
							insp.setInstallmentType(InstallmentType.THIRD);
							break;
						case 4:
							insp.setInstallmentType(InstallmentType.FOURTH);
							break;
						case 5:
							insp.setInstallmentType(InstallmentType.FIFTH);
							break;
						case 6:
							insp.setInstallmentType(InstallmentType.SIXTH);
							break;
						case 7:
							insp.setInstallmentType(InstallmentType.SEVENTH);
							break;
						case 8:
							insp.setInstallmentType(InstallmentType.EIGHT);
							break;
						case 9:
							insp.setInstallmentType(InstallmentType.NINTH);
							break;
						case 10:
							insp.setInstallmentType(InstallmentType.TENTH);
							break;
						default:
							insp.setInstallmentType(InstallmentType.FIRST);
							break;
						}

						// setting installment payment in
						s.getPaymentsList().add(insp);
						insp.setStudent(s);
						allInstallments.add(insp);
					}

					registrationSessionMap.put("NUMBER_OF_INSTALLMENTS",
							allInstallments.size());

					registrationSessionMap.put("allInstallmentsList",
							allInstallments);

					// setting the student object in session
					registrationSessionMap.put("REGISTERING_STUDENT_EMAIL",
							getStudentemail());
					registrationSessionMap.put("shagird", s);

					registrationSessionMap
							.put("shagirdregistrationpayment", rp);

					return "gotoinstallmentconfigpage";
				}

			} catch (NameException e) {
				errorsList.add("Name Exception : " + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				errorsList.add("Exception : " + e.getMessage());
				e.printStackTrace();
			}

		}

		if (errorsList.isEmpty()) {
			return INPUT;
		}

		return INPUT;

	}

	public List<String> getErrorsList() {
		return errorsList;
	}

	public void setErrorsList(List<String> errorsList) {
		this.errorsList = errorsList;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getStudentemail() {
		return studentemail;
	}

	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public long getCoursefee() {
		return coursefee;
	}

	public void setCoursefee(long coursefee) {
		this.coursefee = coursefee;
	}

	public double getServicetax() {
		return servicetax;
	}

	public void setServicetax(double servicetax) {
		this.servicetax = servicetax;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public long getFine() {
		return fine;
	}

	public void setFine(long fine) {
		this.fine = fine;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public int getTotalinstallments() {
		return totalinstallments;
	}

	public void setTotalinstallments(int totalinstallments) {
		this.totalinstallments = totalinstallments;
	}

	public long getRegistrationamount() {
		return registrationamount;
	}

	public void setRegistrationamount(long registrationamount) {
		this.registrationamount = registrationamount;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		registrationSessionMap = arg0;
	}

}
