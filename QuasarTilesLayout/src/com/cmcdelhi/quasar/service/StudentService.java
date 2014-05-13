package com.cmcdelhi.quasar.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.cmcdelhi.quasar.payMode.PaymentMode;
import com.cmcdelhi.quasar.paymentDetails.Payment;
import com.cmcdelhi.quasar.paymentDetails.PaymentStatus;
import com.cmcdelhi.quasar.student.QuasarConnectionManager;
import com.cmcdelhi.quasar.student.Student;

public class StudentService {

	QuasarConnectionManager quasarConnectionManager;

	// Something Changed

	public StudentService() {
		quasarConnectionManager = QuasarConnectionManager.getInstance();
	}

	public List<Student> getAllStudent() {
		System.out.println("Inside getallstudent method...");
		Criteria c = quasarConnectionManager.getSession().createCriteria(
				Student.class);
		return c.list();
	}

	public List<Student> getStudent(String name, long id, String emailId,
			double courseFees, String courseName, long contactNumber,
			PaymentStatus paymentStatus, long paymentId) {

		
		
		

		Criteria c = quasarConnectionManager.getSession().createCriteria(
				Student.class, "student");
		c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

		if (name != null && !name.equals("")) {
			name = name.trim();
			c.add(Restrictions.eq("student.name", name));
		}

		if (id != 0) {
			c.add(Restrictions.eq("student.studentId", id));
		}

		if (emailId != null && !emailId.equals("")) {
			emailId = emailId.trim();
			c.add(Restrictions.eq("student.emailId", emailId));
		}

		if (courseFees != 0.0) {
			c.add(Restrictions.eq("student.feeDetails.courseFees", courseFees));
		}

		if (courseName != null && !courseName.equals("")) {
			courseName = courseName.trim();
			c.add(Restrictions.eq("student.courseName", courseName));
		}

		if (contactNumber != 0) {
			c.add(Restrictions.eq("student.contactNumber", contactNumber));
		}

		if (paymentStatus != null) {
			c.createAlias("student.paymentsList", "payment");
			c.add(Restrictions.eq("payment.paymentStatus", paymentStatus));
		}

		return c.list();
	}

	public boolean deleteStudent(String emailId) {

		try {

			Session s = quasarConnectionManager.getSession();
			s.beginTransaction();

			Query q = s.createQuery("from Student where emailId = :emailId");
			q.setParameter("emailId", emailId);
			Student st = (Student) q.list().get(0);

			for (Payment p : st.getPaymentsList()) {

				PaymentMode pm = p.getPaymentMode();

				if (pm != null) {
					// first delete the payment mode entity
					s.delete(pm);
				}
				// secondly delete the payment object
				s.delete(p);
			}

			// at last delete the Student Object
			s.delete(st);

			s.getTransaction().commit();
			s.close();

			System.out.println("Student Deleted ");

			return true;

		} catch (HibernateException e) {
			System.out.println("Hibernate Exception : " + e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception : " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteStudent(String... emailIds) {

		return true;
	}

}
