package org.unsw.eva.wsclient;

import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.data.dataFormatter.ResultListTextFormatter;
import org.unsw.eva.io.TextWriter;
import org.unsw.eva.threads.CreateTests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shrimpy
 */
public class App extends Monitor {

    private static final Logger log = LoggerFactory.getLogger(App.class);
    public List<EvaluationThread> testSuit = new ArrayList<EvaluationThread>();
    private static int THREADS_Fire_AT_THE_SAME_TIME = 30;
    private static int TOTAL_THREADS = 30;

    public static void main(String[] args) {
        new App();
    }

    public App() {
//        testSuit.add(new InstanceResponeTests("AzureInstanceResponse", this, ServerType.AZURE));
//        testSuit.add(new InstanceResponeTests("AppEngineInstanceResponse", this, ServerType.APP_ENGINE_INSTANCE_RESPONSE));
        testSuit.add(new CreateTests("AzureCreate", this, ServerType.AZURE));
//        testSuit.add(new CreateTests("AppEngineCreate", this, ServerType.APP_ENGINE_CREATE));
//        testSuit.add(new ReadTests("AzureRead", this, ServerType.AZURE));
//        testSuit.add(new ReadTests("AppEngineRead", this, ServerType.APP_ENGINE_READ));
//        testSuit.add(new CreateDataByNumberTests("AzureCreateDataByNumber", this, ServerType.AZURE));
//        testSuit.add(new CreateDataByNumberTests("AppEngineCreateDataByNumber", this, ServerType.APP_ENGINE_CREATE_DATA_BY_NUMBER));
//        testSuit.add(new ReadDataByNumberTests("AzureReadDataByNumber", this, ServerType.AZURE));
//        testSuit.add(new ReadDataByNumberTests("AppEngineReadDataByNumber", this, ServerType.APP_ENGINE_READ_DATA_BY_NUMBER));

        for (EvaluationThread evaThread : testSuit) {
            log.info(evaThread.getName() + " is running.");
            reset();
            getResultData().setDescription(evaThread.getName() + " " + evaThread.getVersion());
            runThreads(evaThread);
        }

        TextWriter.writeToFile(getResultList(), new ResultListTextFormatter());
    }

    private void runThreads(EvaluationThread evaThread) {
        List<Thread> threadGroup = new ArrayList<Thread>();
        Thread t;
        int numberOfThreads = 0;

        try {
            long start = Calendar.getInstance().getTimeInMillis();
            getResultData().setStartingTime(start);

            while (numberOfThreads < TOTAL_THREADS) {

                for (Thread thread : threadGroup.toArray(new Thread[0])) {
                    if (!thread.isAlive()) {
                        threadGroup.remove(thread);
                    }
                }
                if (threadGroup.size() >= THREADS_Fire_AT_THE_SAME_TIME) {
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
            log.debug(numberOfThreads + " threads in total, " + THREADS_Fire_AT_THE_SAME_TIME + " fired at the same time. Total running time is : " + ((getResultData().getEndingTime() - getResultData().getStartingTime()) / 1000) + " seconds.");
            log.debug("Average threads per second : " + numberOfThreads / TOTAL_THREADS);
            log.debug("Average connection time : " + getTotalConnectionTime() / numberOfThreads +
                    " | Average computation time : " + getTotalComputationTime() / numberOfThreads);
            log.debug("Min connection time : " + getMinConnectionTime() + " | Max connection time : " + getMaxConnectionTime());
            log.debug("Min computation time : " + getMinComputationTime() + " | Max computation time : " + getMaxComputationTime());
            log.debug("Error number is : " + getErrorCounter());
            log.debug("====================================================================================================================");
        }
    }
}
