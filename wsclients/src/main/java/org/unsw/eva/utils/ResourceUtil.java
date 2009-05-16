package org.unsw.eva.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.cloudcomputingevaluation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.data.ResultGroupData;

/**
 *
 * @author shrimpy
 */
public class ResourceUtil {

    private static final Logger log = LoggerFactory.getLogger(ResourceUtil.class);

    public static synchronized String convertResultToString(Result result) {

        StringBuilder sb = new StringBuilder(result.getClass().getSimpleName());
        sb.append("( id : ");
        sb.append(result.getId());
        sb.append(" | value : ");
        sb.append(result.getValue().getValue().length() > 10
                ? result.getValue().getValue().substring(0, 8) + "..."
                : result.getValue().getValue());
        sb.append(" | timer : ");
        sb.append(result.getTimer());
        sb.append(" )");
//        sb.append(result.toString());

        return sb.toString();
    }
    private static String sendString = "";

    public static synchronized void setSendString() {
        String filename = "RESOURCE.txt";
        Integer numbe = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            numbe = Integer.valueOf(reader.readLine());
        } catch (Exception ex) {
            log.error("Failed to load round number from file " + filename, ex);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    log.error("Failed to close BufferedReader for " + filename, ex);
                }
            }
        }

        String seed = "a";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbe; i++) {
            sb.append(seed);
        }
        sendString = sb.toString();
    }

    public static synchronized String getSendString() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 10; i++) {
//            sb.append("0123456789");
//        }
//        return sb.toString();
        return sendString;
    }

    public static synchronized List<ResultGroupData> aggreagateResultGroup(List<ResultGroupData> list) {
        List<ResultGroupData> result = new ArrayList<ResultGroupData>();

        Map<String, ResultGroupData> resultMap = new HashMap<String, ResultGroupData>();

        for (ResultGroupData rg : list) {
            rg.populateData();
            if (resultMap.get(rg.getDescription()) == null) {
                ResultGroupData newRGD = new ResultGroupData();
                newRGD.getResultDatas().addAll(rg.getResultDatas());
                newRGD.setDescription(rg.getDescription());
                newRGD.setTotalRunningTime(rg.getTotalRunningTime());
                newRGD.setThreadNumber(newRGD.getThreadNumber() + 1);

                resultMap.put(rg.getDescription(), newRGD);
            } else {
                ResultGroupData temp = resultMap.get(rg.getDescription());
                temp.setThreadNumber(temp.getThreadNumber() + 1);
                temp.setTotalRunningTime(temp.getTotalRunningTime() + rg.getTotalRunningTime());
                temp.getResultDatas().addAll(rg.getResultDatas());

                resultMap.put(rg.getDescription(), temp);
            }
        }
        for (String key : resultMap.keySet()) {
            result.add(resultMap.get(key));
        }

        return result;
    }

    /**
     * Read round number from file ./ROUND.txt
     * and plus one to be the current round,
     * if it is equal to the given maxRoundNum,
     * reset the round to be zero.
     *
     * E.g maxRoundNum = 3
     * Correct round number will be 0, 1, 2
     * when it comes to 3, will be reset back to be 0 again
     *
     * @param maxRoundNum
     *      Must not be null.
     * 
     * @return
     *      Round number in Interger.
     */
    public synchronized static Integer generateNumberOfTotalThreads(int start, int maxRoundNum, int interval) {
        String filename = "THREADS.txt";
        Integer numbe = 0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            numbe = Integer.valueOf(reader.readLine());
        } catch (Exception ex) {
            log.error("Failed to load round number from file " + filename, ex);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    log.error("Failed to close BufferedReader for " + filename, ex);
                }
            }
        }
//        numbe = numbe + interval;
//
//        PrintWriter outputStream = null;
//        try {
//            outputStream = new PrintWriter(new FileWriter(filename));
//            if (numbe == null || numbe > maxRoundNum) {
//                numbe = start;
//            }
//            outputStream.print(numbe);
//        } catch (Exception ex) {
//            log.error("Failed to update round number to file " + filename, ex);
//        } finally {
//            if (outputStream != null) {
//                outputStream.close();
//            }
//        }
        return numbe;
    }
}
