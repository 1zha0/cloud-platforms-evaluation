package org.unsw.eva.wsclient.amazon.simpledb;

import org.cloudcomputingevaluation.ICloudComputingEvaluationBinaryFileReadCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationBinaryFileWriteCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationCleanDefaultDataCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.wsclient.AbstractTest;
import static org.junit.Assert.*;

/**
 * @author fei
 */
public class BinaryFileWriteReadTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(BinaryFileWriteReadTest.class);
    private String KEY = "key";

    @Before
    public void setUp() throws Exception {
        getAmazonSimpleDBEndpoint().cleanDefaultData(0, 0);
    }

    @Test
    public void testBinaryFileWrite() throws Exception {

        Result resultWrite = getAmazonSimpleDBEndpoint().binaryFileWrite(KEY);
        Result resultRead = getAmazonSimpleDBEndpoint().binaryFileRead(KEY);
        assertEquals(resultRead.getId().getValue(), resultWrite.getId().getValue());
        assertEquals(resultRead.getValue().getValue(), resultWrite.getValue().getValue());
    }

    @After
    public void cleanUp() throws Exception {
        getAmazonSimpleDBEndpoint().cleanDefaultData(0, 0);
    }
}
