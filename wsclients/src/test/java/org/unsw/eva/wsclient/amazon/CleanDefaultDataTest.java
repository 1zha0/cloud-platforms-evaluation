package org.unsw.eva.wsclient.amazon;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.wsclient.AbstractTest;

/**
 * @author fei
 */
public class CleanDefaultDataTest extends AbstractTest{

    private static final Logger log = LoggerFactory.getLogger(CleanDefaultDataTest.class);

    @Test
    public void testCleanDefaultData() throws Exception {
        getAmazonEndpoint().cleanDefaultData(0, 0);
    }
}
