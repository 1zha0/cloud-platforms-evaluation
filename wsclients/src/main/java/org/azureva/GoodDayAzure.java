
/*
 * 
 */

package org.azureva;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.1.3
 * Sat Mar 07 22:37:31 EST 2009
 * Generated source version: 2.1.3
 * 
 */


@WebServiceClient(name = "GoodDayAzure", 
                  wsdlLocation = "file:/D:/azure/wsclients/src/main/resources/GoodDayAzure.wsdl",
                  targetNamespace = "http://azureva.org/") 
public class GoodDayAzure extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://azureva.org/", "GoodDayAzure");
    public final static QName GoodDayAzureSoap = new QName("http://azureva.org/", "GoodDayAzureSoap");
    public final static QName GoodDayAzureSoap12 = new QName("http://azureva.org/", "GoodDayAzureSoap12");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/azure/wsclients/src/main/resources/GoodDayAzure.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/D:/azure/wsclients/src/main/resources/GoodDayAzure.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public GoodDayAzure(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public GoodDayAzure(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GoodDayAzure() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns GoodDayAzureSoap
     */
    @WebEndpoint(name = "GoodDayAzureSoap")
    public GoodDayAzureSoap getGoodDayAzureSoap() {
        return super.getPort(GoodDayAzureSoap, GoodDayAzureSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GoodDayAzureSoap
     */
    @WebEndpoint(name = "GoodDayAzureSoap")
    public GoodDayAzureSoap getGoodDayAzureSoap(WebServiceFeature... features) {
        return super.getPort(GoodDayAzureSoap, GoodDayAzureSoap.class, features);
    }
    /**
     * 
     * @return
     *     returns GoodDayAzureSoap
     */
    @WebEndpoint(name = "GoodDayAzureSoap12")
    public GoodDayAzureSoap getGoodDayAzureSoap12() {
        return super.getPort(GoodDayAzureSoap12, GoodDayAzureSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GoodDayAzureSoap
     */
    @WebEndpoint(name = "GoodDayAzureSoap12")
    public GoodDayAzureSoap getGoodDayAzureSoap12(WebServiceFeature... features) {
        return super.getPort(GoodDayAzureSoap12, GoodDayAzureSoap.class, features);
    }

}