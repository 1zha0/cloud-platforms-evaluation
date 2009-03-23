package org.unsw.eva.wsclient.azure;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCreateDataByNumberCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationDeleteDataByNumberCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationReadDataByNumberCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationUpdateDataByNumberCloudComputatonEvaluationExceptionFaultMessage;
import org.unsw.eva.wsclient.AbstractTest;

/**
 *
 * @author shrimpy
 */
public class CRUDByNumberTest extends AbstractTest {

    private static final int NUMBER_OF_DATA = 100;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getAzureServiceEndpoint().cleanDefaultData(0, 0);
    }

    public void testCRUDByNumber()
            throws ICloudComputingEvaluationCreateDataByNumberCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationUpdateDataByNumberCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationReadDataByNumberCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationDeleteDataByNumberCloudComputatonEvaluationExceptionFaultMessage {

        getAzureServiceEndpoint().createDataByNumber(NUMBER_OF_DATA);
//        getAzureServiceEndpoint().updateDataByNumber(NUMBER_OF_DATA);
        getAzureServiceEndpoint().readDataByNumber(NUMBER_OF_DATA);
//        getAzureServiceEndpoint().deleteDataByNumber(NUMBER_OF_DATA);
    }
}
