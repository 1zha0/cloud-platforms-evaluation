package org.unsw.eva.wsclient;

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
    private static int LOOP = 100;

    public static void main(String[] args) {
        new App();
    }

    public App() {
        Thread[] ts = new Thread[LOOP];

        Thread t;
        for (int i = 0; i < LOOP; i++) {
            t = new Thread(new AzureInstanceResponeThread(i, SOAPVersion.SOAP_11, this));
            ts[i] = t;

            t.start();
        }

        // wait for all the thread finish running.
        for (Thread thread : ts) {
            while (thread.isAlive()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    log.error("Failed to sleep thread in App.", ex);
                }
            }
        }
        log.debug("Average connection time : " + totalConnectionTime / LOOP +
                " | Average computation time : " + totalComputationTime / LOOP);
        log.debug("Min connection time : " + minConnectionTime + " | Max connection time : " + maxConnectionTime);
        log.debug("Min computation time : " + minComputationTime + " | Max computation time : " + maxComputationTime);
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
}
