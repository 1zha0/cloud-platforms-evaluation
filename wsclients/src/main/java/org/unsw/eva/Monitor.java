package org.unsw.eva;

import org.unsw.eva.data.ResultData;
import org.unsw.eva.data.ResultGroupData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public abstract class Monitor {

    private static final Logger log = LoggerFactory.getLogger(Monitor.class);
    private ResultData[] resultDatas;
    private ResultGroupData resultGroupData = new ResultGroupData();

    public abstract int getCurrentThreadIndex();

    public Monitor(int numberOfThread) {
        resultDatas = new ResultData[numberOfThread];
    }

    public void threadIsGoingToBeStarted(String name) {
        resultDatas[getCurrentThreadIndex()].setDescription(name);
    }

    public void threadFinished() {
//        log.debug(" Total connection time : " + totalConnectionTime +
//                " min Connection time : " + minConnectionTime +
//                " max Connection time : " + maxConnectionTime +
//                " total computation time :" + totalComputationTime +
//                " min computation time :" + minComputationTime +
//                " max computation time :" + maxComputationTime);
        resultGroupData.add(resultDatas[getCurrentThreadIndex()]);
    }

    public void monitorConnectionTime(long timeStamp) {
        resultDatas[getCurrentThreadIndex()].setConnectionTime(timeStamp);
    }

    public void monitorComputationTime(long timeStamp) {
        resultDatas[getCurrentThreadIndex()].setComputationTime(timeStamp);
    }

    public void errorOccured() {
        resultDatas[getCurrentThreadIndex()].setIsError(Boolean.TRUE);
        resultGroupData.errorOccured();
    }

    public ResultGroupData getResultGroupData() {
        return resultGroupData;
    }
}
