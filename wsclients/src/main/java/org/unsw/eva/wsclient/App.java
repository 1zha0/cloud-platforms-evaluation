package org.unsw.eva.wsclient;

import org.cloudcomputingevaluation.CloudComputingEvaluation;
import org.cloudcomputingevaluation.CloudComputingEvaluationSoap;
import org.cloudcomputingevaluation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shrimpy
 */
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        CloudComputingEvaluation service = new CloudComputingEvaluation();

        log.debug("=================== Soap 1.1 ===================");
        CloudComputingEvaluationSoap endpoint = service.getAzureEvaluationSoap();
        Result result = endpoint.instanceResponse("Clay");
        log.debug(Utils.convertResultToString(result));

        log.debug("=================== Soap 1.2 ===================");
        CloudComputingEvaluationSoap endpoint12 = service.getAzureEvaluationSoap12();
        Result result12 = endpoint12.instanceResponse("Clay");
        log.debug(Utils.convertResultToString(result12));

    }
}
