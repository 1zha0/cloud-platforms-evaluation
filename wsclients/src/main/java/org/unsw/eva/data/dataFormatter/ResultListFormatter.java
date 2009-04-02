package org.unsw.eva.data.dataFormatter;

import java.util.List;
import org.unsw.eva.FileSuffix;
import org.unsw.eva.data.ResultGroupData;

/**
 *
 * @author shrimpy
 */
public interface ResultListFormatter {

    public static final String COLUMN_SPERATOR = ",";

    String formatResultData(List<ResultGroupData> dataList);

    FileSuffix getSuffix();
}
