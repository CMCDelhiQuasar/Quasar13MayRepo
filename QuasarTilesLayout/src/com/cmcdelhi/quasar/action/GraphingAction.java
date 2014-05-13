package com.cmcdelhi.quasar.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
//import org.joda.time.Days;

import com.cmcdelhi.quasar.service.GraphingService;
import com.opensymphony.xwork2.ActionSupport;

public class GraphingAction extends ActionSupport implements
		ServletRequestAware {

	Date startdate;
	Date enddate;

	String checkall;
	String checkj2se;
	String checkj2ee;
	String checkandriod;
	String checkdotnet;
	String checkphp;

	HttpServletRequest request;

	// stuffs for graph labelling
	private String minTime;
	private String maxTime;
	private Map<Date, Integer> dateFromMapAllCourse;
	private Map<Date, Integer> dateFromMapJava;
	private Map<Date, Integer> dateFromMapJ2EE;
	private Map<Date, Integer> dateFromMapPhp;
	private Map<Date, Integer> dateFromMapAndroid;
	private Map<Date, Integer> dateFromMapDotNet;

	GraphingService gs;

	@Override
	public String execute() throws Exception {

		gs = new GraphingService();

		// checking of all course mapping
		// System.out.println("Check All : " + checkall);
		// System.out.println(" All Course : " + allcourse);
		// System.out.println("Check J2SE : " + checkj2se);
		// System.out.println("J2SE : " + j2seduration);

		// ///////////////////////////////////////////////////////

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startdate);

		dateFromMapAllCourse = new TreeMap<Date, Integer>();
		dateFromMapJava = new TreeMap<Date, Integer>();
		dateFromMapJ2EE = new TreeMap<Date, Integer>();
		dateFromMapAndroid = new TreeMap<Date, Integer>();
		dateFromMapPhp = new TreeMap<Date, Integer>();
		dateFromMapDotNet = new TreeMap<Date, Integer>();

		minTime = "" + calendar.getTime().getTime();
		System.out.println("minTime : " + minTime);

		// /////////////////////////////////////////////////////////////

		for (int i = 1; i <= (int) ((enddate.getTime() - startdate.getTime()) / (1000 * 60 * 60 * 24)); i++) {

			// populating data only for ALL Course
			if (checkall.equals("true")) {
				dateFromMapAllCourse.put(calendar.getTime(), gs
						.getTotalStudentNoOfStudentRegisteredOnADate(calendar
								.getTime()));
			}

			// populating data only for Java Course
			if (checkj2se.equals("true")) {
				dateFromMapJava.put(calendar.getTime(), gs
						.getTotalStudentNoOfStudentRegisteredOnADateForACourse(
								calendar.getTime(), "Java SE"));
			}

			// populating data only for J2EE Course
			if (checkj2ee.equals("true")) {
				dateFromMapJ2EE.put(calendar.getTime(), gs
						.getTotalStudentNoOfStudentRegisteredOnADateForACourse(
								calendar.getTime(), "Java EE"));
			}

			// populating data only for Android Course
			if (checkandriod.equals("true")) {
				dateFromMapAndroid.put(calendar.getTime(), gs
						.getTotalStudentNoOfStudentRegisteredOnADateForACourse(
								calendar.getTime(), "Android"));
			}
			// populating data only for Php Course
			if (checkphp.equals("true")) {
				dateFromMapPhp.put(calendar.getTime(), gs
						.getTotalStudentNoOfStudentRegisteredOnADateForACourse(
								calendar.getTime(), "Php"));
			}
			// populating data only for .Net Course
			if (checkdotnet.equals("true")) {
				dateFromMapDotNet.put(calendar.getTime(), gs
						.getTotalStudentNoOfStudentRegisteredOnADateForACourse(
								calendar.getTime(), ".Net"));
			}

			calendar.add(Calendar.DATE, +1);
		}

		maxTime = "" + calendar.getTime().getTime();
		System.out.println("maxTime : " + maxTime);

		return SUCCESS;
	}

	public ArrayList<Integer> getNoOfRegistration() throws ParseException {

		gs = new GraphingService();

		ArrayList<Integer> pointsList = new ArrayList<Integer>();

		for (int i = 1; i <= 30; i++) {
			int n = gs
					.getTotalStudentNoOfStudentRegisteredOnADate(new SimpleDateFormat(
							"yyyy-MM-dd").parse("2014-04-" + i));
			pointsList.add(n);
		}

		return pointsList;

	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getCheckall() {
		return checkall;
	}

	public void setCheckall(String checkall) {
		this.checkall = checkall;
	}

	public String getCheckj2se() {
		return checkj2se;
	}

	public void setCheckj2se(String checkj2se) {
		this.checkj2se = checkj2se;
	}

	public String getCheckj2ee() {
		return checkj2ee;
	}

	public void setCheckj2ee(String checkj2ee) {
		this.checkj2ee = checkj2ee;
	}

	public String getCheckandriod() {
		return checkandriod;
	}

	public void setCheckandriod(String checkandriod) {
		this.checkandriod = checkandriod;
	}

	public String getCheckdotnet() {
		return checkdotnet;
	}

	public void setCheckdotnet(String checkdotnet) {
		this.checkdotnet = checkdotnet;
	}

	public String getCheckphp() {
		return checkphp;
	}

	public void setCheckphp(String checkphp) {
		this.checkphp = checkphp;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	public String getMinTime() {
		return minTime;
	}

	public void setMinTime(String minTime) {
		this.minTime = minTime;
	}

	public String getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(String maxTime) {
		this.maxTime = maxTime;
	}

	public Map<Date, Integer> getDateFromMapAllCourse() {
		return dateFromMapAllCourse;
	}

	public void setDateFromMapAllCourse(Map<Date, Integer> dateFromMapAllCourse) {
		this.dateFromMapAllCourse = dateFromMapAllCourse;
	}

	public Map<Date, Integer> getDateFromMapJava() {
		return dateFromMapJava;
	}

	public void setDateFromMapJava(Map<Date, Integer> dateFromMapJava) {
		this.dateFromMapJava = dateFromMapJava;
	}

	public Map<Date, Integer> getDateFromMapJ2EE() {
		return dateFromMapJ2EE;
	}

	public void setDateFromMapJ2EE(Map<Date, Integer> dateFromMapJ2EE) {
		this.dateFromMapJ2EE = dateFromMapJ2EE;
	}

	public Map<Date, Integer> getDateFromMapPhp() {
		return dateFromMapPhp;
	}

	public void setDateFromMapPhp(Map<Date, Integer> dateFromMapPhp) {
		this.dateFromMapPhp = dateFromMapPhp;
	}

	public Map<Date, Integer> getDateFromMapDotNet() {
		return dateFromMapDotNet;
	}

	public void setDateFromMapDotNet(Map<Date, Integer> dateFromMapDotNet) {
		this.dateFromMapDotNet = dateFromMapDotNet;
	}

	public Map<Date, Integer> getDateFromMapAndroid() {
		return dateFromMapAndroid;
	}

	public void setDateFromMapAndroid(Map<Date, Integer> dateFromMapAndroid) {
		this.dateFromMapAndroid = dateFromMapAndroid;
	}

}
