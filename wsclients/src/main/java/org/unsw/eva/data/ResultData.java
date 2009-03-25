package org.unsw.eva.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shrimpy
 */
public class ResultData implements Serializable {

    private Long startingTime;
    private Long endingTime;
    private List<Pair<Long, Long>> connectionTimers = new ArrayList<Pair<Long, Long>>();
    private List<Pair<Long, Long>> computationTimers = new ArrayList<Pair<Long, Long>>();
    private String description;

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

    public List<Pair<Long, Long>> getComputationTimers() {
        return computationTimers;
    }

    /**
     *
     * @param timers
     *      First "Long" in timer is what time stampe the event happened.
     *      Second "Long" the process it takes
     */
    public void setComputationTimers(List<Pair<Long, Long>> timers) {
        this.computationTimers = timers;
    }

    public List<Pair<Long, Long>> getConnectionTimers() {
        return connectionTimers;
    }

    /**
     *
     * @param timers
     *      First "Long" in timer is what time stampe it happened.
     *      Second "Long" the process it takes
     */
    public void setConnectionTimers(List<Pair<Long, Long>> timers) {
        this.connectionTimers = timers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(description);
        sb.append("\n Connection times : ");
        for (Pair<Long, Long> pair : connectionTimers) {
            sb.append("(");
            sb.append(pair.getA());
            sb.append(",");
            sb.append(pair.getB());
            sb.append(")");
        }
        sb.append("\n Computation times : ");
        for (Pair<Long, Long> pair : computationTimers) {
            sb.append("(");
            sb.append(pair.getA());
            sb.append(",");
            sb.append(pair.getB());
            sb.append(")");
        }
        sb.append("\n");
        return sb.toString();
    }
}
