package org.unsw.eva.strategy;

import org.unsw.eva.data.ResultGroupData;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shrimpy
 */
public abstract class AbstractStrageyTest {

    private List<ResultGroupData> resultList = new ArrayList<ResultGroupData>();

    /**
     * This method will be invoked by the threads,
     * any of the threads, after they finish running,
     * result will be put into this list.
     * 
     * @return
     */
    public synchronized List<ResultGroupData> getResultList() {
        return resultList;
    }
    private int startCounter = 0;

    public synchronized String getNextGenId() {
        startCounter = startCounter + 1;
        return "a" + startCounter;
    }

    public abstract void run();
}
