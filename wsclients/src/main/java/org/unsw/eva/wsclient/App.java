package org.unsw.eva.wsclient;

import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.threads.instanceRespone.AzureInstanceResponeTests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.threads.create.AzureCreateTests;
import org.unsw.eva.threads.instanceRespone.AmazonEC2InstanceResponseTests;
import org.unsw.eva.threads.instanceRespone.AppEngineInstanceResponseTests;

/**
 * @author shrimpy
 */
public class App {

    public List<EvaluationThread> testSuit = new ArrayList<EvaluationThread>();
    private static final Logger log = LoggerFactory.getLogger(App.class);
    private long totalConnectionTime = 0;
    private long totalComputationTime = 0;
    private long minConnectionTime = 0;
    private long maxConnectionTime = 0;
    private long minComputationTime = 0;
    private long maxComputationTime = 0;
    private long errorCounter = 0;
    private static int THREADS = 1;
    private static int SECONDS = 2;

    public static void main(String[] args) {
        new App();
    }

    private long currentTimeDifference(long startTime) {
        return (Calendar.getInstance().getTimeInMillis() - startTime) / 1000;
    }

    public App() {
//        testSuit.add(new AzureInstanceResponeTests("AzureInstancResponse", this, SOAPVersion.SOAP_11));
//        testSuit.add(new AzureInstanceResponeTests("AzureInstancResponse", this, SOAPVersion.SOAP_12));
//        testSuit.add(new AzureCreateTests("AzureCreate", this, SOAPVersion.SOAP_11));
//        testSuit.add(new AzureCreateTests("AzureCreate", this, SOAPVersion.SOAP_12));
//        testSuit.add(new AppEngineInstanceResponseTests("AppEngineInstanceResponse", this, SOAPVersion.SOAP_11));
        testSuit.add(new AmazonEC2InstanceResponseTests("AmazonEC2InstanceResponse", this, SOAPVersion.SOAP_12));

        for (EvaluationThread evaThread : testSuit) {
            log.info(evaThread.getName() + " is running, please wait for " + SECONDS + " seconds.");
            reset();
            runThreads(evaThread);
        }
    }

    private void runThreads(EvaluationThread evaThread) {
        List<Thread> threadGroup = new ArrayList<Thread>();
        Thread t;
        int numberOfThreads = 0;

        try {

            long start = Calendar.getInstance().getTimeInMillis();
            while (currentTimeDifference(start) < SECONDS) {

                for (Thread thread : threadGroup.toArray(new Thread[0])) {
                    if (!thread.isAlive()) {
                        threadGroup.remove(thread);
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
                t = new Thread(evaThread);
                threadGroup.add(t);
                numberOfThreads++;
                t.start();
            }

            /**
             * Waiting for all the thread finished running.
             */
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
        } catch (Exception e) {
        } finally {

            log.debug("====================================================================================================================");
            log.debug("SOAP protocal : " + evaThread.getVersion().getValue());
            log.debug(numberOfThreads + " threads in total, " + THREADS + " fired at the same time. Total running time is : " + SECONDS + " seconds.");
            log.debug("Average threads per second : " + numberOfThreads / SECONDS);
            log.debug("Average connection time : " + totalConnectionTime / numberOfThreads +
                    " | Average computation time : " + totalComputationTime / numberOfThreads);
            log.debug("Min connection time : " + minConnectionTime + " | Max connection time : " + maxConnectionTime);
            log.debug("Min computation time : " + minComputationTime + " | Max computation time : " + maxComputationTime);
            log.debug("Error number is : " + errorCounter);
            log.debug("====================================================================================================================");
        }
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

    private void reset() {
        totalConnectionTime = 0;
        totalComputationTime = 0;
        minConnectionTime = 0;
        maxConnectionTime = 0;
        minComputationTime = 0;
        maxComputationTime = 0;
        errorCounter = 0;
    }
}
