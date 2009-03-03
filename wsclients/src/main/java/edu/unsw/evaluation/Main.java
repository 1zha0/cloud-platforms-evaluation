package edu.unsw.evaluation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.stream.StreamResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

/**
 *
 * @author shrimpy
 */
public class Main {

    private static ApplicationContext context =
            new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});
//        private static final String MESSAGE =
//            "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
//            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
//            "<soap:Body>" +
//            "<SayGoodDay xmlns=\"http://azureva.org/\">" +
//            "<yourNamePlz>Clayton</yourNamePlz>" +
//            "</SayGoodDay>" +
//            "</soap:Body>" +
//            "</soap:Envelope>";
    private static final String MESSAGE =
            "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
            "<soap12:Body>" +
            "<SayGoodDay xmlns=\"http://azureva.org/\">" +
            "<yourNamePlz>Clayton</yourNamePlz>" +
            "</SayGoodDay>" +
            "</soap12:Body>" +
            "</soap12:Envelope>";

    public static void main(String[] args) {
        try {
            WebServiceTemplate webServiceTemplate = (WebServiceTemplate) context.getBean("webServiceTemplate");
            SaajSoapMessageFactory messageFactory = (SaajSoapMessageFactory) context.getBean("messageFactory");

            WebServiceMessage message = messageFactory.createWebServiceMessage(new ByteArrayInputStream(MESSAGE.getBytes()));
            message.writeTo(System.out);
            System.out.println("\n");

            webServiceTemplate.sendSourceAndReceiveToResult(message.getPayloadSource(), message.getPayloadResult());
            message.writeTo(System.out);
            System.out.println();

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
