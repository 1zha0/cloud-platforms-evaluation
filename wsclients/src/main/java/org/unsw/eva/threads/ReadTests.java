package org.unsw.eva.threads;

import org.cloudcomputingevaluation.ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.wsclient.Monitor;
import org.unsw.eva.wsclient.SOAPVersion;
import org.unsw.eva.wsclient.ServerType;

/**
 *
 * @author shrimpy
 */
public class ReadTests<T extends Monitor> extends EvaluationThread {

    public ReadTests(String name, T app, ServerType serverType) {
        super(name, app, SOAPVersion.SOAP_11, serverType);
    }

    @Override
    public Result doSOAP11Call() {
        try {
            return getServiceEndpoint().read(getMESSAGE());
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
