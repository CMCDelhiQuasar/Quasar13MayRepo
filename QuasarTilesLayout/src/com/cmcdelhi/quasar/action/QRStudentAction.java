package com.cmcdelhi.quasar.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cmcdelhi.quasar.paymentDetails.InstallmentPayment;
import com.cmcdelhi.quasar.student.QuasarConnectionManager;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

public class QRStudentAction extends ActionSupport {

	String emailId;
	String user;
	List<Student> studentinfo = new ArrayList<Student>();

	@Override
	public String execute() throws Exception {
		System.out.println("Email ID : " + emailId);
		try {

			Session s = QuasarConnectionManager.getInstance().getSession();
			s.beginTransaction();
			Query query = s.createQuery("from Student where emailId=:user");
			query.setParameter("user", getEmailId());
			List<Student> list = query.list();

			for (Iterator it = list.iterator(); it.hasNext();) {
				Student student = (Student) it.next();
				studentinfo.add(student);
				System.out
						.println("student "
								+ (InstallmentPayment) student
										.getPaymentsList().get(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Student> getStudentinfo() {
		return studentinfo;
	}

	public void setStudentinfo(List<Student> studentinfo) {
		this.studentinfo = studentinfo;
	}

}
