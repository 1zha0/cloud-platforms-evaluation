package org.unsw.eva.threads;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCreateDataByNumberCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.wsclient.App;
import org.unsw.eva.wsclient.SOAPVersion;
import org.unsw.eva.wsclient.ServerType;

/**
 *
 * @author shrimpy
 */
public class CreateDataByNumberTests extends EvaluationThread {

    public CreateDataByNumberTests(String name, App app, ServerType serverType) {
        super(name, app, SOAPVersion.SOAP_11, serverType);
    }

    @Override
    public Result doSOAP11Call() {
        try {
            return getServiceEndpoint().createDataByNumber(500);
        } catch (ICloudComputingEvaluationCreateDataByNumberCloudComputatonEvaluationExceptionFaultMessage ex) {
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
