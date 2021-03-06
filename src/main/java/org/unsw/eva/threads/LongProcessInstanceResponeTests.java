package org.unsw.eva.threads;

import org.cloudcomputingevaluation.Result;
import org.unsw.eva.SOAPVersion;
import org.unsw.eva.ServerType;
import org.unsw.eva.strategy.AbstractStrageyTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author shrimpy
 */
public class LongProcessInstanceResponeTests<T extends AbstractStrageyTest> extends EvaluationThread {

    private static final Logger log = LoggerFactory.getLogger(LongProcessInstanceResponeTests.class);

    public LongProcessInstanceResponeTests() {
    }

    public LongProcessInstanceResponeTests(String name, T strageyTest, ServerType serverType, int repeatNumberOfTime) {
        super(name, strageyTest, SOAPVersion.SOAP_11, serverType, repeatNumberOfTime);
    }

    @Override
    public Result doSOAP11Call() throws Exception {
        return getServiceEndpoint().longProcessInstanceResponse(50000, "a");
    }

    @Override
    public Result doSOAP12Call() throws Exception {
        return null;
    }

    @Override
    public Boolean hasError() {
        return (getResult().getTimer() != null);
    }
}
