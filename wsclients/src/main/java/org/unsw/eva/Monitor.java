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

    public void initiate(int numberOfThread) {
        /**
         * Initialize container to store results.
         */
        resultDatas = new ResultData[numberOfThread];
        for (int i = 0; i < resultDatas.length; i++) {
            resultDatas[i] = new ResultData();
        }
    }

    public void threadIsGoingToBeStarted(String name) {
        resultDatas[getCurrentThreadIndex()].setDescription(name);
    }

    public void threadFinished() {
        resultGroupData.add(resultDatas[getCurrentThreadIndex()]);
    }

    public void monitorConnectionTime(long current, long start) {
        resultDatas[getCurrentThreadIndex()].setEndingTime(current);
        resultDatas[getCurrentThreadIndex()].setConnectionTime(current - start);
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
