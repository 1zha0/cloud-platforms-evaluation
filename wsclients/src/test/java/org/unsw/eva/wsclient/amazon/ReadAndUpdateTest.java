package org.unsw.eva.wsclient.amazon;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationGetCounterCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationReadAndUpdateCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.wsclient.AbstractTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

/**
 *
 * @author fei
 */
public class ReadAndUpdateTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(ReadAndUpdateTest.class);
    private Result result = null;
    private static final String SAMPLE_DATE = "Sample data";

    @Before
    public void setUp() throws ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage {
        result = getAmazonEndpoint().create(SAMPLE_DATE);
    }

    @After
    public void tearDown() throws ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage {
        getAmazonEndpoint().delete(result.getValue().getValue());
    }

    @Test
    public void testReadAndUpdateTest()
            throws ICloudComputingEvaluationReadAndUpdateCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationGetCounterCloudComputatonEvaluationExceptionFaultMessage {
        Integer before = getAmazonEndpoint().getCounter();
        result = getAmazonEndpoint().readAndUpdate(result.getId().getValue());
        Integer after = getAmazonEndpoint().getCounter();
        assertTrue((after - before) == 1);
    }
}
