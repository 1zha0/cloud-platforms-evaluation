package org.unsw.eva.data.dataFormatter;

import org.unsw.eva.FileSuffix;
import org.unsw.eva.data.ResultData;
import org.unsw.eva.data.ResultGroupData;
import org.unsw.eva.utils.ResourceUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
                sb.append(data.getEndingTime() == null ? null : formatter.format(new Date(data.getEndingTime())));
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
        sb.append("Total threads");
        sb.append(COLUMN_SPERATOR);
        sb.append("Total requests");
        sb.append(COLUMN_SPERATOR);
        sb.append("Error num.");
        sb.append(COLUMN_SPERATOR);
        sb.append("Total running time");
        sb.append(COLUMN_SPERATOR);
        sb.append("Avg. request/Sec.");
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
            sb.append(rg.getThreadNumber());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getResultDatas().size());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getErrorCounter());
            sb.append(COLUMN_SPERATOR);
            sb.append(rg.getTotalRunningTime() / rg.getThreadNumber());
            sb.append(COLUMN_SPERATOR);
            sb.append(Float.valueOf(rg.getGoodRequestSize()) / (Float.valueOf(rg.getTotalRunningTime()) / 1000F / Float.valueOf(rg.getThreadNumber())));
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

    public String formatTimestampWithResponesCount(List<ResultGroupData> dataList) {
        String result = "";

        List<ResultGroupData> groupByName = ResourceUtil.aggreagateResultGroup(dataList);

        Comparator<ResultData> cp = new Comparator<ResultData>() {

            public int compare(ResultData o1, ResultData o2) {
                if (o1.getEndingTime() == null) {
                    return -1;
                } else if (o2.getEndingTime() == null) {
                    return 1;
                } else {
                    return o1.getEndingTime().compareTo(o2.getEndingTime());
                }
            }
        };

        for (ResultGroupData resultGroupData : groupByName) {
            resultGroupData.populateData();
            result += resultGroupData.getDescription() + NEW_LINE;

            List<ResultData> datas = resultGroupData.getResultDatas();
            Collections.sort(datas, cp);

            int counter = 0;
            long tempTime = 0;
            for (int i = 0; i < datas.size(); i++) {
                ResultData resultData = datas.get(i);
                if (tempTime == 0) {
                    counter++;
                    tempTime = resultData.getEndingTime();
                } else if (i == (datas.size() - 1)) {
                    if (resultData.getEndingTime() < (tempTime + INTERVAL_FOR_TIME_STAMP)) {
                        counter++;
                        result += counter + NEW_LINE;
                    } else {
                        tempTime += INTERVAL_FOR_TIME_STAMP;
                        result += counter + NEW_LINE;
                        counter = 0;
                        if (resultData.getEndingTime() < (tempTime + INTERVAL_FOR_TIME_STAMP)) {
                            counter++;
                        }
                    }
                } else {
                    if (resultData.getEndingTime() < (tempTime + INTERVAL_FOR_TIME_STAMP)) {
                        counter++;
                    } else {
                        tempTime += INTERVAL_FOR_TIME_STAMP;
                        result += counter + NEW_LINE;
                        counter = 0;
                        if (resultData.getEndingTime() < (tempTime + INTERVAL_FOR_TIME_STAMP)) {
                            counter++;
                        }
                    }
                }
            }
        }

        return result;
    }

    public FileSuffix getSuffix() {
        return FileSuffix.CSV;
    }
}
