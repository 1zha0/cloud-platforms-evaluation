package org.unsw.eva.threads;

import org.cloudcomputingevaluation.ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.wsclient.Monitor;
import org.unsw.eva.wsclient.SOAPVersion;
import org.unsw.eva.wsclient.ServerType;

/**
 *
 * @author shrimpy
 */
public class DeleteTests<T extends Monitor> extends EvaluationThread {

    public DeleteTests(String name, T app, ServerType serverType) {
        super(name, app, SOAPVersion.SOAP_11, serverType);
    }

    @Override
    public Result doSOAP11Call() {
        try {
            return getServiceEndpoint().delete(getMESSAGE());
        } catch (ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage ex) {
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
