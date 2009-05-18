package org.unsw.eva.rest.azure;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public class PutBlob extends AbstractAzureStorageRestAction {

    private static final Logger log = LoggerFactory.getLogger(PutBlob.class);

    public static void main(String args[]) throws Exception {

        HttpClient client = PutBlob.getClient();

        PutMethod put = new PutMethod("http://" + PutBlob.ACCOUNT + ".blob.core.windows.net/container/abc");
        put.addRequestHeader(PutBlob.ContentType, PutBlob.CONTENT_TYPE.TEXT_PLAIN.getValue());
        put.setRequestEntity(new StringRequestEntity("hEllo world !!!", "text/plain", "UTF-8"));
        Sign(put, PutBlob.ACCOUNT, PutBlob.KEY);

        int status = client.executeMethod(put);
        log.debug("status ==> " + status);
        if (status == HttpStatus.SC_CREATED) {
            byte[] responseBody = put.getResponseBody();
            log.debug(new String(responseBody));
        }
        else{
            log.error("Failed to PUT data to remote database.");
        }
    }
}
