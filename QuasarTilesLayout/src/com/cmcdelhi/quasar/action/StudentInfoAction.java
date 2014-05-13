package com.cmcdelhi.quasar.action;

import java.util.List;

import com.cmcdelhi.quasar.service.StudentService;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

public class StudentInfoAction extends ActionSupport {

	String emailId;
	String user;
	Student student;

	public String execute() {
		//System.out.println("come to execute method" + emailId);
		try {

			StudentService ss = new StudentService();
			List<Student> stuList = ss.getStudent(null, 0, emailId, 0, null, 0,
					null, 0);

			student = stuList.get(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
