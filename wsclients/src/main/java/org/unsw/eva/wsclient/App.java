package org.unsw.eva.wsclient;

import org.azureva.GoodDayAzure;
import org.azureva.GoodDayAzureSoap;
import org.azureva.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shrimpy
 */
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        GoodDayAzure service = new GoodDayAzure();

        log.debug("=================== Soap 1.1 ===================");
        GoodDayAzureSoap endpoint = service.getGoodDayAzureSoap();
        Result result = endpoint.sayGoodDay("Clay");
        log.debug(Utils.convertResultToString(result));

        log.debug("=================== Soap 1.2 ===================");
        GoodDayAzureSoap endpoint12 = service.getGoodDayAzureSoap12();
        Result result12 = endpoint12.sayGoodDay("Clay");
        log.debug(Utils.convertResultToString(result12));
    }
}
