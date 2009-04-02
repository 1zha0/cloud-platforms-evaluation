package org.unsw.eva.strategy;

import org.unsw.eva.ServerType;
import org.unsw.eva.Monitor;
import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.data.dataFormatter.ResultListTextFormatter;
import org.unsw.eva.threads.InstanceResponeTests;
import org.unsw.eva.io.TextWriter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shrimpy
 */
public class ThreadBaseStrategyTest extends Monitor {

    private static final Logger log = LoggerFactory.getLogger(ThreadBaseStrategyTest.class);
    public List<EvaluationThread> testSuit = new ArrayList<EvaluationThread>();
    private static int REPEAT_RUNNING_NUMBER_OF_TIMES = 1;
    private static int TOTAL_THREADS = 2;
    private static int NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD = 10;

    public ThreadBaseStrategyTest() {
        log.info("We are now running " + this.getClass().getSimpleName());
//        testSuit.add(new InstanceResponeTests("AzureInstanceResponse", this, ServerType.AZURE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
        testSuit.add(new InstanceResponeTests("AppEngineInstanceResponse", this, ServerType.APP_ENGINE_INSTANCE_RESPONSE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new InstanceResponeTests("AmazonInstanceResponse", this, ServerType.AMAZONE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateTests("AzureCreate", this, ServerType.AZURE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateTests("AppEngineCreate", this, ServerType.APP_ENGINE_CREATE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateTests("AmazonCreateSimpleDB", this, ServerType.AMAZONE_SIMPLEDB, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateTests("AmazonCreate", this, ServerType.AMAZONE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new ReadTests("AzureRead", this, ServerType.AZURE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new ReadTests("AppEngineRead", this, ServerType.APP_ENGINE_READ, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateDataByNumberTests("AzureCreateDataByNumber", this, ServerType.AZURE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateDataByNumberTests("AppEngineCreateDataByNumber", this, ServerType.APP_ENGINE_CREATE_DATA_BY_NUMBER, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new ReadDataByNumberTests("AzureReadDataByNumber", this, ServerType.AZURE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new ReadDataByNumberTests("AppEngineReadDataByNumber", this, ServerType.APP_ENGINE_READ_DATA_BY_NUMBER, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));

        for (EvaluationThread evaThread : testSuit) {
            log.info(evaThread.getName() + " is running.");
            for (int i = 0; i < REPEAT_RUNNING_NUMBER_OF_TIMES; i++) {
                reset();
                getResultData().setDescription(evaThread.getName() + " " + evaThread.getVersion());
                runThreads(evaThread);
            }
        }
        TextWriter.writeToFile(getResultList(), new ResultListTextFormatter(), TOTAL_THREADS + ".csv");
    }

    private void runThreads(EvaluationThread evaThread) {
        List<Thread> threadGroup = new ArrayList<Thread>();
        long numberOfThreadsHaveRun = 0;

        /**
         * initiate the amount of threads, 
         * so that we can make sure that these amount of time is not included in our testing
         */
        for (int i = 0; i < TOTAL_THREADS; i++) {
            threadGroup.add(new Thread(evaThread));
        }

        try {
            long start = Calendar.getInstance().getTimeInMillis();
            getResultData().setStartingTime(start);

            /**
             * fire all together
             */
            for (Thread thread : threadGroup) {
                thread.start();
                numberOfThreadsHaveRun++;
            }

            /**
             * Waiting for all the thread finished running.
             */
            for (Thread thread : threadGroup) {
                while (thread.isAlive()) {
                    try {
                        Thread.sleep(5);
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
            numberOfThreadsHaveRun = numberOfThreadsHaveRun * NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD;
//            log.debug("====================================================================================================================");
//            log.debug("SOAP protocal : " + evaThread.getVersion().getValue());
//            log.debug(numberOfThreads + " threads in total, " + THREADS_Fire_AT_THE_SAME_TIME + " fired at the same time. Total running time is : " + ((getResultData().getEndingTime() - getResultData().getStartingTime()) / 1000) + " seconds.");
//            log.debug("Average threads per second : " + numberOfThreads / ((getResultData().getEndingTime() - getResultData().getStartingTime()) / 1000));
//            log.debug("Average connection time : " + getTotalConnectionTime() / numberOfThreads +
//                    " | Average computation time : " + getTotalComputationTime() / numberOfThreads);
//            log.debug("Min connection time : " + getMinConnectionTime() + " | Max connection time : " + getMaxConnectionTime());
//            log.debug("Min computation time : " + getMinComputationTime() + " | Max computation time : " + getMaxComputationTime());
//            log.debug("Error number is : " + getErrorCounter());
//            log.debug("====================================================================================================================");
            log.debug((getResultData().getEndingTime() - getResultData().getStartingTime()) + "," +
                    numberOfThreadsHaveRun / ((getResultData().getEndingTime() - getResultData().getStartingTime()) / 1000 < 1 ? 1 : (getResultData().getEndingTime() - getResultData().getStartingTime()) / 1000) + "," +
                    getTotalConnectionTime() / numberOfThreadsHaveRun + "," + getTotalComputationTime() / numberOfThreadsHaveRun + "," +
                    getMinConnectionTime() + "," + getMaxConnectionTime() + "," + getMinComputationTime() + "," +
                    getMaxComputationTime() + "," + getErrorCounter());
        }
    }
}
