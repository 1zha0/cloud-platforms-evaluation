package org.unsw.eva.threads;

import org.cloudcomputingevaluation.ICloudComputingEvaluationInstanceResponseCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.wsclient.App;
import org.unsw.eva.wsclient.Monitor;
import org.unsw.eva.wsclient.SOAPVersion;
import org.unsw.eva.wsclient.ServerType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public class MultiInstanceResponeTests<T extends Monitor> extends EvaluationThread {

    private static final Logger log = LoggerFactory.getLogger(MultiInstanceResponeTests.class);
    private int numberOfRequestToFired;
    private Result result = new Result();

    public MultiInstanceResponeTests(String name, T app, ServerType serverType, int numberOfRequestToFired) {
        super(name, app, SOAPVersion.SOAP_11, serverType);
        this.numberOfRequestToFired = numberOfRequestToFired;
    }

    @Override
    public Result doSOAP11Call() {
        try {
            for (int i = 0; i < numberOfRequestToFired; i++) {
                getServiceEndpoint().instanceResponse(getMESSAGE());
            }
            // return a fake result, coz if there is not result, the treated as error occured.
            return result;
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
