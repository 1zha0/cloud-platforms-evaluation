package org.unsw.eva.threads.instanceRespone;

import org.cloudcomputingevaluation.CloudComputingEvaluation;

import org.cloudcomputingevaluation.ICloudComputingEvaluation;
import org.cloudcomputingevaluation.ICloudComputingEvaluationInstanceResponseCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.wsclient.App;
import org.unsw.eva.wsclient.SOAPVersion;

/**
 *
 * @author shrimpy
 */
public class AzureInstanceResponeTests extends EvaluationThread {

    private static final Logger log = LoggerFactory.getLogger(AzureInstanceResponeTests.class);
    private CloudComputingEvaluation service = new CloudComputingEvaluation();

    public AzureInstanceResponeTests(String name, App app) {
        super(name, app, SOAPVersion.SOAP_11);
    }

    @Override
    public Result doSOAP11Call() {
        ICloudComputingEvaluation endpoint = service.getAzureEvaluationSoap();
        try {
            return endpoint.instanceResponse(getMESSAGE());
        } catch (ICloudComputingEvaluationInstanceResponseCloudComputatonEvaluationExceptionFaultMessage ex) {
            throw new ServerError(ex.getFaultInfo().getReason().getValue());
        }
    }

    @Override
    public Result doSOAP12Call() {
        return null;
    }

    @Override
    public Boolean hasError() {
        return !getResult().getValue().getValue().equals(getMESSAGE());
    }
}
