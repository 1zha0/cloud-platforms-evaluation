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
public class AzureCreateTests extends EvaluationThread {

    private CloudComputingEvaluation service = new CloudComputingEvaluation();

    public AzureCreateTests(String name, App app, SOAPVersion version) {
        super(name, app, version);
    }

    @Override
    public Result doSOAP11Call() {
        CloudComputingEvaluationSoap endpoint = service.getAzureEvaluationSoap();
        return endpoint.create(getMESSAGE());
    }

    @Override
    public Result doSOAP12Call() {
        CloudComputingEvaluationSoap endpoint = service.getAzureEvaluationSoap();
        return endpoint.create(getMESSAGE());
    }

    @Override
    public Boolean hasError() {
        return getResult().getId() == null;
    }
}
