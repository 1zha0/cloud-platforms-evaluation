package org.unsw.eva.strategy;

import java.text.SimpleDateFormat;
import org.unsw.eva.data.dataFormatter.ExportCSVFormatter;
import org.unsw.eva.io.TextWriter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.threads.*;
import org.unsw.eva.utils.ResourceUtil;
import org.unsw.eva.ServerType;

/**
 * @author shrimpy
 */
public class ThreadBaseStrategyTest extends AbstractStrageyTest {

    private static final SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS");
    private static final Logger log = LoggerFactory.getLogger(ThreadBaseStrategyTest.class);
    public List<EvaluationThread> testSuit = new ArrayList<EvaluationThread>();
    /**
     * Assign value to be "1", means won`t repeat.
     */
    private static int REPEAT_RUNNING_NUMBER_OF_TIMES = 1;
    private static int TOTAL_THREADS = 10;
    private static int NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD = 2;
    /**
     * we will get ride of the first three request, and the last
     */
    private static int INTERVAL = 0;

    public ThreadBaseStrategyTest() {
        log.info("We are now running " + this.getClass().getSimpleName());
        /**
         * ==================== Register all the test case here. ====================
         */
//        testSuit.add(new InstanceResponeTests("AzureStorageInstanceResponse", this, ServerType.AZURE_STORAGE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new InstanceResponeTests("AppEngineInstanceResponse", this, ServerType.APP_ENGINE_INSTANCE_RESPONSE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new InstanceResponeTests("AmazonInstanceResponse", this, ServerType.AMAZONE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateTests("AmazonCreateSimpleDB", this, ServerType.AMAZONE_SIMPLEDB, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateTests("AzureStorageCreate", this, ServerType.AZURE_STORAGE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateTests("AppEngineCreate", this, ServerType.APP_ENGINE_CREATE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
        testSuit.add(new CreateTests("AmazonCreate_"+ResourceUtil.getSendString().length(), this, ServerType.AMAZONE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateTests("AzureWithSDSCreate", this, ServerType.AZURE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateTests("AzureSDSCreate", this, ServerType.AZURE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new ReadTests("AzureRead", this, ServerType.AZURE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new ReadTests("AppEngineRead", this, ServerType.APP_ENGINE_READ, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateDataByNumberTests("AzureCreateDataByNumber", this, ServerType.AZURE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new CreateDataByNumberTests("AppEngineCreateDataByNumber", this, ServerType.APP_ENGINE_CREATE_DATA_BY_NUMBER, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new ReadDataByNumberTests("AzureReadDataByNumber", this, ServerType.AZURE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new ReadDataByNumberTests("AppEngineReadDataByNumber", this, ServerType.APP_ENGINE_READ_DATA_BY_NUMBER, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new BinaryFileWriteTests("AppEngineBinaryFileWrite", this, ServerType.APP_ENGINE_BINARY_FILE_WRITE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new BinaryFileWriteTests("AmazonBinaryFileWrite", this, ServerType.AMAZONE_SIMPLEDB, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));
//        testSuit.add(new BinaryFileWriteTests("AzureStorageBinaryFileWrite", this, ServerType.AZURE_STORAGE, NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD));

    }

    public void run() {

        for (EvaluationThread evaThread : testSuit) {
            log.info(evaThread.getName() + " is running.");
            for (int i = 0; i < REPEAT_RUNNING_NUMBER_OF_TIMES; i++) {
                runThreads(evaThread, i);
            }
        }
        TextWriter.writeToFile(getResultList(), new ExportCSVFormatter(), this.getClass().getSimpleName() + "_" + simpleDateFormatter.format(new Date()) + "_" + REPEAT_RUNNING_NUMBER_OF_TIMES + "_" + TOTAL_THREADS + "_" + NUMBER_OF_REQUESTS_SEND_WITHIN_ONE_THREAD + "_" + INTERVAL);
    }

    /**
     * We need to pass a instance into the function, coz
     * we need those params to init new instance
     *
     * it is a hack, maybe should find a better way to deal with it.
     * and this hack end up we have to create a ThreadFactory
     */
    private void runThreads(EvaluationThread evaThread, int round) {
        List<Thread> threadGroup = new ArrayList<Thread>();

        /**
         * initiate the amount of threads,
         * so that we can make sure that these amount of time is not included in our testing
         */
        for (int i = 0; i < (TOTAL_THREADS + round * INTERVAL); i++) {
            threadGroup.add(new Thread(ThreadFactory.coloneThreadInstance(evaThread, round)));
        }

        try {
            /**
             * fire all together
             */
            for (Thread thread : threadGroup) {
                thread.start();
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
        }
    }
}
