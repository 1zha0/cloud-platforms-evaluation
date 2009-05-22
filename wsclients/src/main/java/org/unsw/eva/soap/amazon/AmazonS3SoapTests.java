package org.unsw.eva.soap.amazon;

import com.amazon.s3.AWSAuthConnection;
import com.amazon.s3.GetResponse;
import com.amazon.s3.ListBucketResponse;
import com.amazon.s3.ListEntry;
import com.amazon.s3.Response;
import com.amazon.s3.S3Object;
import java.io.IOException;
import java.net.MalformedURLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fei
 */
public class AmazonS3SoapTests {

    private static final Logger log = LoggerFactory.getLogger(AmazonS3SoapTests.class);
    private static final int NUMBER_OF_REQUEST = 10;
    private static String bucketName = "largefile";
    private static String accessKeyId = "1JZY11RXWCCX5AD7ADR2";
    private static String secretAccessKey = "V2IjiHjxfR3y/q4y9c3JaA0kitLLwFMFB+fec1os";
    private static AWSAuthConnection conn = new AWSAuthConnection(accessKeyId, secretAccessKey);
    private static List<String> FILE_PATHS = new ArrayList<String>() {

        {
            add("sampleData/oneM.tar");
            add("sampleData/tenM.tar");
            add("sampleData/fifiteenM.tar");
        }
    };

    public static void main(String args[]) throws Exception {
//        try {
//            if (!conn.checkBucketExists(bucketName)) {
//                log.debug("----- creating bucket -----");
//                Response response = conn.createBucket(bucketName, AWSAuthConnection.LOCATION_DEFAULT, null);
//                log.debug("--response message:" + response.connection.getResponseMessage());
//            } else {
//                log.debug("----- bucket exists -----");
//                Response response = conn.deleteBucket(bucketName, null);
//                log.debug("--response message:" + response.connection.getResponseMessage());
//                log.debug("----- creating bucket -----");
//                response = conn.createBucket(bucketName, AWSAuthConnection.LOCATION_DEFAULT, null);
//                log.debug("--response message:" + response.connection.getResponseMessage());
//            }
//        } catch (MalformedURLException ex) {
//            log.error(ex.getMessage());
//        } catch (IOException ex) {
//            log.error(ex.getMessage());
//        }
//        LIST();
//        System.getProperties().put("proxySet", "true");
//        System.getProperties().put("proxyHost", "www-proxy.cse.unsw.edu.au");
//        System.getProperties().put("proxyPort", "3128");
        for (int i = 0; i < FILE_PATHS.size(); i++) {
            PUT(FILE_PATHS.get(i), i);
            GET(i);
            DEL(i);
        }
    }

    private static void PUT(String filepath, int st) {
        int errors = 0;
        long totalTimeConsume = 0;
        File file = new File(filepath);
        S3Object object = null;
        Response response = null;
        try {
            object = new S3Object(getBytesFromFile(file), null);
        } catch (IOException ex) {
            log.error("Could not write to S3:" + ex.getMessage());
        }
        int key = 0;
        if (st == 0) {
            key = 1;
        } else if (st == 1) {
            key = 1000;
        } else if (st == 2) {
            key = 4000;
        }
        for (int i = 0; i < NUMBER_OF_REQUEST; i++) {
            long start = Calendar.getInstance().getTimeInMillis();
            try {
                response = conn.put(bucketName, String.valueOf(key), object, null);
                log.debug("response messge:" + response.connection.getResponseMessage());
                key++;
            } catch (MalformedURLException ex) {
                errors++;
                log.error(ex.getMessage());
                continue;
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(AmazonS3SoapTests.class.getName()).log(Level.SEVERE, null, ex);
                errors++;
                log.error(ex.getMessage());
                continue;
            }
            long diff = (Calendar.getInstance().getTimeInMillis() - start);
            totalTimeConsume += diff;
            log.debug("PUT key" + (key - 1) + " : " + diff);
        }
        log.debug(filepath + " PUT " + NUMBER_OF_REQUEST + " | " +
                " errors : " + errors +
                " TotalTimeConsume : " + totalTimeConsume +
                " AverageTimeConsume : " + totalTimeConsume / (NUMBER_OF_REQUEST - errors));
    }

    private static void GET(int st) {
        int errors = 0;
        long totalTimeConsume = 0;
        GetResponse gr = null;
        int key = 0;
        if (st == 0) {
            key = 1;
        } else if (st == 1) {
            key = 1000;
        } else if (st == 2) {
            key = 4000;
        }
        for (int i = 0; i < NUMBER_OF_REQUEST; i++) {
            long start = Calendar.getInstance().getTimeInMillis();
            try {
                gr = conn.get(bucketName, String.valueOf(key), null);
                log.debug("file length: " + String.valueOf(gr.object.data.length));
                key++;
            } catch (MalformedURLException ex) {
                errors++;
                log.error(ex.getMessage());
                continue;
            } catch (IOException ex) {
                errors++;
                log.error(ex.getMessage());
                continue;
            }
            long diff = (Calendar.getInstance().getTimeInMillis() - start);
            totalTimeConsume += diff;
            log.debug("GET key" + (key - 1) + " : " + diff);
        }
        log.debug(" GET " + NUMBER_OF_REQUEST + " | " +
                " errors : " + errors +
                " TotalTimeConsume : " + totalTimeConsume +
                " AverageTimeConsume : " + totalTimeConsume / (NUMBER_OF_REQUEST - errors));
    }

    private static void DEL(int st) {
        int errors = 0;
        long totalTimeConsume = 0;
        Response response = null;
        int key = 0;
        if (st == 0) {
            key = 1;
        } else if (st == 1) {
            key = 1000;
        } else if (st == 2) {
            key = 4000;
        }
        for (int i = 0; i < NUMBER_OF_REQUEST; i++) {
            long start = Calendar.getInstance().getTimeInMillis();
            try {
                response = conn.delete(bucketName, String.valueOf(key), null);
                if (response.connection.getResponseCode() == 204) {
                    log.debug("successfully deleted");
                } else {
                    log.debug("not successfully deleted");
                }
                key++;
            } catch (MalformedURLException ex) {
                errors++;
                log.error(ex.getMessage());
                continue;
            } catch (IOException ex) {
                errors++;
                log.error(ex.getMessage());
                continue;
            }
            long diff = (Calendar.getInstance().getTimeInMillis() - start);
            totalTimeConsume += diff;
            log.debug("DEL key" + (key - 1) + " : " + diff);
        }
        log.debug(" DELETE " + NUMBER_OF_REQUEST + " | " +
                " errors : " + errors +
                " TotalTimeConsume : " + totalTimeConsume +
                " AverageTimeConsume : " + totalTimeConsume / (NUMBER_OF_REQUEST - errors));
    }

    private static void LIST() {
        ListBucketResponse response = null;
        try {
            response = conn.listBucket(bucketName, null, null, null, null);
            log.warn("response: " + response);
        } catch (MalformedURLException ex) {
            log.error(ex.getMessage());
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        List objects = response.entries;
        for (Iterator it = objects.iterator(); it.hasNext();) {
            ListEntry entry = (ListEntry) it.next();
            log.warn("key = " + entry.key + " size = " + entry.size);
        }
    }

    private static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        if (length > Integer.MAX_VALUE) {
            // File is too large
            log.error("The file is too big");
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }
}
