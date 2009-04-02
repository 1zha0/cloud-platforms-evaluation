package org.unsw.eva.data.dataFormatter;

import org.unsw.eva.FileSuffix;

import java.util.List;
import org.unsw.eva.data.ResultData;
import org.unsw.eva.data.ResultGroupData;

/**
 *
 * @author shrimpy
 */
public class ResultListCSVFormatter implements ResultListFormatter {

    public String formatResultData(List<ResultGroupData> dataList) {
        StringBuilder sb = new StringBuilder("Name,");

        for (ResultGroupData resultGroup : dataList) {
            for (ResultData data : resultGroup.getResultDatas()) {
                sb.append(data.getDescription());
                sb.append(COLUMN_SPERATOR);
                sb.append(data.getConnectionTime());
                sb.append(COLUMN_SPERATOR);
                sb.append(data.getComputationTime());
                sb.append(COLUMN_SPERATOR);
                sb.append(data.getIsError());
                sb.append(NEW_LINE);
            }
        }
        return sb.toString();
    }

    public FileSuffix getSuffix() {
        return FileSuffix.CSV;
    }
}
