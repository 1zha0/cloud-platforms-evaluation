package org.unsw.eva.wsclient.amazon;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCleanDefaultDataCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationSetupDefaultDataCloudComputatonEvaluationExceptionFaultMessage;
import org.unsw.eva.wsclient.AbstractTest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fei
 */
public class SetUpAndCleanDefaultDataTest extends AbstractTest {

    public static final int NUMBER_OF_DATA = 10;

    @Before
    public void setUp() throws Exception {
//        getAmazonEndpoint().cleanDefaultData(0, 0);
    }

    @Test
    public void testSetUpDefaultData()
            throws ICloudComputingEvaluationSetupDefaultDataCloudComputatonEvaluationExceptionFaultMessage {

//        assertEquals(10, getAmazonEndpoint().setupDefaultData(NUMBER_OF_DATA, 0).intValue());
    }

    @Test
    public void testCleanDefaultData()
            throws ICloudComputingEvaluationCleanDefaultDataCloudComputatonEvaluationExceptionFaultMessage {

//        assertTrue(getAmazonEndpoint().cleanDefaultData(0, 0));
    }
}


