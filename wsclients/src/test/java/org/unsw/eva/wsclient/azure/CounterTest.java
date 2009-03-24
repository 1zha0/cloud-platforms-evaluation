package org.unsw.eva.wsclient.azure;

import org.cloudcomputingevaluation.ICloudComputingEvaluationGetCounterCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationResetCounterCloudComputatonEvaluationExceptionFaultMessage;
import org.unsw.eva.wsclient.AbstractTest;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author shrimpy
 */
public class CounterTest extends AbstractTest {

    @Test
    public void testReadAndResetCounter()
            throws ICloudComputingEvaluationResetCounterCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationGetCounterCloudComputatonEvaluationExceptionFaultMessage {

        getAzureServiceEndpoint().resetCounter();
        assertTrue(getAzureServiceEndpoint().getCounter() == 0);
    }
}
