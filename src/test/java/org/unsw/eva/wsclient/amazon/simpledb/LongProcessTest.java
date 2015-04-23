package org.unsw.eva.wsclient.amazon.simpledb;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.wsclient.AbstractTest;

/**
 * @author fei
 */
public class LongProcessTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(LongProcessTest.class);

    @Test
    public void longProcess() throws Exception {
        log.warn("start long process");
        getAmazonSimpleDBEndpoint().longProcessInstanceResponse(1, "message");
    }
}
