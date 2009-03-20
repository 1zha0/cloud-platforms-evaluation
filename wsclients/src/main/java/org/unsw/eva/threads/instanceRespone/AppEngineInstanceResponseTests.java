/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unsw.eva.threads.instanceRespone;

import org.cloudcomputingevaluation.CloudComputingEvaluation;

import org.cloudcomputingevaluation.ICloudComputingEvaluation;
import org.cloudcomputingevaluation.ICloudComputingEvaluationInstanceResponseCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.wsclient.App;
import org.unsw.eva.wsclient.SOAPVersion;

/**
 *
 * @author liang
 */
public class AppEngineInstanceResponseTests extends EvaluationThread {

    private CloudComputingEvaluation service = new CloudComputingEvaluation();

    public AppEngineInstanceResponseTests(String name, App app) {
        super(name, app, SOAPVersion.SOAP_11);
    }

    @Override
    public Result doSOAP11Call() {

        ICloudComputingEvaluation endpoint = service.getAppEngineSoapInstanceResponse();
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
