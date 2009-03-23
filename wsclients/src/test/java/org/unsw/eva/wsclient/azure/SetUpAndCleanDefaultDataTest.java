package org.unsw.eva.wsclient.azure;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCleanDefaultDataCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationSetupDefaultDataCloudComputatonEvaluationExceptionFaultMessage;
import org.unsw.eva.wsclient.AbstractTest;

/**
 *
 * @author shrimpy
 */
public class SetUpAndCleanDefaultDataTest extends AbstractTest {

    public static final int NUMBER_OF_DATA = 10;

    @Override
    protected void setUp() throws Exception {
        getAzureServiceEndpoint().cleanDefaultData(0, 0);
    }

    public void testSetUpDefaultData()
            throws ICloudComputingEvaluationSetupDefaultDataCloudComputatonEvaluationExceptionFaultMessage {

        assertEquals(10, getAzureServiceEndpoint().setupDefaultData(NUMBER_OF_DATA, 0).intValue());
    }

    public void testCleanDefaultData()
            throws ICloudComputingEvaluationCleanDefaultDataCloudComputatonEvaluationExceptionFaultMessage {

        assertTrue(getAzureServiceEndpoint().cleanDefaultData(0, 0));
    }
}
