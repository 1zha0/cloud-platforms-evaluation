package org.unsw.eva.data.dataFormatter;

import java.util.List;
import org.unsw.eva.FileSuffix;
import org.unsw.eva.data.ResultGroupData;

/**
 *
 * @author shrimpy
 */
public interface ExportFormatter {

    public static final String COLUMN_SPERATOR = ",";
    public static final String NEW_LINE = "\n";

    String formatResultData(List<ResultGroupData> dataList);

    FileSuffix getSuffix();
}
