
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
 *         &lt;element name="setupDefaultDataResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "setupDefaultDataResult"
})
@XmlRootElement(name = "setupDefaultDataResponse")
public class SetupDefaultDataResponse {

    protected int setupDefaultDataResult;

    /**
     * Gets the value of the setupDefaultDataResult property.
     * 
     */
    public int getSetupDefaultDataResult() {
        return setupDefaultDataResult;
    }

    /**
     * Sets the value of the setupDefaultDataResult property.
     * 
     */
    public void setSetupDefaultDataResult(int value) {
        this.setupDefaultDataResult = value;
    }

}
