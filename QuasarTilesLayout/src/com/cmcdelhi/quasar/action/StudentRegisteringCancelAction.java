package com.cmcdelhi.quasar.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//This action is used to cancel the current ongoing  Student Registration
public class StudentRegisteringCancelAction extends ActionSupport implements
		SessionAware, ServletRequestAware {

	HttpServletRequest request;

	Map registrationSessionMap;

	public String cancelRegistrationSession() {
		if (registrationSessionMap.containsKey("REGISTERING_STUDENT_EMAIL")) {
			registrationSessionMap.remove("shagird");
			registrationSessionMap.remove("REGISTERING_STUDENT_EMAIL");
			return SUCCESS;
		} else {
			return ERROR;
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
