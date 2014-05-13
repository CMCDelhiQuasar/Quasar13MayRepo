package com.cmcdelhi.quasar.service;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.cmcdelhi.quasar.util.log.Log;

public class MailService {

	public boolean sendRegistartionConfirmationMail(
			QuasarMailConfiguration qmc, String... emailids) {
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(qmc.getHost());
			email.setSmtpPort(Integer.parseInt(qmc.getPort()));
			email.setAuthentication(qmc.getAdimnusername(),
					qmc.getAdminpassword());
			email.setSSLOnConnect(Boolean.parseBoolean(qmc.getStarttls()));

			email.setFrom(qmc.getAdimnusername());

			email.setSubject("TestMail");

			// MailChimp
			// email.setHtmlMsg("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Insert title here</title></head><body><table id=\"studentdetail\" style=\"background-color: graytext;font-family: sans-serif;padding: 10px;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);-moz-box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);-webkit-box-shadow: 0 4px 6px -5px rgba(0, 0, 0, 0.8);\"><tr><td align=\"center\"><img alt=\"alt\" src=\"images/logo.png\"></td><td align=\"left\">CMC LTD,New Delhi,Near Kohat Enclave Metro Station</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p>Grettings, Thanks for registering at CMC Delhi. We wish you a prosperous learning.If you any query click on this link <a href=\"www.cmcdelhi.com\">Link</a></p></td></tr></table></body></html>");
			email.setHtmlMsg("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Insert title here</title></head><body>"
					+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" style=\"border-collapse:collapse;margin:0;padding:0;background-color:#f2f2f2;height:100%!important;width:100%!important\"><tbody><tr><td align=\"center\" valign=\"top\" style=\"margin:0;padding:0;border-top:5px none #aaaaaa;height:100%!important;width:100%!important\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse:collapse\"><tbody>"
					+ "<tr><td align=\"center\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse; background-color: #ffffff; border-top: 0; border-bottom: 0\"><tbody><tr><td align=\"center\" valign=\"top\">"
					+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\"style=\"border-collapse: collapse\"><tbody>	<tr><td valign=\"top\" style=\"padding-top: 10px; padding-bottom: 10px\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse\">"
					+ "<tbody><tr><td valign=\"top\" style=\"padding: 9px\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"width=\"100%\" style=\"border-collapse: collapse\"><tbody><tr><td valign=\"top\" style=\"padding: 9px\"><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse: collapse\"><tbody><tr><td valign=\"top\"><ahref=\"http://www.cmcdelhi.com/\" "
					+ "title=\"\" style=\"word-wrap: break-word\" target=\"_blank\"><img alt=\"\" src=\"https://ci6.googleusercontent.com/proxy/RuvteIJkgNFYdxI6145X-lK4685AcOQxFui4iZxVKwtCz-hegVDIxdtSQ5PaGoE4fLQ_CR3uYlTuRNK8beuUu2loSM5gODacK1JsUqlEZ2lW2plIlZyyKfBPpqg6wpNywbTmDYca7UhlSa20h1k82LH1zIrVEMkqneme9Q=s0-d-e1-ft#http://gallery.mailchimp.com/38e8f39f127b52b8859e52f7c/images/4ea87a8b-6945-477c-904b-bbce8bf80a91.jpg\" width=\"116\" style=\"max-width: 116px; border: 0; outline: none; text-decoration: none; vertical-align: bottom\"></a></td></tr></tbody></table><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"176\"style=\"border-collapse: collapse\"><tbody><tr><td valign=\"top\" style=\"font-family: Georgia, Times, 'Times New Roman', serif; font-size: 9px; font-style: normal; text-align: center; color: #606060; line-height: 150%\"><spanstyle=\"color: #000000; font-family: arial, helvetica, clean, sans-serif; font-size: small; line-height: 16.003000259399414px; text-align: -webkit-center\">8,Vaishali Enclave,Main Metro Road,&nbsp;</span><br style=\"font-size: small; color: #000000; font-family: arial, helvetica, clean, sans-serif; line-height: 16.003000259399414px; text-align: -webkit-center\">"
					+ "<span style=\"color: #000000; font-family: arial, helvetica, clean, sans-serif; font-size: small; line-height: 16.003000259399414px; text-align: -webkit-center\">PitamPura,(Opp. Metro Pillar No. 351), New Delhi-110034,</span><br style=\"font-size: small; color: #000000; font-family: arial, helvetica, clean, sans-serif; line-height: 16.003000259399414px; text-align: -webkit-center\"><span style=\"color: #000000; font-family: arial, helvetica, clean, sans-serif; font-size: small; line-height: 16.003000259399414px; text-align: -webkit-center\">India</span></td></tr></tbody>	</table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr>"
					+ "<tr><td align=\"center\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse:collapse;background-color:#ffffff;border-top:0;border-bottom:0\"><tbody><tr><td align=\"center\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse:collapse\"><tbody><tr><td valign=\"top\" style=\"padding-top:10px;padding-bottom:10px\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse:collapse\"><tbody><tr><td valign=\"top\"><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse:collapse\"><tbody><tr> <td valign=\"top\" style=\"padding:9px 18px;font-size:9px;color:#606060;font-family:Helvetica;line-height:150%;text-align:left\">"
					+ "<h1 style=\"margin:0;padding:0;display:block;font-family:Helvetica;font-size:32px;font-style:normal;font-weight:bold;line-height:125%;letter-spacing:-1px;text-align:left;color:#606060!important\">Greetings From CMC Delhi</h1><h3 style=\"margin:0;padding:0;display:block;font-family:Helvetica;font-size:14px;font-style:normal;font-weight:bold;line-height:125%;letter-spacing:-.5px;text-align:left;color:#606060!important\">Registration Confirmation Email</h3><p style=\"margin:1em 0;padding:0;color:#606060;font-family:Helvetica;font-size:15px;line-height:150%;text-align:left\">Thanks for registering at CMC Delhi.This is system generated mail confirming your registration for course #####.Wishing you a prosperous learning.<br>Get your payment details here &lt;a href=\"<a href=\"http://www.cmcdelhi.com\" target=\"_blank\">www.cmcdelhi.com</a>\"</p>"
					+ "<p style=\"margin:1em 0;padding:0;color:#606060;font-family:Helvetica;font-size:15px;line-height:150%;text-align:left\">Need inspiration for your design? <a href=\"http://inspiration.mailchimp.com\" style=\"word-wrap:break-word;color:#6dc6dd;font-weight:normal;text-decoration:underline\" target=\"_blank\">Here�s what other MailChimp users are doing.</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr>"
					+ "<tr><td align=\"center\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse:collapse;background-color:#f2f2f2;border-top:0;border-bottom:0\"><tbody><tr><td align=\"center\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse:collapse\"><tbody><tr><td valign=\"top\" style=\"padding-top:10px;padding-bottom:10px\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse:collapse\"><tbody><tr><td valign=\"top\"><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse:collapse\"><tbody><tr>"
					+ "<td valign=\"top\" style=\"padding-top:9px;padding-right:18px;padding-bottom:9px;padding-left:18px;color:#606060;font-family:Helvetica;font-size:11px;line-height:125%;text-align:left\"><em>Copyright � *|####YEAR#####|* CMC Delhi, All rights reserved.</em><br><br><strong>Our address :</strong><br><span style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">8,Vaishali Enclave,Main Metro Road,&nbsp;</span><br style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\"><span style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">"
					+ "Pitam Pura,(Opp. Metro Pillar No. 351), New Delhi-110034,</span><br style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\"><span style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">India</span><br><strong style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">For Corporate Queries/College Tie-ups :&nbsp;Ashish Arora&nbsp; (09810324822)&nbsp;</strong><br style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">"
					+ "<strong style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">For Student Queries:&nbsp;</strong><span style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">Ms. Sabia Rais / Ms. Priyanka:09313877528, 01165905335 &amp; 65655335</span><br><strong style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">E-mail:</strong><a href=\"mailto:info@cmcdelhi.com\" style=\"color:blue;text-decoration:none;font-weight:bold;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center;word-wrap:break-word\" target=\"_blank\">"
					+ "info@cmcdelhi.com</a><span style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">/</span><a href=\"mailto:ashish.arora@cmcdelhi.com\" style=\"color:blue;text-decoration:none;font-weight:bold;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center;word-wrap:break-word\" target=\"_blank\">ashis<wbr>h.arora@cmcdelhi.com</a><br>&nbsp;</td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr>"
					+ "</tbody></table></body></html>");
			// /Email Attachment
			// EmailAttachment attachment = new EmailAttachment();
			// attachment.setPath("/home/guffy/Pictures/fggsa.jpg");
			// attachment.setDisposition(EmailAttachment.ATTACHMENT);
			// attachment.setDescription("Picture of JMosque");
			// attachment.setName("Mousque");

			// email.attach(attachment);

			// set the alternative message
			email.setTextMsg("Your email client does not support HTML messages");

			// adding up the recivers
			for (String em : emailids) {
				// email.addTo("mandeep624@gmail.com");
				email.addTo(em);
			}

			email.send();

			return true;

		} catch (EmailException e) {
			Log.e("Email Exception : " + e.getMessage());

		} catch (Exception e) {
			Log.e("Exception : " + e.getMessage());

		}
		return false;

	}

	public boolean sendPendingPaymentNotificationMail(
			QuasarMailConfiguration qmc, String... emailids) {
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(qmc.getHost());
			email.setSmtpPort(Integer.parseInt(qmc.getPort()));
			email.setAuthentication(qmc.getAdimnusername(),
					qmc.getAdminpassword());
			email.setSSLOnConnect(Boolean.parseBoolean(qmc.getStarttls()));

			email.setFrom(qmc.getAdimnusername());

			email.setSubject("TestMail");

			// MailChimp
			// email.setHtmlMsg("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Insert title here</title></head><body><table id=\"studentdetail\" style=\"background-color: graytext;font-family: sans-serif;padding: 10px;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);-moz-box-shadow: 0 4px 4px -4px rgba(0, 0, 0, 0.7);-webkit-box-shadow: 0 4px 6px -5px rgba(0, 0, 0, 0.8);\"><tr><td align=\"center\"><img alt=\"alt\" src=\"images/logo.png\"></td><td align=\"left\">CMC LTD,New Delhi,Near Kohat Enclave Metro Station</td></tr><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p>Grettings, Thanks for registering at CMC Delhi. We wish you a prosperous learning.If you any query click on this link <a href=\"www.cmcdelhi.com\">Link</a></p></td></tr></table></body></html>");
			email.setHtmlMsg("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Insert title here</title></head><body>"
					+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" height=\"100%\" width=\"100%\" style=\"border-collapse:collapse;margin:0;padding:0;background-color:#f2f2f2;height:100%!important;width:100%!important\"><tbody><tr><td align=\"center\" valign=\"top\" style=\"margin:0;padding:0;border-top:5px none #aaaaaa;height:100%!important;width:100%!important\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse:collapse\"><tbody>"
					+ "<tr><td align=\"center\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse; background-color: #ffffff; border-top: 0; border-bottom: 0\"><tbody><tr><td align=\"center\" valign=\"top\">"
					+ "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\"style=\"border-collapse: collapse\"><tbody>	<tr><td valign=\"top\" style=\"padding-top: 10px; padding-bottom: 10px\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse\">"
					+ "<tbody><tr><td valign=\"top\" style=\"padding: 9px\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"width=\"100%\" style=\"border-collapse: collapse\"><tbody><tr><td valign=\"top\" style=\"padding: 9px\"><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-collapse: collapse\"><tbody><tr><td valign=\"top\"><ahref=\"http://www.cmcdelhi.com/\" "
					+ "title=\"\" style=\"word-wrap: break-word\" target=\"_blank\"><img alt=\"\" src=\"https://ci6.googleusercontent.com/proxy/RuvteIJkgNFYdxI6145X-lK4685AcOQxFui4iZxVKwtCz-hegVDIxdtSQ5PaGoE4fLQ_CR3uYlTuRNK8beuUu2loSM5gODacK1JsUqlEZ2lW2plIlZyyKfBPpqg6wpNywbTmDYca7UhlSa20h1k82LH1zIrVEMkqneme9Q=s0-d-e1-ft#http://gallery.mailchimp.com/38e8f39f127b52b8859e52f7c/images/4ea87a8b-6945-477c-904b-bbce8bf80a91.jpg\" width=\"116\" style=\"max-width: 116px; border: 0; outline: none; text-decoration: none; vertical-align: bottom\"></a></td></tr></tbody></table><table align=\"right\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"176\"style=\"border-collapse: collapse\"><tbody><tr><td valign=\"top\" style=\"font-family: Georgia, Times, 'Times New Roman', serif; font-size: 9px; font-style: normal; text-align: center; color: #606060; line-height: 150%\"><spanstyle=\"color: #000000; font-family: arial, helvetica, clean, sans-serif; font-size: small; line-height: 16.003000259399414px; text-align: -webkit-center\">8,Vaishali Enclave,Main Metro Road,&nbsp;</span><br style=\"font-size: small; color: #000000; font-family: arial, helvetica, clean, sans-serif; line-height: 16.003000259399414px; text-align: -webkit-center\">"
					+ "<span style=\"color: #000000; font-family: arial, helvetica, clean, sans-serif; font-size: small; line-height: 16.003000259399414px; text-align: -webkit-center\">PitamPura,(Opp. Metro Pillar No. 351), New Delhi-110034,</span><br style=\"font-size: small; color: #000000; font-family: arial, helvetica, clean, sans-serif; line-height: 16.003000259399414px; text-align: -webkit-center\"><span style=\"color: #000000; font-family: arial, helvetica, clean, sans-serif; font-size: small; line-height: 16.003000259399414px; text-align: -webkit-center\">India</span></td></tr></tbody>	</table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr>"
					+ "<tr><td align=\"center\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse:collapse;background-color:#ffffff;border-top:0;border-bottom:0\"><tbody><tr><td align=\"center\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse:collapse\"><tbody><tr><td valign=\"top\" style=\"padding-top:10px;padding-bottom:10px\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse:collapse\"><tbody><tr><td valign=\"top\"><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse:collapse\"><tbody><tr> <td valign=\"top\" style=\"padding:9px 18px;font-size:9px;color:#606060;font-family:Helvetica;line-height:150%;text-align:left\">"
					+ "<h1 style=\"margin:0;padding:0;display:block;font-family:Helvetica;font-size:32px;font-style:normal;font-weight:bold;line-height:125%;letter-spacing:-1px;text-align:left;color:#606060!important\">Notification of Pending Payment</h1><h3 style=\"margin:0;padding:0;display:block;font-family:Helvetica;font-size:14px;font-style:normal;font-weight:bold;line-height:125%;letter-spacing:-.5px;text-align:left;color:#606060!important\">Registration Confirmation Email</h3><p style=\"margin:1em 0;padding:0;color:#606060;font-family:Helvetica;font-size:15px;line-height:150%;text-align:left\">Thanks for registering at CMC Delhi.This is system generated mail confirming your registration for course #####.Wishing you a prosperous learning.<br>Get your payment details here &lt;a href=\"<a href=\"http://www.cmcdelhi.com\" target=\"_blank\">www.cmcdelhi.com</a>\"</p>"
					+ "<p style=\"margin:1em 0;padding:0;color:#606060;font-family:Helvetica;font-size:15px;line-height:150%;text-align:left\">Need inspiration for your design? <a href=\"http://inspiration.mailchimp.com\" style=\"word-wrap:break-word;color:#6dc6dd;font-weight:normal;text-decoration:underline\" target=\"_blank\">Here�s what other MailChimp users are doing.</a></p></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr>"
					+ "<tr><td align=\"center\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse:collapse;background-color:#f2f2f2;border-top:0;border-bottom:0\"><tbody><tr><td align=\"center\" valign=\"top\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse:collapse\"><tbody><tr><td valign=\"top\" style=\"padding-top:10px;padding-bottom:10px\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse:collapse\"><tbody><tr><td valign=\"top\"><table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse:collapse\"><tbody><tr>"
					+ "<td valign=\"top\" style=\"padding-top:9px;padding-right:18px;padding-bottom:9px;padding-left:18px;color:#606060;font-family:Helvetica;font-size:11px;line-height:125%;text-align:left\"><em>Copyright � *|####YEAR#####|* CMC Delhi, All rights reserved.</em><br><br><strong>Our address :</strong><br><span style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">8,Vaishali Enclave,Main Metro Road,&nbsp;</span><br style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\"><span style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">"
					+ "Pitam Pura,(Opp. Metro Pillar No. 351), New Delhi-110034,</span><br style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\"><span style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">India</span><br><strong style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">For Corporate Queries/College Tie-ups :&nbsp;Ashish Arora&nbsp; (09810324822)&nbsp;</strong><br style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">"
					+ "<strong style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">For Student Queries:&nbsp;</strong><span style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">Ms. Sabia Rais / Ms. Priyanka:09313877528, 01165905335 &amp; 65655335</span><br><strong style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">E-mail:</strong><a href=\"mailto:info@cmcdelhi.com\" style=\"color:blue;text-decoration:none;font-weight:bold;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center;word-wrap:break-word\" target=\"_blank\">"
					+ "info@cmcdelhi.com</a><span style=\"color:#000000;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center\">/</span><a href=\"mailto:ashish.arora@cmcdelhi.com\" style=\"color:blue;text-decoration:none;font-weight:bold;font-family:arial,helvetica,clean,sans-serif;font-size:small;line-height:16.003000259399414px;text-align:-webkit-center;word-wrap:break-word\" target=\"_blank\">ashis<wbr>h.arora@cmcdelhi.com</a><br>&nbsp;</td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody></table></td></tr>"
					+ "</tbody></table></body></html>");
			// /Email Attachment
			// EmailAttachment attachment = new EmailAttachment();
			// attachment.setPath("/home/guffy/Pictures/fggsa.jpg");
			// attachment.setDisposition(EmailAttachment.ATTACHMENT);
			// attachment.setDescription("Picture of JMosque");
			// attachment.setName("Mousque");

			// email.attach(attachment);

			// set the alternative message
			email.setTextMsg("Your email client does not support HTML messages");

			// adding up the recivers
			for (String em : emailids) {
				// email.addTo("mandeep624@gmail.com");
				email.addTo(em);
			}

			email.send();

			return true;

		} catch (EmailException e) {
			Log.e("Email Exception : " + e.getMessage());

		} catch (Exception e) {
			Log.e("Exception : " + e.getMessage());

		}
		return false;

	}
}
