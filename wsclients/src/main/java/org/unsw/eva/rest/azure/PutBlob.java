package org.unsw.eva.rest.azure;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public class PutBlob extends AbstractAzureStorageRestAction {

    private static final Logger log = LoggerFactory.getLogger(PutBlob.class);

    public static void main(String args[]) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPut put = new HttpPut("http://" + PutBlob.ACCOUNT + ".blob.core.windows.net/container/abc");
        put.addHeader(PutBlob.ContentType, PutBlob.CONTENT_TYPE.TEXT_PLAIN.getValue());
        put.setEntity(new StringEntity("Hello world", "UTF-8"));
        Sign(put, PutBlob.ACCOUNT, PutBlob.KEY);

        log.debug(EntityUtils.toString(httpclient.execute(put).getEntity()));
    }
}
