package org.unsw.eva.threads.create;

import org.cloudcomputingevaluation.CloudComputingEvaluation;
import org.cloudcomputingevaluation.CloudComputingEvaluationSoap;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.wsclient.App;
import org.unsw.eva.wsclient.SOAPVersion;

/**
 *
 * @author shrimpy
 */
public class AmazonEC2CreateTests extends EvaluationThread {

    private CloudComputingEvaluation service = new CloudComputingEvaluation();

    public AmazonEC2CreateTests(String name, App app, SOAPVersion version) {
        super(name, app, version);
    }

    @Override
    public Result doSOAP11Call() {
        throw new UnsupportedOperationException("Not support yet.");
    }

    @Override
    public Result doSOAP12Call() {
        CloudComputingEvaluationSoap endpoint = service.getAmazonSoap12();
        return endpoint.create(getMESSAGE());
    }

    @Override
    public Boolean hasError() {
        return false;
    }
}
