package org.unsw.eva.wsclient.amazon;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cloudcomputingevaluation.Result;
import org.junit.Test;
import org.unsw.eva.wsclient.AbstractTest;

/**
 * @author fei
 */
public class ReadTest extends AbstractTest {

    private final static Log log = LogFactory.getLog(ReadTest.class);
    
    @Test
    public void testCreate() throws Exception {
        Result rt = getAmazonEndpoint().read("");
        log.warn("========id:" + rt.getId().getValue());
    }
}
