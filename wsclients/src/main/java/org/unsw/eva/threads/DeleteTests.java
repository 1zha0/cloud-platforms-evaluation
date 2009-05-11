package org.unsw.eva.threads;

import org.cloudcomputingevaluation.Result;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.SOAPVersion;
import org.unsw.eva.ServerType;
import org.unsw.eva.exceptions.ConnectionError;
import org.unsw.eva.strategy.AbstractStrageyTest;

/**
 *
 * @author shrimpy
 */
public class DeleteTests<T extends AbstractStrageyTest> extends EvaluationThread {

    public DeleteTests(String name, T app, ServerType serverType, int repeatNumberOfTime) {
        super(name, app, SOAPVersion.SOAP_11, serverType, repeatNumberOfTime);
    }

    public DeleteTests() {
    }

    @Override
    public Result doSOAP11Call() {
        try {
            return getServiceEndpoint().delete(getMESSAGE());
        } catch (Exception ex) {
            if (ex.getMessage().startsWith("Response was of unexpected text/html ContentType.")
                    || ex.getMessage().startsWith("Could not send Message.")) {
                throw new ConnectionError(ex.getMessage());
            } else {
                throw new ServerError(ex.getMessage());
            }
        }
    }

    @Override
    public Result doSOAP12Call() {
        return null;
    }

    @Override
    public Boolean hasError() {
        return getResult().getId() == null;
    }
}
