package com.cmcdelhi.quasar.student;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.cmcdelhi.quasar.payMode.PaymentMode;
import com.cmcdelhi.quasar.paymentDetails.Payment;

public class MainClass {

	public static void main(String[] args) {

		// SessionFactory sf = new Configuration().configure()
		// .buildSessionFactory();
		//
		// Session s = sf.openSession();
		//
		// s.beginTransaction();

		// // Criteria c = s.createCriteria(Student.class);
		// // c.add(Restrictions.eq("studentId", 9L));
		// // c.add(Restrictions.eq("name", "Salman Khurshid"));
		// Criteria c = s.createCriteria(Student.class);
		// // c.createAlias("student.paymentsList", "payment");
		// // c.createAlias("student.paymentsList", "payment");
		// // c.add(Restrictions.eq("payment.paymentID", 22L));
		// // c.add(Restrictions.eq("payment.paymentDetails.proposedAmount",
		// // 3000.00));
		// c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		// // c.createAlias("student.paymentsList", "payment");
		// // c.createAlias("student.feeDetails", "feeDetails");
		// c.add(Restrictions.eq("student.feeDetails.courseFees", 12000.00));
		//
		// List<Student> studentList = c.list();
		//
		// System.out.println("Student List Size : " + studentList.size());
		//
		// System.out.println("---------------->>");
		//
		// for (Student st : studentList) {
		// System.out.println(st.getStudentId() + "  " + st.getName());
		// }

		// Criteria c = s.createCriteria(Payment.class);
		// try {
		//
		// Date minDate = new SimpleDateFormat("yyyy-MM-dd")
		// .parse("2014-04-30");
		//
		// Date maxDate = new Date(minDate.getTime()
		// + TimeUnit.DAYS.toMillis(1));
		//
		// System.out.println(minDate);
		// System.out.println(maxDate);
		//
		// // System.out.println();
		//
		// Conjunction and = Restrictions.conjunction();
		// and.add(Restrictions.ge("paymentDetails.proposedDate", minDate));
		// and.add(Restrictions.lt("paymentDetails.proposedDate", maxDate));
		//
		// c.add(and);
		//
		// } catch (Exception e) {
		// System.out.println("Exception " + e.getMessage());
		// }
		//
		// List<Payment> paymentList = c.list();
		//
		// System.out.println("Payment List Size " + paymentList.size());
		//
		// for (Payment p : paymentList) {
		// System.out.println(p.getPaymentID());
		// }
		//
		// s.getTransaction().commit();
		// s.close();

		// StudentService ss = new StudentService();
		//
		// for (Student stu : ss.getStudent("", 0, null, 0, "", 0,
		// PaymentStatus.FULLPAID, 0)) {
		// System.out.print(stu.getName());
		// System.out.println(" >>>>>>> ");
		// System.out.println("          ");
		// for (Payment p : stu.getPaymentsList()) {
		// System.out.println("          " + p.getPaymentID() + " : "
		// + p.getPaymentStatus());
		// }
		// }

		// PaymentService ps = new PaymentService();
		//
		// for (Payment p : ps.getPayment(0, 0, null, 0, 0, "2014-04-25", null,
		// 0, 0,
		// null, 0, 0, 0L)) {
		// System.out.println("" + p.getPaymentID());
		// }

		// GraphingService gs = new GraphingService();
		// try {
		// int x = gs.getTotalStudentNoOfStudentRegisteredOnADateForACourse(
		// new SimpleDateFormat("yyyy-MM-dd").parse("2014-04-30"),
		// "Java EE");
		//
		// // int x = gs
		// // .getTotalStudentNoOfStudentRegisteredOnADate(new
		// // SimpleDateFormat(
		// // "yyyy-MM-dd").parse("2014-04-26"));
		// System.out.println(x);
		//
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// ////////////////////////Testing Messaging System
		// System.out.println("Started  .. . . .. .");
		//
		// QuasarMailConfiguration qmc = new QuasarMailConfiguration();
		// qmc.setHost("smtp.gmail.com");
		// qmc.setPort("587");
		// qmc.setStarttls("true");
		// qmc.setAuth("true");
		//
		// qmc.setAdimnusername("hacked.fused@gmail.com");
		// qmc.setAdminpassword("hackingisnotpersonal");
		//
		// MailService ms = new MailService();
		// boolean result = ms.sendRegistartionConfirmationMail(qmc,
		// "guffy1267@gmail.com", "gufran.khurshid@gmail.com");
		// System.out.println("Result : " + result);

		// ///////////////////////////////////////Testing for Deletion Module

		try {
			QuasarConnectionManager qcm = QuasarConnectionManager.getInstance();
			Session s = qcm.getSession();
			s.beginTransaction();

			Query q = s.createQuery("from Student where emailId = :emailId");
			q.setParameter("emailId", "chetu@gmail.om");
			Student st = (Student) q.list().get(0);

			for (Payment p : st.getPaymentsList()) {

				PaymentMode pm = p.getPaymentMode();

				if (pm != null) {
					s.delete(pm);
				}

				s.delete(p);
			}

			s.delete(st);

			//
			// Student ent = (Student) s.get(Student.class, 3L);
			// s.delete(ent);

			s.getTransaction().commit();
			s.close();

			System.out.println("Student Deleted ");

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

	}
}
