package com.cmcdelhi.quasar.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.cmcdelhi.quasar.exceptions.DateException;
import com.cmcdelhi.quasar.student.Student;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Gufran Khurshid
 * 
 */

public class InstallmentConfigurationAction extends ActionSupport implements
		ServletRequestAware, SessionAware {

	HttpServletRequest request;

	// this is the same session maintained throughout the student registration.
	Map registrationSessionMap;

	public String execute() {

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			System.out
					.println("Inside execute method  of InhstallmentConfigurationAction");

			// check for valid session
			if (registrationSessionMap.get("REGISTERING_STUDENT_EMAIL") == null) {
				// it means no session is associated with the request and return
				// him
				// back
				return "nosession";
			} else {
				// if available then fetch the student object
				Student loadedStudent = (Student) registrationSessionMap
						.get("shagird");

				System.out.println("Size : "
						+ loadedStudent.getPaymentsList().size());

				Enumeration enm = request.getParameterNames();

				while (enm.hasMoreElements()) {
					String paramName = (String) enm.nextElement();
					switch (paramName) {
					case "proposedAmount1":
						String proposedAmount1 = request
								.getParameter("proposedAmount1");
						loadedStudent
								.getPaymentsList()
								.get(1)
								.getPaymentDetails()
								.setProposedAmount(
										Double.parseDouble(proposedAmount1));
						break;
					case "proposedAmount2":
						String proposedAmount2 = request
								.getParameter("proposedAmount2");
						loadedStudent
								.getPaymentsList()
								.get(2)
								.getPaymentDetails()
								.setProposedAmount(
										Double.parseDouble(proposedAmount2));

						break;
					case "proposedAmount3":
						String proposedAmount3 = request
								.getParameter("proposedAmount3");
						loadedStudent
								.getPaymentsList()
								.get(3)
								.getPaymentDetails()
								.setProposedAmount(
										Double.parseDouble(proposedAmount3));

						break;

					case "proposedAmount4":
						String proposedAmount4 = request
								.getParameter("proposedAmount4");
						loadedStudent
								.getPaymentsList()
								.get(4)
								.getPaymentDetails()
								.setProposedAmount(
										Double.parseDouble(proposedAmount4));

						break;
					case "proposedAmount5":
						String proposedAmount5 = request
								.getParameter("proposedAmount5");
						loadedStudent
								.getPaymentsList()
								.get(5)
								.getPaymentDetails()
								.setProposedAmount(
										Double.parseDouble(proposedAmount5));
						break;
					case "proposedAmount6":
						String proposedAmount6 = request
								.getParameter("proposedAmount6");
						loadedStudent
								.getPaymentsList()
								.get(6)
								.getPaymentDetails()
								.setProposedAmount(
										Double.parseDouble(proposedAmount6));

						break;
					case "proposedAmount7":
						String proposedAmount7 = request
								.getParameter("proposedAmount7");
						loadedStudent
								.getPaymentsList()
								.get(7)
								.getPaymentDetails()
								.setProposedAmount(
										Double.parseDouble(proposedAmount7));

						break;
					case "proposedAmount8":
						String proposedAmount8 = request
								.getParameter("proposedAmount8");
						loadedStudent
								.getPaymentsList()
								.get(8)
								.getPaymentDetails()
								.setProposedAmount(
										Double.parseDouble(proposedAmount8));

						break;
					case "proposedAmount9":
						String proposedAmount9 = request
								.getParameter("proposedAmount9");
						loadedStudent
								.getPaymentsList()
								.get(9)
								.getPaymentDetails()
								.setProposedAmount(
										Double.parseDouble(proposedAmount9));

						break;

					case "proposedAmount10":
						String proposedAmount10 = request
								.getParameter("proposedAmount10");
						loadedStudent
								.getPaymentsList()
								.get(10)
								.getPaymentDetails()
								.setProposedAmount(
										Double.parseDouble(proposedAmount10));

						break;

					// /cases of dates
					case "proposedDate1":
						String proposedDate1 = request
								.getParameter("proposedDate1");

						// converting the dat
						Date convertedDate1 = sdf.parse(proposedDate1);

						loadedStudent.getPaymentsList().get(1)
								.getPaymentDetails()
								.setProposedDate(convertedDate1);
						break;
					case "proposedDate2":
						String proposedDate2 = request
								.getParameter("proposedDate2");

						Date convertedDate2 = sdf.parse(proposedDate2);

						loadedStudent.getPaymentsList().get(2)
								.getPaymentDetails()
								.setProposedDate(convertedDate2);
						break;
					case "proposedDate3":

						String proposedDate3 = request
								.getParameter("proposedDate3");

						Date convertedDate3 = sdf.parse(proposedDate3);

						loadedStudent.getPaymentsList().get(3)
								.getPaymentDetails()
								.setProposedDate(convertedDate3);
						break;
					case "proposedDate4":
						String proposedDate4 = request
								.getParameter("proposedDate4");

						Date convertedDate4 = sdf.parse(proposedDate4);

						loadedStudent.getPaymentsList().get(4)
								.getPaymentDetails()
								.setProposedDate(convertedDate4);

						break;
					case "proposedDate5":
						String proposedDate5 = request
								.getParameter("proposedDate5");

						Date convertedDate5 = sdf.parse(proposedDate5);

						loadedStudent.getPaymentsList().get(5)
								.getPaymentDetails()
								.setProposedDate(convertedDate5);
						break;
					case "proposedDate6":
						String proposedDate6 = request
								.getParameter("proposedDate6");

						Date convertedDate6 = sdf.parse(proposedDate6);

						loadedStudent.getPaymentsList().get(6)
								.getPaymentDetails()
								.setProposedDate(convertedDate6);
						break;
					case "proposedDate7":
						String proposedDate7 = request
								.getParameter("proposedDate7");

						Date convertedDate7 = sdf.parse(proposedDate7);

						loadedStudent.getPaymentsList().get(7)
								.getPaymentDetails()
								.setProposedDate(convertedDate7);
						break;
					case "proposedDate8":
						String proposedDate8 = request
								.getParameter("proposedDate8");

						Date convertedDate8 = sdf.parse(proposedDate8);

						loadedStudent.getPaymentsList().get(8)
								.getPaymentDetails()
								.setProposedDate(convertedDate8);
						break;
					case "proposedDate9":
						String proposedDate9 = request
								.getParameter("proposedDate9");

						Date convertedDate9 = sdf.parse(proposedDate9);

						loadedStudent.getPaymentsList().get(9)
								.getPaymentDetails()
								.setProposedDate(convertedDate9);
						break;
					case "proposedDate10":
						String proposedDate10 = request
								.getParameter("proposedDate10");

						Date convertedDate10 = sdf.parse(proposedDate10);

						loadedStudent.getPaymentsList().get(10)
								.getPaymentDetails()
								.setProposedDate(convertedDate10);
						break;
					// //////////////////////////// cases of Comments
					case "comment1":
						String comment1 = request.getParameter("comment1");
						loadedStudent.getPaymentsList().get(1)
								.setPaymentComment(comment1);
						break;
					case "comment2":
						String comment2 = request.getParameter("comment2");
						loadedStudent.getPaymentsList().get(2)
								.setPaymentComment(comment2);
						break;
					case "comment3":
						String comment3 = request.getParameter("comment3");
						loadedStudent.getPaymentsList().get(3)
								.setPaymentComment(comment3);
						break;
					case "comment4":
						String comment4 = request.getParameter("comment4");
						loadedStudent.getPaymentsList().get(4)
								.setPaymentComment(comment4);
						break;
					case "comment5":
						String comment5 = request.getParameter("comment5");
						loadedStudent.getPaymentsList().get(5)
								.setPaymentComment(comment5);
						break;
					case "comment6":
						String comment6 = request.getParameter("comment6");
						loadedStudent.getPaymentsList().get(6)
								.setPaymentComment(comment6);
						break;
					case "comment7":
						String comment7 = request.getParameter("comment7");
						loadedStudent.getPaymentsList().get(7)
								.setPaymentComment(comment7);
						break;
					case "comment8":
						String comment8 = request.getParameter("comment8");
						loadedStudent.getPaymentsList().get(8)
								.setPaymentComment(comment8);
						break;
					case "comment9":
						String comment9 = request.getParameter("comment9");
						loadedStudent.getPaymentsList().get(9)
								.setPaymentComment(comment9);
						break;
					case "comment10":
						String comment10 = request.getParameter("comment10");
						loadedStudent.getPaymentsList().get(10)
								.setPaymentComment(comment10);
						break;

					default:
						break;
					}

					String paramValue = request.getParameter(paramName);

					System.out.println(paramName + "  :  " + paramValue);
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (DateException de) {
			de.printStackTrace();
			return ERROR;
		}
		return "success";
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
