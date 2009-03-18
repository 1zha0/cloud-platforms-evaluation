package org.unsw.eva.threads;

import org.cloudcomputingevaluation.Result;

import org.unsw.eva.wsclient.App;
import org.unsw.eva.wsclient.SOAPVersion;
import org.unsw.eva.utils.ResourceUtil;

import java.util.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.threads.exceptions.UnsupportError;

/**
 *
 * @author shrimpy
 */
public abstract class EvaluationThread implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(EvaluationThread.class);
    private App app;
    private SOAPVersion version;
    private String MESSAGE = ResourceUtil.getSendString();
    private Result result = null;
    private String name;

    public EvaluationThread(String name, App app, SOAPVersion version) {
        this.name = name;
        this.app = app;
        this.version = version;
    }

    public void run() {
        long start = Calendar.getInstance().getTimeInMillis();

        if (SOAPVersion.SOAP_11.equals(version)) {
            result = doSOAP11Call();
        } else if (SOAPVersion.SOAP_12.equals(version)) {
            result = doSOAP12Call();
        } else {
            throw new UnsupportError("Unsupported SOAP Version : '" + version + "'");
        }
        app.addConnectionTime(Calendar.getInstance().getTimeInMillis() - start);
        app.addComputationTime(result.getTimer());
        if (hasError()) {
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

    public abstract Result doSOAP11Call();

    public abstract Result doSOAP12Call();

    public abstract Boolean hasError();
}
