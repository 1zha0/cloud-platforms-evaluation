package org.unsw.eva.rest.azure;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author shrimpy
 */
public class GetBlob extends AbstractAzureStorageRestAction {

    private static final Logger log = LoggerFactory.getLogger(GetBlob.class);

    public static void main(String args[]) throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet get = new HttpGet("http://" + GetBlob.ACCOUNT + ".blob.core.windows.net/container?comp=list");
//        get.addHeader(GetBlob.ContentType, GetBlob.CONTENT_TYPE.TEXT_PLAIN.getValue());
//        get.setEntity(new StringEntity("Hello world!!---", "UTF-8"));
        Sign(get, GetBlob.ACCOUNT, GetBlob.KEY);

        HttpEntity entity = httpclient.execute(get).getEntity();


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(entity.getContent());

        Element element = doc.getDocumentElement();
        element.getElementsByTagName("Blobs");

        log.debug("abc");
    }
}
