package org.unsw.eva.wsclient.amazon;

import org.junit.Before;
import org.unsw.eva.wsclient.AbstractTest;
import org.junit.Test;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cloudcomputingevaluation.Result;
/**
 * @author fei
 */
public class CreateTest extends AbstractTest {

    private StringBuilder content = new StringBuilder();
    private final static Log log = LogFactory.getLog(CreateTest.class);

    @Before
    public void testBefore() throws Exception {
//        for (int i = 0; i < 1024; i++) {
//            content.append("a");
//        }
        content.append("1");
    }

    @Test
    public void testCreate() throws Exception {
        Result result = getAmazonEndpoint().create(content.toString());
        log.warn("=====id: " + result.getId().getValue());
    }
}
