
package org.cloudcomputingevaluation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cleanDefaultDataResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cleanDefaultDataResult"
})
@XmlRootElement(name = "cleanDefaultDataResponse")
public class CleanDefaultDataResponse {

    protected boolean cleanDefaultDataResult;

    /**
     * Gets the value of the cleanDefaultDataResult property.
     * 
     */
    public boolean isCleanDefaultDataResult() {
        return cleanDefaultDataResult;
    }

    /**
     * Sets the value of the cleanDefaultDataResult property.
     * 
     */
    public void setCleanDefaultDataResult(boolean value) {
        this.cleanDefaultDataResult = value;
    }

}
