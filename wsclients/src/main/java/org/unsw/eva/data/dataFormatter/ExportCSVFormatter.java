package org.unsw.eva.data.dataFormatter;

import org.unsw.eva.FileSuffix;
import org.unsw.eva.data.ResultData;
import org.unsw.eva.data.ResultGroupData;

import java.util.List;

/**
 *
 * @author shrimpy
 */
public class ExportCSVFormatter implements ExportFormatter {

    public String formatResultData(List<ResultGroupData> dataList) {
        /**
         * Define meta data for all the columns
         */
        StringBuilder sb = new StringBuilder(ResultData.Field.DESCRIPTION.getValue());
        sb.append(COLUMN_SPERATOR);
        sb.append(ResultData.Field.CONNECTION_TIME.getValue());
        sb.append(COLUMN_SPERATOR);
        sb.append(ResultData.Field.COMPUTATION_TIME.getValue());
        sb.append(COLUMN_SPERATOR);
        sb.append(ResultData.Field.ERROR.getValue());
        sb.append(NEW_LINE);

        /**
         * Populate datas
         */
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
