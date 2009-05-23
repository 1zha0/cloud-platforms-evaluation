
package org.cloudcomputingevaluation;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.1.3
 * Sat May 23 19:59:06 EST 2009
 * Generated source version: 2.1.3
 * 
 */

@WebFault(name = "CloudComputatonEvaluationException", targetNamespace = "http://cloudComputingEvaluation.org/")
public class ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage extends Exception {
    public static final long serialVersionUID = 20090523195906L;
    
    private org.cloudcomputingevaluation.CloudComputatonEvaluationException cloudComputatonEvaluationException;

    public ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage() {
        super();
    }
    
    public ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage(String message) {
        super(message);
    }
    
    public ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage(String message, org.cloudcomputingevaluation.CloudComputatonEvaluationException cloudComputatonEvaluationException) {
        super(message);
        this.cloudComputatonEvaluationException = cloudComputatonEvaluationException;
    }

    public ICloudComputingEvaluationDeleteCloudComputatonEvaluationExceptionFaultMessage(String message, org.cloudcomputingevaluation.CloudComputatonEvaluationException cloudComputatonEvaluationException, Throwable cause) {
        super(message, cause);
        this.cloudComputatonEvaluationException = cloudComputatonEvaluationException;
    }

    public org.cloudcomputingevaluation.CloudComputatonEvaluationException getFaultInfo() {
        return this.cloudComputatonEvaluationException;
    }
}
