package com.cmcdelhi.quasar.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

import com.cmcdelhi.quasar.student.QuasarConnectionManager;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteStudentAction extends ActionSupport {

	String emailId;
	String email;
	String demail;
	List<Student> deletestudent = new ArrayList<Student>();

	public String execute() {
		System.out.println("come to student deletion action" + emailId);

		try {

			Session s = QuasarConnectionManager.getInstance().getSession();
			Transaction trans = s.beginTransaction();
			if (demail == null) {
				Query query = s
						.createQuery("from Student where emailId=:email");
				query.setParameter("email", emailId);
				List<Student> studentlist = query.list();
				System.out.println("size is " + studentlist.size());
				// session.put("deletestudent", studentlist);

				for (Iterator iterator = studentlist.iterator(); iterator
						.hasNext();) {
					Student student = (Student) iterator.next();
					deletestudent.add(student);
					System.out.println("come to "
							+ student.getPaymentsList().get(0)
									.getPaymentComment());
				}
			} else {
				// Query query = s
				// .createQuery("ALTER TABLE Student DROP FOREIGN KEY emailId");
				Query query = s
						.createQuery("delete from Student where emailId=:email");
				query.setParameter("email", demail);

				// System.out.println("come to else part" + demail
				// + query.executeUpdate());
				trans.commit();
			}

			s.close();
		} catch (HibernateException hne) {
			hne.printStackTrace();
		}
		return "success";
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public List<Student> getDeletestudent() {
		return deletestudent;
	}

	public void setDeletestudent(List<Student> deletestudent) {
		this.deletestudent = deletestudent;
	}

	public String getDemail() {
		return demail;
	}

	public void setDemail(String demail) {
		this.demail = demail;
	}

}
