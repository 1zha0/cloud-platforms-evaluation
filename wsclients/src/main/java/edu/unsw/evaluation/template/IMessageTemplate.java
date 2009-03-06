package edu.unsw.evaluation.template;

import java.util.List;
import java.util.Map;

/**
 *
 * @author shrimpy
 */
public interface IMessageTemplate {

    static final String ACTION = "==ACTION==";
    static final String PARAMETER = "==PARAMETER==";
    static final String ACTION_NAME = "==ACTION_NAME==";
    static final String PARAMETER_NAME = "==PARAMETER_NAME==";
    static final String VALUE = "==value==";
    static final String MESSAGE_11 =
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
            "<soap:Body>" +
            "==ACTION==" +
            "</soap:Body>" +
            "</soap:Envelope>";
    static final String MESSAGE_12 =
            "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
            "<soap12:Body>" +
            "==ACTION==" +
            "</soap12:Body>" +
            "</soap12:Envelope>";
    static final String ACTION_PART =
            "<==ACTION_NAME== xmlns=\"http://azureva.org/\">" +
            "==PARAMETER==" +
            "</==ACTION_NAME==>";
    static final String PARAMETER_PART = "<==PARAMETER_NAME==>==value==</==PARAMETER_NAME==>";

//    String getSoap11Message(Map<String, List<String>> map);
//
//    String getSoap12Message(Map<String, List<String>> map);
}
