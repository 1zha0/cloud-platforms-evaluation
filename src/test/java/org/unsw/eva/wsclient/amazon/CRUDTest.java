package org.unsw.eva.wsclient.amazon;

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
        getAmazonEndpoint().cleanDefaultData(0, 0);
    }

    @Test
    public void testCRUD() throws Exception {

        String id;
        Result result = getAmazonEndpoint().create(CONTENT);
        id = result.getId().getValue();
        assertTrue(id != null);

        result = getAmazonEndpoint().read(CONTENT);
        assertTrue(id.equals(result.getId().getValue()));

        result = getAmazonEndpoint().update(CONTENT, CONTENT + CONTENT);
        assertTrue(id.equals(result.getId().getValue()));

        result = getAmazonEndpoint().delete(CONTENT + CONTENT);
    }

    @After
    public void cleanUp() throws Exception {
        getAmazonEndpoint().cleanDefaultData(0, 0);
    }
}
