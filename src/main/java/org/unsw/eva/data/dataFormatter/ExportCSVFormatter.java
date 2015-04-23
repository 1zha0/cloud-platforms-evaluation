package org.unsw.eva.data.dataFormatter;

import java.util.ArrayList;
import org.unsw.eva.FileSuffix;
import org.unsw.eva.data.ResultData;
import org.unsw.eva.data.ResultGroupData;
import org.unsw.eva.utils.ResourceUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.ErrorCode;
import org.unsw.eva.data.Pair;

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
        sb.append(ResultData.Field.STARTING_TIME.getValue());
        sb.append(COLUMN_SPERATOR);
        sb.append(ResultData.Field.ENDING_TIME.getValue());
        sb.append(COLUMN_SPERATOR);
        sb.append(ResultData.Field.SERVER_ENDING_TIME.getValue());
        sb.append(COLUMN_SPERATOR);
        sb.append(ResultData.Field.ROUND_BELONG_TO.getValue());
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
                sb.append(data.getError().getCode());
                sb.append(COLUMN_SPERATOR);
                sb.append(data.getStartingTime() == null ? null : formatter.format(new Date(data.getStartingTime())));
                sb.append(COLUMN_SPERATOR);
                sb.append(data.getEndingTime() == null ? null : formatter.format(new Date(data.getEndingTime())));
                sb.append(COLUMN_SPERATOR);
                sb.append(data.getServerSideEndingTime() == null ? null : formatter.format(new Date(data.getServerSideEndingTime())));
                sb.append(COLUMN_SPERATOR);
                sb.append(data.getRound());
                sb.append(NEW_LINE);
            }
        }
        return sb.toString();
    }

    public String formatResultDataToCdfDataOutputByRound(List<ResultGroupData> dataList) {

        Map<Integer, List<Long>> connectionTimeMap = new HashMap<Integer, List<Long>>();
        Map<Integer, List<Long>> computationTimeMap = new HashMap<Integer, List<Long>>();

        for (ResultGroupData resultGroup : dataList) {
            for (ResultData data : resultGroup.getResultDatas()) {
                Integer round = data.getRound();
                List<Long> connectionTimes = connectionTimeMap.get(round);
                List<Long> computationTimes = computationTimeMap.get(round);

                if (connectionTimes == null) {
                    connectionTimes = new ArrayList<Long>();
                }
                if (computationTimes == null) {
                    computationTimes = new ArrayList<Long>();
                }

                if (data.getError().equals(ErrorCode.NONE) && data.getConnectionTime() != null) {
                    connectionTimes.add(data.getConnectionTime());
                }
                if (data.getError().equals(ErrorCode.NONE) && data.getComputationTime() != null) {
                    computationTimes.add(data.getComputationTime());
                }

                connectionTimeMap.put(round, connectionTimes);
                computationTimeMap.put(round, computationTimes);
            }
        }

        List<Pair<Integer, List<Long>>> connList = new ArrayList<Pair<Integer, List<Long>>>();
        List<Pair<Integer, List<Long>>> compList = new ArrayList<Pair<Integer, List<Long>>>();

        Comparator<Long> cpLong = new Comparator<Long>() {

            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        };

        for (Integer keyOfRound : connectionTimeMap.keySet()) {
            List<Long> conns = connectionTimeMap.get(keyOfRound);
            Collections.sort(conns, cpLong);
            connList.add(new Pair<Integer, List<Long>>(keyOfRound, conns));
        }

        for (Integer keyOfRound : computationTimeMap.keySet()) {
            List<Long> comps = computationTimeMap.get(keyOfRound);
            Collections.sort(comps, cpLong);
            compList.add(new Pair<Integer, List<Long>>(keyOfRound, comps));
        }

        Comparator<Pair<Integer, List<Long>>> cpPair = new Comparator<Pair<Integer, List<Long>>>() {

            public int compare(Pair<Integer, List<Long>> o1, Pair<Integer, List<Long>> o2) {
                return o1.getA().compareTo(o2.getA());
            }
        };

        Collections.sort(connList, cpPair);
        Collections.sort(compList, cpPair);

        StringBuilder sb = new StringBuilder("Connection in round:");
        sb.append(NEW_LINE);
        for (Pair<Integer, List<Long>> conn : connList) {
            sb.append("Round " + conn.getA());
            sb.append(NEW_LINE);
            for (Long connTime : conn.getB()) {
                sb.append(connTime);
                sb.append(SPACE);
            }
            sb.append(NEW_LINE);
        }
        sb.append(NEW_LINE);
        sb.append("Computation in round:");
        sb.append(NEW_LINE);
        for (Pair<Integer, List<Long>> comp : compList) {
            sb.append("Round " + comp.getA());
            sb.append(NEW_LINE);
            for (Long compTime : comp.getB()) {
                sb.append(compTime);
                sb.append(SPACE);
            }
            sb.append(NEW_LINE);
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
                if (resultData == null || resultData.getEndingTime() == null) {
                    continue;
                }

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
