package org.unsw.eva.wsclient;

import org.cloudcomputingevaluation.CloudComputingEvaluation;
import org.cloudcomputingevaluation.ICloudComputingEvaluation;

public abstract class AbstractTest {

    private CloudComputingEvaluation service = new CloudComputingEvaluation();

    public ICloudComputingEvaluation getAzureServiceEndpoint() {
        return service.getAzureEvaluationSoap();
    }

    public ICloudComputingEvaluation getAzureStorageServiceEndpoint() {
        return service.getAzureStorageEvaluationSoap();
    }

    public ICloudComputingEvaluation getAppEngineInstanceResponseEndpoint() {
        return service.getAppEngineSoapInstanceResponse();
    }

    public ICloudComputingEvaluation getAppEngineCleanDefaultDataEndpoint() {
        return service.getAppEngineSoapCleanDefaultData();
    }

    public ICloudComputingEvaluation getAmazonEndpoint() {
        return service.getAmazonSoap();
    }

    public ICloudComputingEvaluation getAmazonSimpleDBEndpoint() {
        return service.getAmazonSoapSimpleDB();
    }
}
