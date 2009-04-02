package org.unsw.eva.strategy;

import org.unsw.eva.ServerType;
import org.unsw.eva.threads.EvaluationThread;
import org.unsw.eva.threads.InstanceResponeTests;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shrimpy
 */
public class TimeBaseStrategyTest extends AbstractStrageyTest {

    private static final Logger log = LoggerFactory.getLogger(TimeBaseStrategyTest.class);
    public List<EvaluationThread> testSuit = new ArrayList<EvaluationThread>();
    private static int TOTAL_RUNNING_TIME_IN_SECONDS = 10;
    private static int THREADS_FIRE_AT_THE_SAME_TIME = 5;
    private static int NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD = 10;

    public TimeBaseStrategyTest() {
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
            runThreads(evaThread);
        }

//        TextWriter.writeToFile(getResultList(), new ResultListTextFormatter(), "AppEngineCreateDataByNumber-" + TOTAL_THREADS + ".csv");
    }

    private long currentTimeDifference(long startTime) {
        return (Calendar.getInstance().getTimeInMillis() - startTime) / 1000;
    }

    private void runThreads(EvaluationThread evaThread) {
        List<Thread> threadGroup = new ArrayList<Thread>();
//        ThreadSupplier supplier = new ThreadSupplier(evaThread);
        int numberOfThreadsHaveRun = 0;
        Thread t;

        try {
            long start = Calendar.getInstance().getTimeInMillis();

            while (currentTimeDifference(start) < TOTAL_RUNNING_TIME_IN_SECONDS) {

                for (Thread thread : threadGroup.toArray(new Thread[0])) {
                    if (!thread.isAlive()) {
                        threadGroup.remove(thread);
                    }
                }

                if (threadGroup.size() > THREADS_FIRE_AT_THE_SAME_TIME) {
                    try {
                        Thread.sleep(5);
                        continue;
                    } catch (InterruptedException ex) {
                        log.error("Failed to sleep thread in App.", ex);
                    }
                }

                t = new Thread(evaThread);
                threadGroup.add(t);
                numberOfThreadsHaveRun++;
                t.start();
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
        } catch (Exception e) {
            log.error("Failed to run thread.", e.getMessage());
        } finally {
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
//            log.debug((getResultData().getEndingTime() - getResultData().getStartingTime()) + "," +
//                    numberOfThreadsHaveRun / ((getResultData().getEndingTime() - getResultData().getStartingTime()) / 1000 < 1 ? 1 : (getResultData().getEndingTime() - getResultData().getStartingTime()) / 1000) + "," +
//                    getTotalConnectionTime() / numberOfThreadsHaveRun + "," + getTotalComputationTime() / numberOfThreadsHaveRun + "," +
//                    getMinConnectionTime() + "," + getMaxConnectionTime() + "," + getMinComputationTime() + "," +
//                    getMaxComputationTime() + "," + getErrorCounter());
        }
    }
}
