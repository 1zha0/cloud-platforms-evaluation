package org.unsw.eva.threads;

import org.cloudcomputingevaluation.Result;
import org.unsw.eva.SOAPVersion;
import org.unsw.eva.ServerType;
import org.unsw.eva.strategy.AbstractStrageyTest;
import org.unsw.eva.utils.ResourceUtil;

/**
 *
 * @author shrimpy
 */
public class ReadTests<T extends AbstractStrageyTest> extends EvaluationThread {

    public ReadTests() {
    }

    public ReadTests(String name, T app, ServerType serverType, int repeatNumberOfTime) {
        super(name, app, SOAPVersion.SOAP_11, serverType, repeatNumberOfTime);
    }

    @Override
    public Result doSOAP11Call() throws Exception {
        return getServiceEndpoint().read(ResourceUtil.getSendString());
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
