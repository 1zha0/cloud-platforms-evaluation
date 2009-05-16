package org.unsw.eva.rest.azure;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public class DeleteBlob extends AbstractAzureStorageRestAction {

    private static final Logger log = LoggerFactory.getLogger(DeleteBlob.class);

    public static void main(String args[]) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpDelete delete = new HttpDelete("http://" + DeleteBlob.ACCOUNT + ".blob.core.windows.net/container/abc");
        Sign(delete, DeleteBlob.ACCOUNT, DeleteBlob.KEY);

        log.debug(EntityUtils.toString(httpclient.execute(delete).getEntity()));
    }
}
