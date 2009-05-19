package org.unsw.eva.wsclient.amazon.simpledb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.unsw.eva.wsclient.AbstractTest;

/**
 * @author fei
 */
public class SimpleDBCreateTest extends AbstractTest {

    private final static Log log = LogFactory.getLog(SimpleDBCreateTest.class);
    private StringBuilder content = new StringBuilder();

    @Before
    public void testBefore() throws Exception {
        for (int i = 0; i < 1024; i++) {
            content.append("a");
        }
    }

    @Test
    public void testCreate() throws Exception {
        getAmazonSimpleDBEndpoint().create(content.toString());
    }
}
