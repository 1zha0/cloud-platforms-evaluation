package org.unsw.eva.wsclient.azure;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationUpdateCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.wsclient.AbstractTest;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author shrimpy
 */
public class SDSCRUDTest extends AbstractTest {

    private static final String CONTENT = "Hello Azure";

    @Test
    public void testCRUD()
            throws ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationUpdateCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage {

        String id;
        Result result = getAzureServiceEndpoint().create(CONTENT);
        id = result.getId().getValue();
        assertTrue(id != null);

        result = getAzureServiceEndpoint().read(CONTENT);
        assertTrue(id.equals(result.getId().getValue()));

        result = getAzureServiceEndpoint().update(CONTENT, CONTENT + CONTENT);
        assertTrue(id.equals(result.getId().getValue()));

        result = getAzureServiceEndpoint().delete(CONTENT + CONTENT);
        assertTrue(id.equals(result.getId().getValue()));

    }
}
