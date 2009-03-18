/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unsw.eva.threads.instanceRespone;

import org.cloudcomputingevaluation.CloudComputingEvaluation;
import org.cloudcomputingevaluation.CloudComputingEvaluationSoap;
import org.cloudcomputingevaluation.Result;

import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.wsclient.App;
import org.unsw.eva.wsclient.SOAPVersion;

/**
 *
 * @author liang
 */
public class AppEngineInstanceResponseTests extends EvaluationThread {

    private CloudComputingEvaluation service = new CloudComputingEvaluation();

    public AppEngineInstanceResponseTests(String name, App app, SOAPVersion version) {
        super(name, app, version);
    }

    @Override
    public Result doSOAP11Call() {
        CloudComputingEvaluationSoap endpoint = service.getAppEngineSoap11InstanceResponse();
        return endpoint.instanceResponse(getMESSAGE());
    }

    @Override
    public Result doSOAP12Call() {
        return null;
    }

    @Override
    public Boolean hasError() {
        return !getResult().getValue().equals(getMESSAGE());
    }
}
