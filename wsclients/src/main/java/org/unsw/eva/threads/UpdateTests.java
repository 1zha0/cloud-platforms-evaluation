package org.unsw.eva.threads;

import org.cloudcomputingevaluation.Result;
import org.unsw.eva.SOAPVersion;
import org.unsw.eva.ServerType;
import org.unsw.eva.strategy.AbstractStrageyTest;

/**
 *
 * @author shrimpy
 */
public class UpdateTests<T extends AbstractStrageyTest> extends EvaluationThread {

    public UpdateTests() {
    }

    public UpdateTests(String name, T app, ServerType serverType, int repeatNumberOfTime) {
        super(name, app, SOAPVersion.SOAP_11, serverType, repeatNumberOfTime);
    }

    @Override
    public Result doSOAP11Call() throws Exception {
        return getServiceEndpoint().update(getMESSAGE(), getMESSAGE());
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
