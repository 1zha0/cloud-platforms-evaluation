package org.unsw.eva.wsclient;

import junit.framework.TestCase;
import org.cloudcomputingevaluation.CloudComputingEvaluation;
import org.cloudcomputingevaluation.ICloudComputingEvaluation;

public abstract class AbstractTest extends TestCase {

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
