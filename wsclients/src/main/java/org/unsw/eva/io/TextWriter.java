package org.unsw.eva.io;

import org.unsw.eva.data.dataFormatter.ExportFormatter;
import org.unsw.eva.data.ResultGroupData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shrimpy
 */
public class TextWriter extends IOWriterHelper {

    private static final Logger log = LoggerFactory.getLogger(TextWriter.class);

    public static void writeToFile(List<ResultGroupData> resultList, ExportFormatter formatter, String filename) {
        Validate.notNull(resultList);
        Validate.notNull(formatter);

        log.info("Createing result file from '" + resultList.size() + "' record(s)");
        File file = getOutputFile(filename, formatter.getSuffix());
        File fileGroup = getOutputFile(filename + "_group", formatter.getSuffix());
        File fileTimestamp = getOutputFile(filename + "_timestamp", formatter.getSuffix());
        Writer output = null;
        Writer outputGroup = null;
        Writer outputTimestamp = null;
        try {
            output = new BufferedWriter(new FileWriter(file));
            output.write(formatter.formatResultData(resultList));

            outputGroup = new BufferedWriter(new FileWriter(fileGroup));
            outputGroup.write(formatter.formatResultDataGroup(resultList));

            outputTimestamp = new BufferedWriter(new FileWriter(fileTimestamp));
            outputTimestamp.write(formatter.formatTimestampWithResponesCount(resultList));

        } catch (IOException ex) {
            log.error("Failed to write ResultList into file.", ex);
        } finally {
            try {
                output.close();
                outputGroup.close();
                outputTimestamp.close();
            } catch (IOException ex) {
                log.error("Failed to close buffer writer.", ex);
            }
        }
        log.info("Finished creating result file '" + file.getPath() + "'");
    }
}
