package org.unsw.eva.data;

import java.util.ArrayList;

/**
 *
 * @author shrimpy
 */
public class ResultGroupData<ResultData> extends ArrayList<ResultData> {

    private Long startingTime = 0L;
    private Long endingTime = 0L;
    private Long totalConnectionTime = 0L;
    private Long totalComputationTime = 0L;
    private Long minConnectionTime = 0L;
    private Long maxConnectionTime = 0L;
    private Long minComputationTime = 0L;
    private Long maxComputationTime = 0L;
    private Long errorCounter = 0L;

    public Long getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Long endingTime) {
        this.endingTime = endingTime;
    }

    public Long getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Long startingTime) {
        this.startingTime = startingTime;
    }

    public Long getErrorCounter() {
        return errorCounter;
    }

    public void setErrorCounter(Long errorCounter) {
        this.errorCounter = errorCounter;
    }

    public Long getMaxComputationTime() {
        return maxComputationTime;
    }

    public void setMaxComputationTime(Long maxComputationTime) {
        this.maxComputationTime = maxComputationTime;
    }

    public Long getMaxConnectionTime() {
        return maxConnectionTime;
    }

    public void setMaxConnectionTime(Long maxConnectionTime) {
        this.maxConnectionTime = maxConnectionTime;
    }

    public Long getMinComputationTime() {
        return minComputationTime;
    }

    public void setMinComputationTime(Long minComputationTime) {
        this.minComputationTime = minComputationTime;
    }

    public Long getMinConnectionTime() {
        return minConnectionTime;
    }

    public void setMinConnectionTime(Long minConnectionTime) {
        this.minConnectionTime = minConnectionTime;
    }

    public Long getTotalComputationTime() {
        return totalComputationTime;
    }

    public void setTotalComputationTime(Long totalComputationTime) {
        this.totalComputationTime = totalComputationTime;
    }

    public Long getTotalConnectionTime() {
        return totalConnectionTime;
    }

    public void setTotalConnectionTime(Long totalConnectionTime) {
        this.totalConnectionTime = totalConnectionTime;
    }

    public void errorOccured() {
        errorCounter++;
    }
}
