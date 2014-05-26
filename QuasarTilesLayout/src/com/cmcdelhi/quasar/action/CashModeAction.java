package com.cmcdelhi.quasar.action;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cmcdelhi.quasar.payMode.CardMode;
import com.cmcdelhi.quasar.payMode.CashMode;
import com.cmcdelhi.quasar.payMode.Note;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

public class CashModeAction extends ActionSupport implements
		ServletRequestAware, SessionAware {

	private static final long serialVersionUID = 8303209053388538476L;
	int thousandnotes;
	int fivehundred;
	int hundred;
	int fifty;
	int twenty;
	int ten;
	int five;
	int two;
	int one;
	String cashAmount;

	HttpServletRequest request;

	// this is the same session maintained throughout the student registration.
	Map registrationSessionMap;

	public String execute() {
		System.out.println("Inside execute method  of CashModeAction"
				+ Double.parseDouble(cashAmount));

		// check for valid session
		if (registrationSessionMap.get("REGISTERING_STUDENT_EMAIL") == null) {
			// it means no session is associated with the request and return
			// him
			// back
			return "nosession";
		} else {
			try {

				// searching for whether is this registration paymnent or due
				// payment
				String dueTag = (String) registrationSessionMap.get("DUE_TAG");
				if (dueTag == null) {
					System.out.println("This is regisatrion payment ");
				} else {
					System.out.println("This is Due Payment  " + dueTag);
				}

				// if available then fetch the student object
				Student loadedStudent = (Student) registrationSessionMap
						.get("shagird");

				System.out.println("Size : "
						+ loadedStudent.getPaymentsList().size());

				CashMode cm = new CashMode();
				cm.setCashAmount(Double.parseDouble(cashAmount));
				cm.getCashDetail().put(Note.THOUSAND, thousandnotes);
				cm.getCashDetail().put(Note.FIVEHUNDRED, fivehundred);
				cm.getCashDetail().put(Note.HUNDRED, hundred);
				cm.getCashDetail().put(Note.FIFTY, fifty);
				cm.getCashDetail().put(Note.TWENTY, twenty);
				cm.getCashDetail().put(Note.TEN, ten);
				cm.getCashDetail().put(Note.FIVE, five);
				cm.getCashDetail().put(Note.TWO, two);
				cm.getCashDetail().put(Note.ONE, one);
				cm.setPayment(loadedStudent.getPaymentsList().get(0));

				loadedStudent.getPaymentsList().get(0).setPaymentMode(cm);

				registrationSessionMap.put(
						"shagirdregistrationpaymentpaymentmode", cm);

				Enumeration enm = request.getParameterNames();

				while (enm.hasMoreElements()) {
					String paramName = (String) enm.nextElement();
					String paramValue = request.getParameter(paramName);
					System.out.println(paramName + "  :  " + paramValue);
				}

				// if regisatrion payment then go to Registartion Action else Go
				// to Due Payment Action
				if (dueTag == null) {
					return SUCCESS + "_reg";
				} else {
					return SUCCESS + "_due";
				}

				
				
			} catch (Exception e) {
				System.out.println("Exception " + e.getMessage());
			}

		}

		return INPUT;

	}

	public int getThousandnotes() {
		return thousandnotes;
	}

	public void setThousandnotes(int thousandnotes) {
		this.thousandnotes = thousandnotes;
	}

	public int getFivehundred() {
		return fivehundred;
	}

	public void setFivehundred(int fivehundred) {
		this.fivehundred = fivehundred;
	}

	public int getHundred() {
		return hundred;
	}

	public void setHundred(int hundred) {
		this.hundred = hundred;
	}

	public int getFifty() {
		return fifty;
	}

	public void setFifty(int fifty) {
		this.fifty = fifty;
	}

	public int getTwenty() {
		return twenty;
	}

	public void setTwenty(int twenty) {
		this.twenty = twenty;
	}

	public int getTen() {
		return ten;
	}

	public void setTen(int ten) {
		this.ten = ten;
	}

	public int getFive() {
		return five;
	}

	public void setFive(int five) {
		this.five = five;
	}

	public int getTwo() {
		return two;
	}

	public void setTwo(int two) {
		this.two = two;
	}

	public int getOne() {
		return one;
	}

	public void setOne(int one) {
		this.one = one;
	}

	public String getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(String cashAmount) {
		this.cashAmount = cashAmount;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void validate() {

		System.out.println("Inside validate method");

		if (cashAmount.length() == 0 || Double.parseDouble(cashAmount) <= 0) {
			addFieldError("cashAmount", "Please check cash amount!!");
			// System.out.println("control out.");
		}

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
