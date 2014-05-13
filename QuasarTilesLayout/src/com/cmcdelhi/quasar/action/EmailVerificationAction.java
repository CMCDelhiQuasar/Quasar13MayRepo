package com.cmcdelhi.quasar.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cmcdelhi.quasar.paymentDetails.InstallmentPayment;
import com.cmcdelhi.quasar.service.StudentService;
import com.cmcdelhi.quasar.student.QuasarConnectionManager;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

public class EmailVerificationAction extends ActionSupport {

	String emailId;
	InputStream inputStream;

	@Override
	public String execute() throws Exception {

		try {

			if (!emailId.trim().equals("")) {

				StudentService ss = new StudentService();
				int size = ss.getStudent(null, 0, emailId, 0, null, 0, null, 0)
						.size();
				inputStream = new ByteArrayInputStream(
						("Size " + size).getBytes("UTF-8"));
				if (size != 0) {
					inputStream = new ByteArrayInputStream(
							"Email ID already exists ".getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream(
							" ".getBytes("UTF-8"));

				}

			} else {
				inputStream = new ByteArrayInputStream((" ").getBytes("UTF-8"));
			}

		} catch (Exception e) {

			inputStream = new ByteArrayInputStream((" ").getBytes("UTF-8"));
			e.printStackTrace();
			return SUCCESS;
		}

		return SUCCESS;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
