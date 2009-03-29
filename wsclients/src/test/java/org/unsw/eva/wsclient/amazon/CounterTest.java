package org.unsw.eva.wsclient.amazon;

import org.cloudcomputingevaluation.ICloudComputingEvaluationGetCounterCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationResetCounterCloudComputatonEvaluationExceptionFaultMessage;
import org.unsw.eva.wsclient.AbstractTest;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author fei
 */
public class CounterTest extends AbstractTest {

    @Test
    public void testReadAndResetCounter()
            throws ICloudComputingEvaluationResetCounterCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationGetCounterCloudComputatonEvaluationExceptionFaultMessage {

        getAmazonEndpoint().resetCounter();
        assertTrue(getAmazonEndpoint().getCounter() == 0);
    }
}
