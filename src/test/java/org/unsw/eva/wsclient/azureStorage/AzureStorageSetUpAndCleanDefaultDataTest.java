package org.unsw.eva.wsclient.azureStorage;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCleanDefaultDataCloudComputatonEvaluationExceptionFaultMessage;
import org.unsw.eva.wsclient.AbstractTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

/**
 *
 * @author shrimpy
 */
public class AzureStorageSetUpAndCleanDefaultDataTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(AzureStorageSetUpAndCleanDefaultDataTest.class);
    public static final int NUMBER_OF_DATA = 10;

    @Before
    public void setUp() throws Exception {
        getAzureStorageServiceEndpoint().cleanDefaultData(0, 0);
        boolean val = true;

	while(val){
	        try {
	            val = getAppEngineCleanDefaultDataEndpoint().cleanDefaultData(500, 0);		
	        } catch (Exception ex) {
	        }
	}
        log.debug("AppEngine clean " + val);
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

        assertTrue(getAzureStorageServiceEndpoint().cleanDefaultData(0, 0));
    }
}
