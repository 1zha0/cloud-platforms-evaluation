package org.unsw.eva.data.dataFormatter;

import org.unsw.eva.FileSuffix;

import java.util.List;
import org.unsw.eva.data.ResultGroupData;

/**
 *
 * @author shrimpy
 */
public class ResultListCSVFormatter implements ResultListFormatter {

    public String formatResultData(List<ResultGroupData> dataList) {
        StringBuilder sb = new StringBuilder("Name,");

        for (ResultGroupData resultData : dataList) {
        }
        return sb.toString();
    }

    public FileSuffix getSuffix() {
        return FileSuffix.CSV;
    }
}
