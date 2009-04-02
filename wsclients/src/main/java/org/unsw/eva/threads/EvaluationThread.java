package org.unsw.eva.threads;

import org.unsw.eva.SOAPVersion;
import org.unsw.eva.utils.ResourceUtil;
import org.unsw.eva.exceptions.UnsupportError;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.ServerType;
import org.unsw.eva.Monitor;
import org.unsw.eva.strategy.AbstractStrageyTest;

import org.cloudcomputingevaluation.Result;
import org.cloudcomputingevaluation.CloudComputingEvaluation;
import org.cloudcomputingevaluation.ICloudComputingEvaluation;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public abstract class EvaluationThread<T extends AbstractStrageyTest> extends Monitor implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(EvaluationThread.class);
    private CloudComputingEvaluation service = new CloudComputingEvaluation();
    private T strageyTest;
    private SOAPVersion version;
    private String MESSAGE = ResourceUtil.getSendString();
    private Result result = null;
    private String name;
    private ServerType serverType;
    private int repeatNumberOfTime;

    public EvaluationThread(String name, T strageyTest, SOAPVersion version, ServerType serverType, int repeatNumberOfTime) {
        this.name = name;
        this.strageyTest = strageyTest;
        this.version = version;
        this.serverType = serverType;
        this.repeatNumberOfTime = repeatNumberOfTime;
    }

    /**
     * What the job suppose to do in one request
     */
    private void runThread() {
        long timer = Calendar.getInstance().getTimeInMillis();

        try {
            if (SOAPVersion.SOAP_11.equals(version)) {
                result = doSOAP11Call();
            } else if (SOAPVersion.SOAP_12.equals(version)) {
                result = doSOAP12Call();
            } else {
                throw new UnsupportError("Unsupported SOAP Version : '" + version + "'");
            }
            monitorConnectionTime(Calendar.getInstance().getTimeInMillis() - timer);
            if (result == null || hasError()) {
                errorOccured();
            } else {
                monitorComputationTime(result.getTimer());
            }
        } catch (ServerError e) {
            errorOccured();
        } catch (Exception e) {
            errorOccured();
        } finally {
            if (result != null) {
                // can do sth here
            }
        }
    }

    /**
     * fire multiple request sequencely
     */
    public void run() {
        for (int i = 0; i < repeatNumberOfTime; i++) {
            super.threadIsGoingToBeStarted(name);
            runThread();
            super.threadFinished();
        }
        /**
         * all the requests have been finished running,
         * thead is going to destoried,
         * output result to public result list.
         */
        strageyTest.getResultList().add(getResultGroupData());
    }

    public String getName() {
        return name;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public Result getResult() {
        return result;
    }

    public SOAPVersion getVersion() {
        return version;
    }

    public ICloudComputingEvaluation getServiceEndpoint() {
        ICloudComputingEvaluation endpoint = null;
        if (serverType.equals(ServerType.AZURE)) {
            endpoint = service.getAzureEvaluationSoap();
        } else if (serverType.equals(ServerType.AMAZONE)) {
            endpoint = service.getAmazonSoap();
        } else if (serverType.equals(ServerType.AMAZONE_SIMPLEDB)) {
            endpoint = service.getAmazonSoapSimpleDB();
        } else if (serverType.equals(ServerType.APP_ENGINE_INSTANCE_RESPONSE)) {
            endpoint = service.getAppEngineSoapInstanceResponse();
        } else if (serverType.equals(ServerType.APP_ENGINE_CREATE)) {
            endpoint = service.getAppEngineSoapCreate();
        } else if (serverType.equals(ServerType.APP_ENGINE_READ)) {
            endpoint = service.getAppEngineSoapRead();
        } else if (serverType.equals(ServerType.APP_ENGINE_CREATE_DATA_BY_NUMBER)) {
            endpoint = service.getAppEngineSoapCreateDataByNumber();
        } else if (serverType.equals(ServerType.APP_ENGINE_READ_DATA_BY_NUMBER)) {
            endpoint = service.getAppEngineSoapReadDataByNumber();
        } else {
            throw new UnsupportError("Unsupport server type : " + serverType);
        }
        return endpoint;
    }

    public abstract Result doSOAP11Call();

    public abstract Result doSOAP12Call();

    public abstract Boolean hasError();
}
