package org.unsw.eva.wsclient;

import org.unsw.eva.threads.AzureInstanceResponeThread;

/**
 * @author shrimpy
 */
public class App {

    public static void main(String[] args) {
        Thread t;
        for (int i = 0; i < 10; i++) {
            t = new Thread(new AzureInstanceResponeThread(i, SOAPVersion.SOAP_11));
            t.start();
        }
        for (int i = 0; i < 10; i++) {
            t = new Thread(new AzureInstanceResponeThread(i, SOAPVersion.SOAP_12));
            t.start();
        }
    }
}
