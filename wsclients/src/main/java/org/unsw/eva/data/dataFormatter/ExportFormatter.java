package org.unsw.eva.data.dataFormatter;

import java.text.SimpleDateFormat;
import java.util.List;
import org.unsw.eva.FileSuffix;
import org.unsw.eva.data.ResultGroupData;

/**
 *
 * @author shrimpy
 */
public interface ExportFormatter {

    public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    public static final String COLUMN_SPERATOR = ",";
    public static final String NEW_LINE = "\n";
    public static final int INTERVAL_FOR_TIME_STAMP = 2 * 1000;

    String formatResultData(List<ResultGroupData> dataList);

    String formatResultDataGroup(List<ResultGroupData> dataList);

    String formatTimestampWithResponesCount(List<ResultGroupData> dataList);

    FileSuffix getSuffix();
}
