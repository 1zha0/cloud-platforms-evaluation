package org.unsw.eva.threads.read;

import org.cloudcomputingevaluation.ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage;
import org.unsw.eva.threads.create.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cloudcomputingevaluation.CloudComputingEvaluation;
import org.cloudcomputingevaluation.ICloudComputingEvaluation;
import org.cloudcomputingevaluation.ICloudComputingEvaluationCleanDefaultDataCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.wsclient.App;
import org.unsw.eva.wsclient.SOAPVersion;

/**
 *
 * @author shrimpy
 */
public class AzureRestTests extends EvaluationThread {

    private CloudComputingEvaluation service = new CloudComputingEvaluation();

    public AzureRestTests(String name, App app) {
        super(name, app, SOAPVersion.SOAP_11);
    }

    @Override
    public Result doSOAP11Call() {
        ICloudComputingEvaluation endpoint = service.getAzureEvaluationSoap();
        try {
            return endpoint.read(getMESSAGE());
        } catch (ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage ex) {
            throw new ServerError(ex.getFaultInfo().getReason().getValue());
        }
    }

    @Override
    public Result doSOAP12Call() {
        return null;
    }

    @Override
    public Boolean hasError() {
        return getResult().getId() == null;
    }
}
