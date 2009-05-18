package org.unsw.eva.rest.azure;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public class DeleteBlob extends AbstractAzureStorageRestAction {

    private static final Logger log = LoggerFactory.getLogger(DeleteBlob.class);

    public static void main(String args[]) throws Exception {
        HttpClient client = PutBlob.getClient();

        DeleteMethod delete = new DeleteMethod("http://" + PutBlob.ACCOUNT + ".blob.core.windows.net/container/abc");
        Sign(delete, PutBlob.ACCOUNT, PutBlob.KEY);

        int status = client.executeMethod(delete);
        log.debug("status ==> " + status);
        if (status == HttpStatus.SC_ACCEPTED) {
            byte[] responseBody = delete.getResponseBody();
            log.debug(new String(responseBody));
        } else {
            log.error("Failed to GET data to remove database.");
        }
    }
}
