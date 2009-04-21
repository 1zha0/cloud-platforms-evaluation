package org.unsw.eva.wsclient.amazon.simpledb;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.wsclient.AbstractTest;

/**
 * @author fei
 */
public class CleanDefaultDataTest extends AbstractTest{

    private static final Logger log = LoggerFactory.getLogger(BinaryFileWriteReadTest.class);

    @Test
    public void testCleanDefaultData() throws Exception {
        getAmazonSimpleDBEndpoint().cleanDefaultData(0, 0);
    }
}
