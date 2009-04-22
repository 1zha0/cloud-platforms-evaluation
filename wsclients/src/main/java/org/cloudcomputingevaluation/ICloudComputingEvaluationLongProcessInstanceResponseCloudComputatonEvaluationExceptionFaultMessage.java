
package org.cloudcomputingevaluation;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.1.3
 * Thu Apr 23 01:13:45 EST 2009
 * Generated source version: 2.1.3
 * 
 */

@WebFault(name = "CloudComputatonEvaluationException", targetNamespace = "http://cloudComputingEvaluation.org/")
public class ICloudComputingEvaluationLongProcessInstanceResponseCloudComputatonEvaluationExceptionFaultMessage extends Exception {
    public static final long serialVersionUID = 20090423011345L;
    
    private org.cloudcomputingevaluation.CloudComputatonEvaluationException cloudComputatonEvaluationException;

    public ICloudComputingEvaluationLongProcessInstanceResponseCloudComputatonEvaluationExceptionFaultMessage() {
        super();
    }
    
    public ICloudComputingEvaluationLongProcessInstanceResponseCloudComputatonEvaluationExceptionFaultMessage(String message) {
        super(message);
    }
    
    public ICloudComputingEvaluationLongProcessInstanceResponseCloudComputatonEvaluationExceptionFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public ICloudComputingEvaluationLongProcessInstanceResponseCloudComputatonEvaluationExceptionFaultMessage(String message, org.cloudcomputingevaluation.CloudComputatonEvaluationException cloudComputatonEvaluationException) {
        super(message);
        this.cloudComputatonEvaluationException = cloudComputatonEvaluationException;
    }

    public ICloudComputingEvaluationLongProcessInstanceResponseCloudComputatonEvaluationExceptionFaultMessage(String message, org.cloudcomputingevaluation.CloudComputatonEvaluationException cloudComputatonEvaluationException, Throwable cause) {
        super(message, cause);
        this.cloudComputatonEvaluationException = cloudComputatonEvaluationException;
    }

    public org.cloudcomputingevaluation.CloudComputatonEvaluationException getFaultInfo() {
        return this.cloudComputatonEvaluationException;
    }
}
