package org.unsw.eva;

import org.unsw.eva.data.ResultData;
import org.unsw.eva.data.ResultGroupData;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public class Monitor {

    private static final Logger log = LoggerFactory.getLogger(Monitor.class);
    private ResultData resultData;
    private ResultGroupData resultGroupData = new ResultGroupData();

    /**
     * Reset counters for thread.
     */
    private void reset() {
        resultData = new ResultData();
    }

    public void threadIsGoingToBeStarted(String name) {
        reset();
        resultData.setDescription(name);
        resultGroupData.setStartingTime(Calendar.getInstance().getTimeInMillis());
    }

    public void threadFinished() {
        resultGroupData.setEndingTime(Calendar.getInstance().getTimeInMillis());
//        log.debug(" Total connection time : " + totalConnectionTime +
//                " min Connection time : " + minConnectionTime +
//                " max Connection time : " + maxConnectionTime +
//                " total computation time :" + totalComputationTime +
//                " min computation time :" + minComputationTime +
//                " max computation time :" + maxComputationTime);
        resultGroupData.add(resultData);
    }

    public void monitorConnectionTime(long timeStamp) {
        calculateMinConnectionTime(timeStamp);
        calculateMaxConnectionTime(timeStamp);
        resultGroupData.setTotalConnectionTime(resultGroupData.getTotalConnectionTime() + timeStamp);
    }

    public void monitorComputationTime(long timeStamp) {
        calculateMinComputationTime(timeStamp);
        calculateMaxComputationTime(timeStamp);
        resultGroupData.setTotalComputationTime(resultGroupData.getTotalComputationTime() + timeStamp);
    }

    public void calculateMinConnectionTime(long timeStamp) {
        if (timeStamp < resultGroupData.getMinConnectionTime() || resultGroupData.getMinConnectionTime() == 0) {
            resultGroupData.setMinConnectionTime(timeStamp);
        }
    }

    public void calculateMaxConnectionTime(long timeStamp) {
        if (timeStamp > resultGroupData.getMaxConnectionTime() || resultGroupData.getMaxConnectionTime() == 0) {
            resultGroupData.setMaxConnectionTime(timeStamp);
        }
    }

    public void calculateMinComputationTime(long timeStamp) {
        if (timeStamp < resultGroupData.getMinComputationTime() || resultGroupData.getMinComputationTime() == 0) {
            resultGroupData.setMinComputationTime(timeStamp);
        }
    }

    public void calculateMaxComputationTime(long timeStamp) {
        if (timeStamp > resultGroupData.getMaxComputationTime() || resultGroupData.getMaxComputationTime() == 0) {
            resultGroupData.setMaxComputationTime(timeStamp);
        }
    }

    public void errorOccured() {
        resultGroupData.errorOccured();
    }

    public ResultGroupData getResultGroupData() {
        return resultGroupData;
    }
}
