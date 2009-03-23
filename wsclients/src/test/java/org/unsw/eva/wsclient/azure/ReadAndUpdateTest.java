package org.unsw.eva.wsclient.azure;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationGetCounterCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationReadAndUpdateCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.wsclient.AbstractTest;

/**
 *
 * @author shrimpy
 */
public class ReadAndUpdateTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ReadAndUpdateTest.class);
    private Result result = null;
    private static final String SAMPLE_DATE = "Hello Azure.";

    @Override
    public void setUp() throws ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage {
        result = getAzureServiceEndpoint().create(SAMPLE_DATE);
    }

    @Override
    public void tearDown() throws ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage {
        getAzureServiceEndpoint().delete(result.getValue().getValue());
    }

    @Test
    public void testReadAndUpdateTest()
            throws ICloudComputingEvaluationReadAndUpdateCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationGetCounterCloudComputatonEvaluationExceptionFaultMessage {
        Integer before = getAzureServiceEndpoint().getCounter();
        result = getAzureServiceEndpoint().readAndUpdate(result.getId().getValue());
        Integer after = getAzureServiceEndpoint().getCounter();
        assertTrue((after - before) == 1);
    }
}
