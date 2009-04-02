package org.unsw.eva.io;

import java.io.File;
import org.unsw.eva.FileSuffix;

/**
 *
 * @author shrimpy
 */
public class IOWriterHelper {

    public static final String OUTPUT_FILE_NAME = "ResultOutput.csv";
    public static final String ROOT_PATH = (String) System.getProperties().get("user.dir");

    public static File getOutputFile(String filename, FileSuffix suffix) {
        File file = null;

        // what system we are running on
        if (((String) System.getProperties().get("os.name")).toLowerCase().contains("windows")) {
            file = new File(ROOT_PATH + "\\" + filename + "." + suffix.getValue());
        } else {
            file = new File(ROOT_PATH + "/" + filename + "." + suffix.getValue());
        }
        return file;
    }
}
