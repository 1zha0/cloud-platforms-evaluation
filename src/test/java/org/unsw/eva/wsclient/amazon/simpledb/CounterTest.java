package org.unsw.eva.wsclient.amazon.simpledb;

import org.unsw.eva.wsclient.AbstractTest;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author fei
 */
public class CounterTest extends AbstractTest {

    @Test
    public void testReadAndResetCounter() throws Exception {

        getAmazonSimpleDBEndpoint().resetCounter();
        assertTrue(getAmazonEndpoint().getCounter() == 0);
    }
}
