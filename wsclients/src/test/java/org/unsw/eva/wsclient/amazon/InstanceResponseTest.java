package org.unsw.eva.wsclient.amazon;

import org.cloudcomputingevaluation.Result;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.wsclient.AbstractTest;
import static org.junit.Assert.*;
/**
 * @author fei
 */
public class InstanceResponseTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(InstanceResponseTest.class);
    private static final String STRING_OF_DATA = "instanceResponse";

    @Test
    public void InstanceResponseTest() throws Exception {
        Result result = getAmazonEndpoint().instanceResponse(STRING_OF_DATA);

        assertEquals(STRING_OF_DATA, result.getValue().getValue());
    }
}
