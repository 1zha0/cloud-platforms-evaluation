package org.unsw.eva.rest.azure;

import java.util.Calendar;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.client.methods.HttpRequestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.utils.Base64Coder;

/**
 *
 * @author shrimpy
 */
public abstract class AbstractAzureStorageRestAction {

    public enum CONTENT_TYPE {

        TEXT_PLAIN("text/plain; charset=UTF-8");
        private String value;

        private CONTENT_TYPE(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    private static final Logger log = LoggerFactory.getLogger(AbstractAzureStorageRestAction.class);
    public static String ACCOUNT = "azurevadb";
    public static String KEY = "3uoYPf/GkU7uxgtk9x9zUBanQ3O4VReM1OfMYISbiC6WRtw7cOsbOgdWpZJJ0g6uJ2oNQYp0cF7yeb7bNsBw7A==";
    public static String REQUEST_URI = "http://" + ACCOUNT + ".blob.core.windows.net/container/abc";
    public static String ContentType = "Content-Type";
    public static String X_MS_Date = "x-ms-date";

    public static synchronized void Sign(HttpRequestBase request, String account, String key) throws Exception {
        SimpleDateFormat fmt = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
        fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
        request.setHeader(X_MS_Date, fmt.format(Calendar.getInstance().getTime()) + " GMT");

        StringBuilder sb = new StringBuilder();
        sb.append(request.getMethod().toUpperCase() + "\n\n");
        if (request.getFirstHeader(ContentType) != null) {
            sb.append(request.getFirstHeader(ContentType).getValue());
        }
        sb.append("\n\n");

        sb.append(X_MS_Date + ":" + request.getFirstHeader("x-ms-date").getValue() + "\n");
        if (request.getURI().getQuery() != null) {
            sb.append("/" + account + request.getURI().getPath() + "?" + request.getURI().getQuery());
        } else {
            sb.append("/" + account + request.getURI().getPath());
        }

        log.debug(sb.toString());

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(Base64Coder.decode(key), "HmacSHA256"));
        String finalKey = new String(Base64Coder.encode(mac.doFinal(sb.toString().getBytes("UTF-8"))));
        request.setHeader("Authorization", "SharedKey " + account + ":" + finalKey);
    }
}