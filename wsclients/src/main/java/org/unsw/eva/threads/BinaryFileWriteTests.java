package org.unsw.eva.threads;

import org.cloudcomputingevaluation.Result;
import org.unsw.eva.SOAPVersion;
import org.unsw.eva.ServerType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.unsw.eva.strategy.AbstractStrageyTest;

/**
 * @author fei
 */
public class BinaryFileWriteTests<T extends AbstractStrageyTest> extends EvaluationThread {

    private static final Logger log = LoggerFactory.getLogger(BinaryFileWriteTests.class);

    @Deprecated
    public BinaryFileWriteTests() {
    }

    public BinaryFileWriteTests(String name, T strageyTest, ServerType serverType, int repeatNumberOfTime) {
        super(name, strageyTest, SOAPVersion.SOAP_11, serverType, repeatNumberOfTime);
    }

    @Override
    public Result doSOAP11Call() throws Exception {
        return getServiceEndpoint().binaryFileWrite(getStrageyTest().getNextGenId());
    }

    @Override
    public Result doSOAP12Call() throws Exception {
        return null;
    }

    @Override
    public Boolean hasError() {
        return getResult().getId() == null;
    }
}
