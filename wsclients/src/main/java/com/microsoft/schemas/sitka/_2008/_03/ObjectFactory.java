
package com.microsoft.schemas.sitka._2008._03;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.schemas.sitka._2008._03 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ErrorMessage_QNAME = new QName("http://schemas.microsoft.com/sitka/2008/03/", "Message");
    private final static QName _Error_QNAME = new QName("http://schemas.microsoft.com/sitka/2008/03/", "Error");
    private final static QName _ErrorCodes_QNAME = new QName("http://schemas.microsoft.com/sitka/2008/03/", "ErrorCodes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.schemas.sitka._2008._03
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/sitka/2008/03/", name = "Message", scope = Error.class)
    public JAXBElement<String> createErrorMessage(String value) {
        return new JAXBElement<String>(_ErrorMessage_QNAME, String.class, Error.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Error }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/sitka/2008/03/", name = "Error")
    public JAXBElement<Error> createError(Error value) {
        return new JAXBElement<Error>(_Error_QNAME, Error.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorCodes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/sitka/2008/03/", name = "ErrorCodes")
    public JAXBElement<ErrorCodes> createErrorCodes(ErrorCodes value) {
        return new JAXBElement<ErrorCodes>(_ErrorCodes_QNAME, ErrorCodes.class, null, value);
    }

}
