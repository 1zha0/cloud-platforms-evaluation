package org.unsw.eva;

import org.cloudcomputingevaluation.Result;
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
    private Integer round;

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
        resultDatas[getCurrentThreadIndex()].setRound(round);
    }

    public void threadFinished() {
        resultGroupData.add(resultDatas[getCurrentThreadIndex()]);
    }

    public void monitorConnectionTime(long current, long start) {
        resultDatas[getCurrentThreadIndex()].setStartingTime(start);
        resultDatas[getCurrentThreadIndex()].setEndingTime(current);
        resultDatas[getCurrentThreadIndex()].setConnectionTime(current - start);
    }

    public void monitorResult(Result result) {
        resultDatas[getCurrentThreadIndex()].setComputationTime(result.getTimer());
        resultDatas[getCurrentThreadIndex()].setServerSideEndingTime(Long.valueOf(result.getValue().getValue()));
    }

    public void errorOccured(ErrorCode error) {
        resultDatas[getCurrentThreadIndex()].setError(error);
        resultGroupData.errorOccured();
    }

    public ResultGroupData getResultGroupData() {
        return resultGroupData;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }
}
