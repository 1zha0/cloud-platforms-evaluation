package org.unsw.eva.rest.azure;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.FileRequestEntity;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.exceptions.ServerError;

/**
 *
 * @author shrimpy
 */
public class AzureStorageRestTests extends AbstractAzureStorageRestAction {

    private static final Logger log = LoggerFactory.getLogger(AzureStorageRestTests.class);
    private static final int NUMBER_OF_REQUEST = 1;
    private static HttpClient client = getClient();
    private static List<String> FILE_PATHS = new ArrayList<String>() {

        {
            add("sampleData/oneM.tar");
            add("sampleData/tenM.tar");
            add("sampleData/fifiteenM.tar");
        }
    };

    public static void main(String args[]) throws Exception {

        String uri = "http://" + AzureStorageRestTests.ACCOUNT + ".blob.core.windows.net/container/";

        int errors = 0;
        long totalTimeConsume = 0;
        for (String filepath : FILE_PATHS) {

            // ======================= PUT =======================
            errors = 0;
            totalTimeConsume = 0;
            for (int i = 0; i < NUMBER_OF_REQUEST; i++) {
                String azureUri = uri + filepath.replace("/", "_").replace(".", "_") + i;

                long start = Calendar.getInstance().getTimeInMillis();
                try {
                    doPut(azureUri, filepath, CONTENT_TYPE.X_TAR);
                } catch (ServerError se) {
                    errors++;
                    log.error(se.getMessage());

                    continue;
                }
                long diff = (Calendar.getInstance().getTimeInMillis() - start);
                totalTimeConsume += diff;

                log.debug(azureUri + " : " + diff);
            }
            log.debug(filepath + " PUT " + NUMBER_OF_REQUEST + " | " +
                    " errors : " + errors +
                    " TotalTimeConsume : " + totalTimeConsume +
                    " AverageTimeConsume : " + totalTimeConsume / (NUMBER_OF_REQUEST - errors));

            // ======================= GET =======================
            errors = 0;
            totalTimeConsume = 0;
            for (int i = 0; i < NUMBER_OF_REQUEST; i++) {
                String azureUri = uri + filepath.replace("/", "_").replace(".", "_") + i;

                long start = Calendar.getInstance().getTimeInMillis();
                try {
                    doGet(azureUri);
                } catch (ServerError se) {
                    errors++;
                    log.error(se.getMessage());

                    continue;
                }
                long diff = (Calendar.getInstance().getTimeInMillis() - start);
                totalTimeConsume += diff;

                log.debug(azureUri + " : " + diff);
            }
            log.debug(filepath + " GET " + NUMBER_OF_REQUEST + " | " +
                    " errors : " + errors +
                    " TotalTimeConsume : " + totalTimeConsume +
                    " AverageTimeConsume : " + totalTimeConsume / (NUMBER_OF_REQUEST - errors));
            // ======================= DELETE =======================
            errors = 0;
            totalTimeConsume = 0;
            for (int i = 0; i < NUMBER_OF_REQUEST; i++) {
                String azureUri = uri + filepath.replace("/", "_").replace(".", "_") + i;

                long start = Calendar.getInstance().getTimeInMillis();
                try {
                    doDelete(azureUri);
                } catch (ServerError se) {
                    errors++;
                    log.error(se.getMessage());

                    continue;
                }
                long diff = (Calendar.getInstance().getTimeInMillis() - start);
                totalTimeConsume += diff;

                log.debug(azureUri + " : " + diff);
            }
            log.debug(filepath + " DELETE " + NUMBER_OF_REQUEST + " | " +
                    " errors : " + errors +
                    " TotalTimeConsume : " + totalTimeConsume +
                    " AverageTimeConsume : " + totalTimeConsume / (NUMBER_OF_REQUEST - errors));
        }
    }

    private static void doPut(String uri, String filePath, CONTENT_TYPE fileType) throws Exception {
        PutMethod put = new PutMethod(uri);
        put.addRequestHeader(AzureStorageRestTests.ContentType, fileType.getValue());

        File file = new File(filePath);
        put.setRequestEntity(new FileRequestEntity(file, fileType.getValue()));
        Sign(put, AzureStorageRestTests.ACCOUNT, AzureStorageRestTests.KEY);

        int status = client.executeMethod(put);

        byte[] responseBody = put.getResponseBody();
        String result = new String(responseBody);

        if (status != HttpStatus.SC_CREATED) {
            throw new ServerError("Falied to PUT data to " + uri + " " + result);
        }
    }

    private static void doGet(String uri) throws Exception {
        GetMethod get = new GetMethod(uri);
        Sign(get, AzureStorageRestTests.ACCOUNT, AzureStorageRestTests.KEY);

        int status = client.executeMethod(get);

        byte[] responseBody = get.getResponseBody();

        if (status != HttpStatus.SC_OK) {
            String result = new String(responseBody);
            throw new ServerError("Falied to GET data to " + uri + " " + result);
        }
    }

    private static void doDelete(String uri) throws Exception {
        DeleteMethod delete = new DeleteMethod(uri);
        Sign(delete, AzureStorageRestTests.ACCOUNT, AzureStorageRestTests.KEY);

        int status = client.executeMethod(delete);

        byte[] responseBody = delete.getResponseBody();

        if (status != HttpStatus.SC_ACCEPTED) {
            String result = new String(responseBody);
            throw new ServerError("Falied to PUT data to " + uri + " " + result);
        }
    }
}
