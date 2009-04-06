package org.unsw.eva.data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shrimpy
 */
public class ResultGroupData {

    private List<ResultData> resultDatas = new ArrayList<ResultData>();
    private String description;
    private Long totalRunningTime = 0L;
    private Long totalConnectionTime = 0L;
    private Long totalComputationTime = 0L;
    private Long minConnectionTime = 0L;
    private Long maxConnectionTime = 0L;
    private Long minComputationTime = 0L;
    private Long maxComputationTime = 0L;
    private Long errorCounter = 0L;
    private Float averageThreadsPerSec = 0F;
    private Long averageConnTime = 0L;
    private Long averageCompTime = 0L;

    public void add(ResultData data) {
        resultDatas.add(data);
    }

    public List<ResultData> getResultDatas() {
        return resultDatas;
    }

    public Long getErrorCounter() {
        return errorCounter;
    }

    public Long getMaxComputationTime() {
        return maxComputationTime;
    }

    public Long getMaxConnectionTime() {
        return maxConnectionTime;
    }

    public Long getMinComputationTime() {
        return minComputationTime;
    }

    public Long getMinConnectionTime() {
        return minConnectionTime;
    }

    public Long getTotalComputationTime() {
        return totalComputationTime;
    }

    public Long getTotalConnectionTime() {
        return totalConnectionTime;
    }

    public Long getTotalRunningTime() {
        return totalRunningTime;
    }

    public void setTotalRunningTime(Long totalRunningTime) {
        this.totalRunningTime = totalRunningTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAverageCompTime() {
        return averageCompTime;
    }

    public Long getAverageConnTime() {
        return averageConnTime;
    }

    public Float getAverageThreadsPerSec() {
        return averageThreadsPerSec;
    }

    public void errorOccured() {
        errorCounter++;
    }

    public Long getGoodThreadsSize() {
        return resultDatas.size() - errorCounter;
    }

    //=========================================================================
    public void populateData() {
        for (ResultData resultData : resultDatas) {
            if (resultData.getIsError()) {
                errorOccured();
            }
            else {
                setDescription(resultData.getDescription());
                totalComputationTime += resultData.getComputationTime();
                totalConnectionTime += resultData.getConnectionTime();
                calculateMinComputationTime(resultData.getComputationTime());
                calculateMaxComputationTime(resultData.getComputationTime());
                calculateMinConnectionTime(resultData.getConnectionTime());
                calculateMaxConnectionTime(resultData.getConnectionTime());
            }
        }
        averageThreadsPerSec = Float.valueOf(getGoodThreadsSize()) / Float.valueOf(totalRunningTime / 1000);
        averageConnTime = totalConnectionTime / resultDatas.size();
        averageCompTime = totalComputationTime / resultDatas.size();
    }

    public void calculateMinConnectionTime(long timeStamp) {
        if (timeStamp < minConnectionTime || minConnectionTime == 0) {
            minConnectionTime = timeStamp;
        }
    }

    public void calculateMaxConnectionTime(long timeStamp) {
        if (timeStamp > maxConnectionTime || maxConnectionTime == 0) {
            maxConnectionTime = timeStamp;
        }
    }

    public void calculateMinComputationTime(long timeStamp) {
        if (timeStamp < minComputationTime || minComputationTime == 0) {
            minComputationTime = timeStamp;
        }
    }

    public void calculateMaxComputationTime(long timeStamp) {
        if (timeStamp > maxComputationTime || maxComputationTime == 0) {
            maxComputationTime = timeStamp;
        }
    }
}
