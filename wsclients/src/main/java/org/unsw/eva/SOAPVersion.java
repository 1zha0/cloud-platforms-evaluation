package org.unsw.eva;

/**
 *
 * @author shrimpy
 */
public enum SOAPVersion {

    SOAP_11("soap_1.1"),
    SOAP_12("soap_1.2");
    private String value;

    private SOAPVersion(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
