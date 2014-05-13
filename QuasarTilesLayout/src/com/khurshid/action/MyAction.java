package com.khurshid.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

public class MyAction implements ServletRequestAware {

	HttpServletRequest request;

	public String execute() {

		Enumeration enm = request.getParameterNames();

		while (enm.hasMoreElements()) {
			String paramName = (String) enm.nextElement();
			String paramValue = request.getParameter(paramName);

			System.out.println(paramName + "  :  " + paramValue);

		}

		return "success";

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;

	}

}
