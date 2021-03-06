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

import javax.xml.ws.soap.SOAPFaultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.ErrorCode;
import org.unsw.eva.exceptions.ConnectionError;

/**
 *
 * @author shrimpy
 */
public abstract class EvaluationThread<T extends AbstractStrageyTest> extends Monitor implements Runnable, Cloneable {

    private static final Logger log = LoggerFactory.getLogger(EvaluationThread.class);
    private CloudComputingEvaluation service = new CloudComputingEvaluation();
    private T strageyTest;
    private SOAPVersion version;
    private String MESSAGE = ResourceUtil.getSendString();
    private Result result = null;
    private String name;
    private ServerType serverType;
    private int repeatNumberOfTime;
    private int currentThreadIndex;

    public EvaluationThread() {
    }

    public EvaluationThread(String name, T strageyTest, SOAPVersion version, ServerType serverType, int repeatNumberOfTime) {
        this.name = name;
        this.strageyTest = strageyTest;
        this.version = version;
        this.serverType = serverType;
        this.repeatNumberOfTime = repeatNumberOfTime;
    }

    /**
     * What the job suppose to be done in one request
     */
    private void runThread() {
        long start = Calendar.getInstance().getTimeInMillis();

        try {
            if (SOAPVersion.SOAP_11.equals(version)) {
                result = doSOAP11Call();
            } else if (SOAPVersion.SOAP_12.equals(version)) {
                result = doSOAP12Call();
            } else {
                throw new UnsupportError("Unsupported SOAP Version : '" + version + "'");
            }
            if (result == null || hasError()) {
                errorOccured(ErrorCode.SERVER_ERROR);
            } else {
                monitorResult(result);
            }
        } catch (SOAPFaultException sfe) {
            log.error("------------------------------------------------------------");
            if (sfe.getFault().getDetail() != null) {
                errorOccured(ErrorCode.SERVER_ERROR);
                log.error(ErrorCode.SERVER_ERROR.getCode());
                log.error("Fault Code   : " + sfe.getFault().getFaultCode());
                log.error("Falut String : " + sfe.getFault().getFaultString());
                log.error("Falut Detail : " + sfe.getFault().getDetail().getTextContent());
            } else {
                errorOccured(ErrorCode.CONNECTION_ERROR);
                log.error(sfe.getMessage(), sfe);
            }
            log.error("============================================================");
        } catch (Exception ex) {
            log.error("------------------------------------------------------------");
            /**
             * Special case handle exception for Amazon
             */
            if (ex.getMessage().startsWith("Cloud Eva Amazon")) {
                errorOccured(ErrorCode.SERVER_ERROR);
                log.error(ErrorCode.SERVER_ERROR.getCode());
                log.error(ex.getMessage());
            } else {
                errorOccured(ErrorCode.UNKNOWN_ERROR);
                log.error("Unknown error for " + getName(), ex);
            }
            log.error("============================================================");
        } finally {
            monitorConnectionTime(Calendar.getInstance().getTimeInMillis(), start);
            if (result != null) {
                // can do sth here
            }
        }
    }

    /**
     * fire multiple request sequencely
     */
    public void run() {
        Long timmer = Calendar.getInstance().getTimeInMillis();
        for (int i = 0; i < repeatNumberOfTime; i++) {
            currentThreadIndex = i;
            super.threadIsGoingToBeStarted(name);
            runThread();
            super.threadFinished();
        }
        getResultGroupData().setTotalRunningTime(Calendar.getInstance().getTimeInMillis() - timmer);
        /**
         * all the requests have been finished running,
         * thead is going to destoried,
         * output result to public result list.
         */
        strageyTest.getResultList().add(getResultGroupData());
    }

    public ICloudComputingEvaluation getServiceEndpoint() {
        ICloudComputingEvaluation endpoint = null;
        if (serverType.equals(ServerType.AZURE)) {
            endpoint = service.getAzureEvaluationSoap();
        } else if (serverType.equals(ServerType.AZURE_STORAGE)) {
            endpoint = service.getAzureStorageEvaluationSoap();
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
        } else if (serverType.equals(ServerType.APP_ENGINE_BINARY_FILE_READ)) {
            endpoint = service.getAppEngineSoapBinaryFileRead();
        } else if (serverType.equals(ServerType.APP_ENGINE_BINARY_FILE_WRITE)) {
            endpoint = service.getAppEngineSoapBinaryFileWrite();
        } else {
            throw new UnsupportError("Unsupport server type : " + serverType);
        }
        return endpoint;
    }

    public int getCurrentThreadIndex() {
        return currentThreadIndex;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRepeatNumberOfTime() {
        return repeatNumberOfTime;
    }

    public void setRepeatNumberOfTime(int repeatNumberOfTime) {
        this.repeatNumberOfTime = repeatNumberOfTime;
    }

    public Result getResult() {
        return result;
    }

    public ServerType getServerType() {
        return serverType;
    }

    public void setServerType(ServerType serverType) {
        this.serverType = serverType;
    }

    public T getStrageyTest() {
        return strageyTest;
    }

    public void setStrageyTest(T strageyTest) {
        this.strageyTest = strageyTest;
    }

    public SOAPVersion getVersion() {
        return version;
    }

    public void setVersion(SOAPVersion version) {
        this.version = version;
    }

    public abstract Result doSOAP11Call() throws Exception;

    public abstract Result doSOAP12Call() throws Exception;

    public abstract Boolean hasError();
}
