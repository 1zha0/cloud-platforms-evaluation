package org.unsw.eva.wsclient;

import org.cloudcomputingevaluation.CloudComputingEvaluation;
import org.cloudcomputingevaluation.ICloudComputingEvaluation;

public abstract class AbstractTest {

    private CloudComputingEvaluation service = new CloudComputingEvaluation();

    public ICloudComputingEvaluation getAzureServiceEndpoint() {
        return service.getAzureEvaluationSoap();
    }

    public ICloudComputingEvaluation getAppEngineEndpoint() {
        return service.getAppEngineSoapInstanceResponse();
    }

    public ICloudComputingEvaluation getAmazonEndpoint() {
        return service.getAmazonSoap();
    }
}
