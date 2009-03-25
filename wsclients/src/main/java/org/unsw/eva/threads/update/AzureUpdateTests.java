package org.unsw.eva.threads.update;

import org.cloudcomputingevaluation.ICloudComputingEvaluationUpdateCloudComputatonEvaluationExceptionFaultMessage;
import org.unsw.eva.threads.create.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.cloudcomputingevaluation.CloudComputingEvaluation;
import org.cloudcomputingevaluation.ICloudComputingEvaluation;
import org.cloudcomputingevaluation.ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationInstanceResponseCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.wsclient.App;
import org.unsw.eva.wsclient.SOAPVersion;

/**
 *
 * @author shrimpy
 */
public class AzureUpdateTests extends EvaluationThread {

    private CloudComputingEvaluation service = new CloudComputingEvaluation();

    public AzureUpdateTests(String name, App app) {
        super(name, app, SOAPVersion.SOAP_11);
    }

    @Override
    public Result doSOAP11Call() {
        try {
            ICloudComputingEvaluation endpoint = service.getAzureEvaluationSoap();
            return endpoint.update(getMESSAGE(), getMESSAGE());
        } catch (ICloudComputingEvaluationUpdateCloudComputatonEvaluationExceptionFaultMessage ex) {
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
