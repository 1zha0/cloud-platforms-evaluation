package edu.unsw.evaluation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

/**
 *
 * @author shrimpy
 */
public class Main {

    private static ApplicationContext context =
            new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});
    private static final String MESSAGE =
            "SOAPAction: \"http://azureva.org/SayGoodDay\"" +
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
            "<soap:Body>" +
            "<SayGoodDay xmlns=\"http://azureva.org/\">" +
            "<yourNamePlz>Clayton</yourNamePlz>" +
            "</SayGoodDay>" +
            "</soap:Body>" +
            "</soap:Envelope>";

    public static void main(String[] args) {
        try {
//        Test test = (Test) context.getBean("testPojo");
//        System.out.println("===>>>>>> starting... " + test.goodDay("Clay"));
            WebServiceTemplate webServiceTemplate = (WebServiceTemplate) context.getBean("webServiceTemplate");
            SaajSoapMessageFactory messageFactory = (SaajSoapMessageFactory) context.getBean("messageFactory");

            messageFactory.setSoapVersion(SoapVersion.SOAP_12);
            WebServiceMessage message = messageFactory.createWebServiceMessage(new ByteArrayInputStream("Clayton".getBytes()));
            message.writeTo(System.out);

            webServiceTemplate.sendSourceAndReceiveToResult(message.getPayloadSource(), message.getPayloadResult());
//            webServiceTemplate.sendSourceAndReceiveToResult(source, result);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
