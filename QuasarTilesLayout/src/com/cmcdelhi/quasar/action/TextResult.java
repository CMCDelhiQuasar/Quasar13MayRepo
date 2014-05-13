package com.cmcdelhi.quasar.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;

public class TextResult extends ActionSupport {
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public String execute() throws Exception {
		inputStream = new ByteArrayInputStream(
				"Hello World! This is a text string response from a Struts 2 Action."
						.getBytes("UTF-8"));
		return SUCCESS;
	}
}