package org.unsw.eva.wsclient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.unsw.eva.data.Pair;
import org.unsw.eva.data.ResultData;

/**
 *
 * @author shrimpy
 */
public class Monitor {

    private long totalConnectionTime = 0;
    private long totalComputationTime = 0;
    private long minConnectionTime = 0;
    private long maxConnectionTime = 0;
    private long minComputationTime = 0;
    private long maxComputationTime = 0;
    private long currentConnectionTime = 0;
    private long currentComputationTime = 0;
    private ResultData resultData;
    private List<ResultData> resultList = new ArrayList<ResultData>();
    private long errorCounter = 0;

    protected void reset() {
        totalConnectionTime = 0;
        totalComputationTime = 0;
        minConnectionTime = 0;
        maxConnectionTime = 0;
        minComputationTime = 0;
        maxComputationTime = 0;
        currentConnectionTime = 0;
        currentComputationTime = 0;
        resultData = new ResultData();
        errorCounter = 0;
    }

    public synchronized void monitorConnectionTime(long timeStamp) {
        calculateMinConnectionTime(timeStamp);
        calculateMaxConnectionTime(timeStamp);
        setCurrentConnectionTime(timeStamp);
        setTotalConnectionTime(getTotalConnectionTime() + timeStamp);
        getResultData().getConnectionTimers().add(new Pair<Long, Long>(Calendar.getInstance().getTimeInMillis(), timeStamp));
    }

    public synchronized void monitorComputationTime(long timeStamp) {
        calculateMinComputationTime(timeStamp);
        calculateMaxComputationTime(timeStamp);
        setCurrentComputationTime(timeStamp);
        setTotalComputationTime(getTotalComputationTime() + timeStamp);
        getResultData().getComputationTimers().add(new Pair<Long, Long>(Calendar.getInstance().getTimeInMillis(), timeStamp));
    }

    public synchronized void calculateMinConnectionTime(long i) {
        if (i < minConnectionTime || minConnectionTime == 0) {
            minConnectionTime = i;
        }
    }

    public synchronized void calculateMaxConnectionTime(long i) {
        if (i > maxConnectionTime || maxConnectionTime == 0) {
            maxConnectionTime = i;
        }
    }

    public synchronized void calculateMinComputationTime(long i) {
        if (i < minComputationTime || minComputationTime == 0) {
            minComputationTime = i;
        }
    }

    public synchronized void calculateMaxComputationTime(long i) {
        if (i > maxComputationTime || maxComputationTime == 0) {
            maxComputationTime = i;
        }
    }

    public synchronized void errorOccured() {
        errorCounter++;
    }

    public synchronized long getCurrentComputationTime() {
        return currentComputationTime;
    }

    public synchronized void setCurrentComputationTime(long currentComputationTime) {
        this.currentComputationTime = currentComputationTime;
    }

    public synchronized long getCurrentConnectionTime() {
        return currentConnectionTime;
    }

    public synchronized void setCurrentConnectionTime(long currentConnectionTime) {
        this.currentConnectionTime = currentConnectionTime;
    }

    public synchronized ResultData getResultData() {
        return resultData;
    }

    public synchronized List<ResultData> getResultList() {
        return resultList;
    }

    public synchronized long getErrorCounter() {
        return errorCounter;
    }

    public synchronized long getMaxComputationTime() {
        return maxComputationTime;
    }

    public synchronized long getMaxConnectionTime() {
        return maxConnectionTime;
    }

    public synchronized long getMinComputationTime() {
        return minComputationTime;
    }

    public synchronized long getMinConnectionTime() {
        return minConnectionTime;
    }

    public synchronized long getTotalComputationTime() {
        return totalComputationTime;
    }

    public void setTotalComputationTime(long totalComputationTime) {
        this.totalComputationTime = totalComputationTime;
    }

    public void setTotalConnectionTime(long totalConnectionTime) {
        this.totalConnectionTime = totalConnectionTime;
    }

    public synchronized long getTotalConnectionTime() {
        return totalConnectionTime;
    }
}
