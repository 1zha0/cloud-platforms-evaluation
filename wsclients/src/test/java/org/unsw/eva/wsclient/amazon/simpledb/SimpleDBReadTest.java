package org.unsw.eva.wsclient.amazon.simpledb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cloudcomputingevaluation.Result;
import org.junit.Test;
import org.unsw.eva.wsclient.AbstractTest;

/**
 * @author fei
 */
public class SimpleDBReadTest extends AbstractTest {

    private final static Log log = LogFactory.getLog(SimpleDBCreateTest.class);

    @Test
    public void testCreate() throws Exception {
        Result rt = getAmazonSimpleDBEndpoint().read("");
        log.warn("=============id:" + rt.getId().getValue());
    }
}
