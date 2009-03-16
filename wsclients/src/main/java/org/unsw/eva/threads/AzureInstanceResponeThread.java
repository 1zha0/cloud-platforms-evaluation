package org.unsw.eva.threads;

import org.cloudcomputingevaluation.CloudComputingEvaluation;
import org.cloudcomputingevaluation.CloudComputingEvaluationSoap;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.threads.exceptions.UnsupportError;
import org.unsw.eva.wsclient.Utils;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.wsclient.SOAPVersion;

/**
 *
 * @author shrimpy
 */
public class AzureInstanceResponeThread implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(AzureInstanceResponeThread.class);
    private int pos;
    private SOAPVersion version;

    public AzureInstanceResponeThread(int i, SOAPVersion version) {
        this.pos = i;
        this.version = version;
    }

    public void run() {
        if (version.equals(SOAPVersion.SOAP_11)) {
            soap11();
        } else if (version.equals(SOAPVersion.SOAP_12)) {
            soap12();
        } else {
            throw new UnsupportError("Unsupport soap version.");
        }
    }

    private void soap11() {
        CloudComputingEvaluation service = new CloudComputingEvaluation();
        Long azure = 0L;


        String out = String.valueOf(Calendar.getInstance().getTimeInMillis());
        Long timmer = Calendar.getInstance().getTimeInMillis();
        CloudComputingEvaluationSoap endpoint = service.getAzureEvaluationSoap();
        Result result = endpoint.instanceResponse(out);
        azure = Calendar.getInstance().getTimeInMillis() - timmer;
        log.debug(pos + " Azure SOAP 1.1 : " + azure + " " + result.getValue().contains(out) + "  " +
                Utils.convertResultToString(result));

    }

    private void soap12() {
        CloudComputingEvaluation service = new CloudComputingEvaluation();
        Long azure = 0L;


        String out = String.valueOf(Calendar.getInstance().getTimeInMillis());
        Long timmer = Calendar.getInstance().getTimeInMillis();
        CloudComputingEvaluationSoap endpoint = service.getAzureEvaluationSoap12();
        Result result = endpoint.instanceResponse(out);
        azure = Calendar.getInstance().getTimeInMillis() - timmer;
        log.debug(pos + " Azure SOAP 1.2 : " + azure + " " + result.getValue().contains(out) + "  " +
                Utils.convertResultToString(result));

    }
}
