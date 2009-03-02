package de.mail;

import org.springframework.ws.client.core.WebServiceTemplate;

public class MailClient {

	private WebServiceTemplate webServiceTemplate;

	public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate;
	}

	public boolean send(String user, String password, String from, String to, String subject, String content) {
//		MailRequest request = new MailRequest();
//		request.setFrom(from);
//		request.setTo(to);
//		request.setUser(user);
//		request.setPassword(password);
//		request.setContent(content);
//		request.setSubject(subject);
//		return ((MailResponse)webServiceTemplate.marshalSendAndReceive(request)).isResult();
        return true;
	}

}
