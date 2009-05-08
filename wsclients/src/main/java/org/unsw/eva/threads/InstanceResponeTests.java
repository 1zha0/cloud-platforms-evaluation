package org.unsw.eva.threads;

import org.cloudcomputingevaluation.Result;
import org.unsw.eva.exceptions.ServerError;
import org.unsw.eva.SOAPVersion;
import org.unsw.eva.ServerType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.exceptions.ConnectionError;
import org.unsw.eva.strategy.AbstractStrageyTest;

/**
 *
 * @author shrimpy
 */
public class InstanceResponeTests<T extends AbstractStrageyTest> extends EvaluationThread {

    private static final Logger log = LoggerFactory.getLogger(InstanceResponeTests.class);

    public InstanceResponeTests() {
    }

    public InstanceResponeTests(String name, T strageyTest, ServerType serverType, int repeatNumberOfTime) {
        super(name, strageyTest, SOAPVersion.SOAP_11, serverType, repeatNumberOfTime);
    }

    @Override
    public Result doSOAP11Call() {
        try {
            return getServiceEndpoint().instanceResponse(getMESSAGE());
        } catch (Exception ex) {
            if (ex.getMessage().startsWith("Response was of unexpected text/html ContentType.")) {
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
        return getResult().getValue().getValue() == null;
    }
}
