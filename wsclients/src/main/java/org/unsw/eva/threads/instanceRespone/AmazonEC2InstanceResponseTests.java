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
public class AmazonEC2InstanceResponseTests extends EvaluationThread {

    private CloudComputingEvaluation service = new CloudComputingEvaluation();

    public AmazonEC2InstanceResponseTests(String name, App app, SOAPVersion version) {
        super(name, app, version);
    }

    @Override
    public Result doSOAP11Call() {
        return null;
    }

    @Override
    public Result doSOAP12Call() {
        CloudComputingEvaluationSoap endpoint = service.getAmazonSoap12();
        return endpoint.instanceResponse(getMESSAGE());
    }

    @Override
    public Boolean hasError() {
        return !getResult().getValue().equals(getMESSAGE());
    }
}
