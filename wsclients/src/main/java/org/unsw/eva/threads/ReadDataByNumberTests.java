package org.unsw.eva.threads;

import org.cloudcomputingevaluation.ICloudComputingEvaluationReadDataByNumberCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.Monitor;
import org.unsw.eva.SOAPVersion;
import org.unsw.eva.ServerType;

/**
 *
 * @author shrimpy
 */
public class ReadDataByNumberTests<T extends Monitor> extends EvaluationThread {

    public ReadDataByNumberTests(String name, T app, ServerType serverType, int repeatNumberOfTime) {
        super(name, app, SOAPVersion.SOAP_11, serverType, repeatNumberOfTime);
    }

    @Override
    public Result doSOAP11Call() {
        try {
            return getServiceEndpoint().readDataByNumber(200);
        } catch (ICloudComputingEvaluationReadDataByNumberCloudComputatonEvaluationExceptionFaultMessage ex) {
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
