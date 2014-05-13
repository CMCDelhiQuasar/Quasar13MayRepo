package com.cmcdelhi.quasar.service;

/**
 * The MailConfiguration Entity Class
 * 
 * @author Gufran Khurshid
 * @link
 * @version 1.0
 * @since 2 May 2014
 */

public class QuasarMailConfiguration {

	String host;
	String port;
	String starttls;
	String auth;

	String adimnusername;
	String adminpassword;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getStarttls() {
		return starttls;
	}

	public void setStarttls(String starttls) {
		this.starttls = starttls;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getAdimnusername() {
		return adimnusername;
	}

	public void setAdimnusername(String adimnusername) {
		this.adimnusername = adimnusername;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

}
