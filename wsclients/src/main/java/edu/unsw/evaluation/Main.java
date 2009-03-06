package edu.unsw.evaluation;

import edu.unsw.evaluation.template.Pair;
import edu.unsw.evaluation.template.SoapMessageUtils;
import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static ApplicationContext context =
            new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});

    public static void main(String[] args) {
        try {
            WebServiceTemplate webServiceTemplate = (WebServiceTemplate) context.getBean("webServiceTemplate");
            SaajSoapMessageFactory messageFactory = (SaajSoapMessageFactory) context.getBean("messageFactory");

            Map<String, List<Pair<String, String>>> map = new HashMap<String, List<Pair<String, String>>>();
            List<Pair<String, String>> params = new LinkedList<Pair<String, String>>();
            params.add(new Pair<String, String>("yourNamePlz", "Clay"));
            map.put("SayGoodDay", params);

            WebServiceMessage message = messageFactory.createWebServiceMessage(
                    new ByteArrayInputStream(SoapMessageUtils.getSoap12Message(map).getBytes()));
            log.debug("Out going mesage : ");
            message.writeTo(System.out);
            System.out.println("\n");

            long timer = Calendar.getInstance().getTimeInMillis();
            webServiceTemplate.sendSourceAndReceiveToResult(message.getPayloadSource(), message.getPayloadResult());
            timer = Calendar.getInstance().getTimeInMillis() - timer;
            log.debug("In coming mesage : ");
            message.writeTo(System.out);
            System.out.println("\n");
            log.debug("Time consume : " + timer + "\n");
        } catch (Exception ex) {
            log.error("", ex);
        }

    }
}
