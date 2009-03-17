package org.unsw.eva.wsclient;

import java.lang.Thread;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.threads.AzureInstanceResponeThread;

/**
 * @author shrimpy
 */
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);
    private long totalConnectionTime = 0;
    private long totalComputationTime = 0;
    private long minConnectionTime = 0;
    private long maxConnectionTime = 0;
    private long minComputationTime = 0;
    private long maxComputationTime = 0;
    private long errorCounter = 0;
    private static int THREADS = 100;
    private static int SECONDS = 30;

    public static void main(String[] args) {
        new App();
    }

    public App() {
        List<Thread> threadGroup = new ArrayList<Thread>();
        long start = Calendar.getInstance().getTimeInMillis();
        int numberOfThreads = 0;

        Thread t;
        int pos = 0;
        while ((Calendar.getInstance().getTimeInMillis() - start) / 1000 < SECONDS) {
            for (Thread thread : threadGroup.toArray(new Thread[0])) {
                if (!thread.isAlive()) {
                    threadGroup.remove(thread);
                    pos--;
                }
            }
            if (threadGroup.size() >= THREADS) {
                try {
                    Thread.sleep(100);
                    continue;
                } catch (InterruptedException ex) {
                    log.error("Failed to sleep thread in App.", ex);
                }
            }
            t = new Thread(new AzureInstanceResponeThread(pos, SOAPVersion.SOAP_11, this));
            threadGroup.add(t);
            pos++;
            numberOfThreads++;
            t.start();
        }

        for (Thread thread : threadGroup) {
            if (thread.isAlive()) {
                try {
                    Thread.sleep(500);
                    continue;
                } catch (InterruptedException ex) {
                    log.error("Failed to sleep thread in App.", ex);
                }
            }
        }

        log.debug(numberOfThreads + " threads in total, " + THREADS + " fired at the same time. Total running time is : " + SECONDS + " seconds.");
        log.debug("Average connection time : " + totalConnectionTime / numberOfThreads +
                " | Average computation time : " + totalComputationTime / numberOfThreads);
        log.debug("Min connection time : " + minConnectionTime + " | Max connection time : " + maxConnectionTime);
        log.debug("Min computation time : " + minComputationTime + " | Max computation time : " + maxComputationTime);
        log.debug("Error number is : " + errorCounter);
    }

    public synchronized void addConnectionTime(long i) {
        calculateMinConnectionTime(i);
        calculateMaxConnectionTime(i);
        totalConnectionTime += i;
    }

    public synchronized void addComputationTime(long i) {
        calculateMinComputationTime(i);
        calculateMaxComputationTime(i);
        totalComputationTime += i;
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
}
