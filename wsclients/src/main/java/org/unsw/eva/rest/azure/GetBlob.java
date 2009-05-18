package org.unsw.eva.rest.azure;

//import org.apache.http.HttpEntity;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public class GetBlob extends AbstractAzureStorageRestAction {

    private static final Logger log = LoggerFactory.getLogger(GetBlob.class);

    public static void main(String args[]) throws Exception {
        HttpClient client = PutBlob.getClient();

        GetMethod get = new GetMethod("http://" + PutBlob.ACCOUNT + ".blob.core.windows.net/container/abc");
        Sign(get, PutBlob.ACCOUNT, PutBlob.KEY);

        int status = client.executeMethod(get);
        log.debug("status ==> " + status);
        if (status == HttpStatus.SC_OK) {
            byte[] responseBody = get.getResponseBody();
            log.debug(new String(responseBody));
        } else {
            log.error("Failed to GET data to remove database.");
        }
    }
}
