package org.unsw.eva.data.dataFormatter;

import org.unsw.eva.FileSuffix;
import org.unsw.eva.data.ResultData;
import org.unsw.eva.data.ResultGroupData;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.utils.ResourceUtil;

/**
 *
 * @author shrimpy
 */
public class ExportCSVFormatter implements ExportFormatter {

    private static final Logger log = LoggerFactory.getLogger(ExportCSVFormatter.class);

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
        sb.append(COLUMN_SPERATOR);
        sb.append(ResultData.Field.ENDING_TIME.getValue());
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
                sb.append(COLUMN_SPERATOR);
                sb.append(data.getEndingTime());
                sb.append(NEW_LINE);
            }
        }
        return sb.toString();
    }

    public String formatResultDataGroup(List<ResultGroupData> dataList) {
        /**
         * Define meta data for all the columns
         */
        StringBuilder sb = new StringBuilder("Name");
        sb.append(COLUMN_SPERATOR);
        sb.append("Total requests");
        sb.append(COLUMN_SPERATOR);
        sb.append("Error num.");
        sb.append(COLUMN_SPERATOR);
        sb.append("Total running time");
        sb.append(COLUMN_SPERATOR);
        sb.append("Avg. threads/Sec.");
        sb.append(COLUMN_SPERATOR);
        sb.append("Avg. conn. Time");
        sb.append(COLUMN_SPERATOR);
        sb.append("Avg. comp. Time");
        sb.append(COLUMN_SPERATOR);
        sb.append("Min. conn. Time");
        sb.append(COLUMN_SPERATOR);
        sb.append("Max. conn. Time");
        sb.append(COLUMN_SPERATOR);
        sb.append("Min. comp. Time");
        sb.append(COLUMN_SPERATOR);
        sb.append("Max. comp. Time");
        sb.append(NEW_LINE);


        List<ResultGroupData> groupByName = ResourceUtil.aggreagateResultGroup(dataList);

        /**
         * Populate datas
         */
        for (ResultGroupData rg : groupByName) {
            rg.populateData();

            sb.append(rg.getDescription());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getResultDatas().size());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getErrorCounter());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getTotalRunningTime());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getAverageThreadsPerSec());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getAverageConnTime());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getAverageCompTime());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getMinConnectionTime());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getMaxConnectionTime());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getMinComputationTime());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getMaxComputationTime());
            sb.append(NEW_LINE);
        }
        return sb.toString();
    }

    public FileSuffix getSuffix() {
        return FileSuffix.CSV;
    }
}
