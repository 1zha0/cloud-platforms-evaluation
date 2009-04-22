package org.unsw.eva.wsclient.amazon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.wsclient.AbstractTest;

/**
 * @author fei
 */
public class CRUDByNumberTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(CRUDByNumberTest.class);
    private static final int NUMBER_OF_DATA = 5;

    @Before
    public void setUp() throws Exception {
        getAmazonEndpoint().cleanDefaultData(0, 0);
    }

    @Test
    public void testCRUDByNumber() throws Exception {

        getAmazonEndpoint().createDataByNumber(NUMBER_OF_DATA);
        getAmazonEndpoint().updateDataByNumber(NUMBER_OF_DATA);
        getAmazonEndpoint().readDataByNumber(NUMBER_OF_DATA);
        getAmazonEndpoint().deleteDataByNumber(NUMBER_OF_DATA);
    }

    @After
    public void cleanUp() throws Exception {
        getAmazonSimpleDBEndpoint().cleanDefaultData(0, 0);
    }
}
