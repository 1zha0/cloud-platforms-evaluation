package org.unsw.eva.threads;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.wsclient.Monitor;
import org.unsw.eva.wsclient.SOAPVersion;
import org.unsw.eva.wsclient.ServerType;

/**
 *
 * @author shrimpy
 */
public class CreateTests<T extends Monitor> extends EvaluationThread {

    private static final Logger log = LoggerFactory.getLogger(CreateTests.class);

    public CreateTests(String name, T app, ServerType serverType) {
        super(name, app, SOAPVersion.SOAP_11, serverType);
    }

    @Override
    public Result doSOAP11Call() {
        try {
            return getServiceEndpoint().create(getMESSAGE());
        } catch (ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage ex) {
            log.error("Failed in CreateTests.", ex);
            throw new ServerError(ex.getFaultInfo().getReason().getValue());
        }
    }

    @Override
    public Result doSOAP12Call() {
        return null;
    }

    @Override
    public Boolean hasError() {
        return getResult().getId().getValue() == null;
    }
}
