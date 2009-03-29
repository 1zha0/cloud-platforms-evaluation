package org.unsw.eva.wsclient.amazon;

import org.cloudcomputingevaluation.ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.ICloudComputingEvaluationUpdateCloudComputatonEvaluationExceptionFaultMessage;
import org.cloudcomputingevaluation.Result;
import org.unsw.eva.wsclient.AbstractTest;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * @author fei
 */
public class CRUDTest extends AbstractTest {

    private static final String CONTENT = "This is the key";

    @Test
    public void testCRUD()
            throws ICloudComputingEvaluationCreateCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationUpdateCloudComputatonEvaluationExceptionFaultMessage,
            ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage {

        String id;
        Result result = getAmazonEndpoint().create(CONTENT);
        id = result.getId().getValue();
        assertTrue(id != null);

        result = getAmazonEndpoint().read(CONTENT);
        assertTrue(id.equals(result.getId().getValue()));

        result = getAmazonEndpoint().update(CONTENT, CONTENT + CONTENT);
        assertTrue(id.equals(result.getId().getValue()));

        result = getAmazonEndpoint().delete(CONTENT + CONTENT);

    }
}
