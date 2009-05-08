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
public class CreateDataByNumberTests<T extends AbstractStrageyTest> extends EvaluationThread {

    private static int TOTAL_NUMBERS = 400;

    public CreateDataByNumberTests() {
    }

    public CreateDataByNumberTests(String name, T app, ServerType serverType, int repeatNumberOfTime) {
        super(name, app, SOAPVersion.SOAP_11, serverType, repeatNumberOfTime);
    }

    @Override
    public Result doSOAP11Call() {
        try {
            return getServiceEndpoint().createDataByNumber(TOTAL_NUMBERS);
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
        return getResult().getValue().getValue() == String.valueOf(TOTAL_NUMBERS);
    }
}
