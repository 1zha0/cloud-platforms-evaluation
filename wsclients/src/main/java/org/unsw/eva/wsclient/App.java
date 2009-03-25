package org.unsw.eva.wsclient;

import org.unsw.eva.data.Pair;
import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.threads.instanceRespone.AzureInstanceResponeTests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.data.ResultData;

/**
 * @author shrimpy
 */
public class App extends Monitor {

    private static final Logger log = LoggerFactory.getLogger(App.class);
    public List<EvaluationThread> testSuit = new ArrayList<EvaluationThread>();
    private static int THREADS = 100;
    private static int SECONDS = 30;

    public static void main(String[] args) {
        new App();
    }

    private long currentTimeDifference(long startTime) {
        return (Calendar.getInstance().getTimeInMillis() - startTime) / 1000;
    }

    public App() {
        testSuit.add(new AzureInstanceResponeTests("AzureInstancResponse", this));
//        testSuit.add(new AppEngineInstanceResponseTests("AppEngineInstanceResponse", this));
//        testSuit.add(new AmazonEC2InstanceResponseTests("AmazonEC2InstanceResponse", this));
//        testSuit.add(new AzureCreateTests("AzureCreate", this));
//        testSuit.add(new AmazonEC2CreateTests("AmazonEC2Create", this));

        for (EvaluationThread evaThread : testSuit) {
            log.info(evaThread.getName() + " is running, please wait for " + SECONDS + " seconds.");
            reset();
            getResultData().setDescription(evaThread.getName() + " " + evaThread.getVersion());
            runThreads(evaThread);
        }

        log.debug("----------------------------------------------------------------------------------------");
        for (ResultData resultData : getResultList()) {
            log.debug(resultData.toString());
        }
    }

    private void runThreads(EvaluationThread evaThread) {
        List<Thread> threadGroup = new ArrayList<Thread>();
        Thread t;
        int numberOfThreads = 0;

        try {
            long start = Calendar.getInstance().getTimeInMillis();
            getResultData().setStartingTime(start);

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
            getResultData().setEndingTime(Calendar.getInstance().getTimeInMillis());
        } catch (Exception e) {
            log.error("Failed to run thread.", e.getMessage());
        } finally {
            getResultList().add(getResultData());
            log.debug("====================================================================================================================");
            log.debug("SOAP protocal : " + evaThread.getVersion().getValue());
            log.debug(numberOfThreads + " threads in total, " + THREADS + " fired at the same time. Total running time is : " + SECONDS + " seconds.");
            log.debug("Average threads per second : " + numberOfThreads / SECONDS);
            log.debug("Average connection time : " + getTotalConnectionTime() / numberOfThreads +
                    " | Average computation time : " + getTotalComputationTime() / numberOfThreads);
            log.debug("Min connection time : " + getMinConnectionTime() + " | Max connection time : " + getMaxConnectionTime());
            log.debug("Min computation time : " + getMinComputationTime() + " | Max computation time : " + getMaxComputationTime());
            log.debug("Error number is : " + getErrorCounter());
            log.debug("====================================================================================================================");
        }
    }
}
