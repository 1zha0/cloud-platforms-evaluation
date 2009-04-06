package org.unsw.eva.wsclient.azureStorage;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCreateDataByNumberCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationDeleteDataByNumberCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationReadDataByNumberCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationUpdateDataByNumberCloudComputatonEvaluationExceptionFaultMessage;
import org.unsw.eva.wsclient.AbstractTest;

import org.junit.Before;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public class AzureStorageCRUDByNumberTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(AzureStorageCRUDByNumberTest.class);
    private static final int NUMBER_OF_DATA = 10;

    @Before
    public void setUp() throws Exception {
        getAzureStorageServiceEndpoint().cleanDefaultData(0, 0);
    }

    @Test
    public void testCRUDByNumber()
            throws ICloudComputingEvaluationCreateDataByNumberCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationUpdateDataByNumberCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationReadDataByNumberCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationDeleteDataByNumberCloudComputatonEvaluationExceptionFaultMessage {

        getAzureStorageServiceEndpoint().createDataByNumber(NUMBER_OF_DATA);
        getAzureStorageServiceEndpoint().updateDataByNumber(NUMBER_OF_DATA);
        getAzureStorageServiceEndpoint().readDataByNumber(NUMBER_OF_DATA);
        getAzureStorageServiceEndpoint().deleteDataByNumber(NUMBER_OF_DATA);
    }
}
