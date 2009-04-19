
package org.cloudcomputingevaluation;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.1.3
 * Mon Apr 20 00:35:43 EST 2009
 * Generated source version: 2.1.3
 * 
 */

@WebFault(name = "CloudComputatonEvaluationException", targetNamespace = "http://cloudComputingEvaluation.org/")
public class ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage extends Exception {
    public static final long serialVersionUID = 20090420003543L;
    
    private org.cloudcomputingevaluation.CloudComputatonEvaluationException cloudComputatonEvaluationException;

    public ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage() {
        super();
    }
    
    public ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage(String message) {
        super(message);
    }
    
    public ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage(String message, org.cloudcomputingevaluation.CloudComputatonEvaluationException cloudComputatonEvaluationException) {
        super(message);
        this.cloudComputatonEvaluationException = cloudComputatonEvaluationException;
    }

    public ICloudComputingEvaluationReadCloudComputatonEvaluationExceptionFaultMessage(String message, org.cloudcomputingevaluation.CloudComputatonEvaluationException cloudComputatonEvaluationException, Throwable cause) {
        super(message, cause);
        this.cloudComputatonEvaluationException = cloudComputatonEvaluationException;
    }

    public org.cloudcomputingevaluation.CloudComputatonEvaluationException getFaultInfo() {
        return this.cloudComputatonEvaluationException;
    }
}
