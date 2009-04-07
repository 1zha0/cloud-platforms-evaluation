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

    public static final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    public static final String COLUMN_SPERATOR = ",";
    public static final String NEW_LINE = "\n";

    String formatResultData(List<ResultGroupData> dataList);

    String formatResultDataGroup(List<ResultGroupData> dataList);

    FileSuffix getSuffix();
}
