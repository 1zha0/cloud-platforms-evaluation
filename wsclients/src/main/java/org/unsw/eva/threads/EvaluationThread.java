package org.unsw.eva.threads;

import org.unsw.eva.wsclient.App;
import org.unsw.eva.wsclient.SOAPVersion;
import org.unsw.eva.utils.ResourceUtil;
import org.unsw.eva.exceptions.UnsupportError;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.wsclient.ServerType;
import org.cloudcomputingevaluation.Result;

import java.util.Calendar;
import org.cloudcomputingevaluation.CloudComputingEvaluation;
import org.cloudcomputingevaluation.ICloudComputingEvaluation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public abstract class EvaluationThread implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(EvaluationThread.class);
    private CloudComputingEvaluation service = new CloudComputingEvaluation();
    private App app;
    private SOAPVersion version;
    private String MESSAGE = ResourceUtil.getSendString();
    private Result result = null;
    private String name;
    private ServerType serverType;

    public EvaluationThread(String name, App app, SOAPVersion version, ServerType serverType) {
        this.name = name;
        this.app = app;
        this.version = version;
        this.serverType = serverType;
    }

    public void run() {
        long start = Calendar.getInstance().getTimeInMillis();

        try {
            if (SOAPVersion.SOAP_11.equals(version)) {
                result = doSOAP11Call();
            } else if (SOAPVersion.SOAP_12.equals(version)) {
                result = doSOAP12Call();
            } else {
                throw new UnsupportError("Unsupported SOAP Version : '" + version + "'");
            }
            app.monitorConnectionTime(Calendar.getInstance().getTimeInMillis() - start);
            if (result == null || hasError()) {
                app.errorOccured();
            } else {
//                log.info("result : " + result.getValue().getValue() + " " + result.getTimer());
                app.monitorComputationTime(result.getTimer());
            }
        } catch (ServerError e) {
            app.errorOccured();
            log.error("Server error, connection failed while doing : '" + getName() + "'. ", e.getMessage());
        } catch (Exception e) {
            app.errorOccured();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setResult(Result result) {
        this.result = result;
    }

    public SOAPVersion getVersion() {
        return version;
    }

    public void setVersion(SOAPVersion version) {
        this.version = version;
    }

    public ICloudComputingEvaluation getServiceEndpoint() {
        ICloudComputingEvaluation endpoint = null;
        if (serverType.equals(ServerType.AZURE)) {
            endpoint = service.getAzureEvaluationSoap();
        } else if (serverType.equals(ServerType.AMAZONE)) {
            endpoint = service.getAmazonSoap();
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
