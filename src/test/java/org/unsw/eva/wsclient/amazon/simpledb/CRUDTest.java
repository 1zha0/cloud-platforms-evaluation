package org.unsw.eva.wsclient.amazon.simpledb;

import org.cloudcomputingevaluation.Result;
import org.junit.After;
import org.junit.Before;
import org.unsw.eva.wsclient.AbstractTest;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author fei
 */
public class CRUDTest extends AbstractTest {

    private static final String CONTENT = "This is the key";

    @Before
    public void setUp() throws Exception {
        getAmazonSimpleDBEndpoint().cleanDefaultData(0, 0);
    }

    @Test
    public void testCRUD() throws Exception {

        String id;
        Result result = getAmazonSimpleDBEndpoint().create(CONTENT);
        id = result.getId().getValue();
        assertTrue(id != null);

        result = getAmazonSimpleDBEndpoint().read(CONTENT);
        assertTrue(id.equals(result.getId().getValue()));

        result = getAmazonSimpleDBEndpoint().update(CONTENT, CONTENT + CONTENT);
        assertTrue(id.equals(result.getId().getValue()));

        result = getAmazonSimpleDBEndpoint().delete(CONTENT + CONTENT);
    }

    @After
    public void cleanUp() throws Exception {
        getAmazonSimpleDBEndpoint().cleanDefaultData(0, 0);
    }
}
