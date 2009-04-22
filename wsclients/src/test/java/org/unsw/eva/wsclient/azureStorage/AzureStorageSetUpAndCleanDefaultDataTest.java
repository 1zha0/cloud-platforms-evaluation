package org.unsw.eva.wsclient.azureStorage;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCleanDefaultDataCloudComputatonEvaluationExceptionFaultMessage;
import org.unsw.eva.wsclient.AbstractTest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shrimpy
 */
public class AzureStorageSetUpAndCleanDefaultDataTest extends AbstractTest {

    public static final int NUMBER_OF_DATA = 10;

    @Before
    public void setUp() throws Exception {
//        getAzureStorageServiceEndpoint().cleanDefaultData(0, 0);
    }

//    @Test
//    public void testSetUpDefaultData()
//            throws ICloudComputingEvaluationSetupDefaultDataCloudComputatonEvaluationExceptionFaultMessage {
//
//        assertEquals(10, getAzureStorageServiceEndpoint().setupDefaultData(NUMBER_OF_DATA, 0).intValue());
//    }
    @Test
    public void testCleanDefaultData()
            throws ICloudComputingEvaluationCleanDefaultDataCloudComputatonEvaluationExceptionFaultMessage {

//        assertTrue(getAzureStorageServiceEndpoint().cleanDefaultData(0, 0));
    }
}
