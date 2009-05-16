package org.unsw.eva.threads;

import org.cloudcomputingevaluation.Result;
import org.unsw.eva.SOAPVersion;
import org.unsw.eva.ServerType;
import org.unsw.eva.strategy.AbstractStrageyTest;

/**
 *
 * @author shrimpy
 */
public class CreateDataByNumberTests<T extends AbstractStrageyTest> extends EvaluationThread {

    private static int TOTAL_NUMBERS = 400;

    public CreateDataByNumberTests() {
    }

    public CreateDataByNumberTests(String name, T app, ServerType serverType, int repeatNumberOfTime) {
        super(name, app, SOAPVersion.SOAP_11, serverType, repeatNumberOfTime);
    }

    @Override
    public Result doSOAP11Call() throws Exception {
        return getServiceEndpoint().createDataByNumber(TOTAL_NUMBERS);
    }

    @Override
    public Result doSOAP12Call() throws Exception {
        return null;
    }

    @Override
    public Boolean hasError() {
        return getResult().getValue().getValue() == String.valueOf(TOTAL_NUMBERS);
    }
}
