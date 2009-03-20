
package org.cloudcomputingevaluation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="SetupDefaultDataResult" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlRootElement(name = "SetupDefaultDataResponse")
public class SetupDefaultDataResponse {

    @XmlElement(name = "SetupDefaultDataResult")
    protected Integer setupDefaultDataResult;

    /**
     * Gets the value of the setupDefaultDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSetupDefaultDataResult() {
        return setupDefaultDataResult;
    }

    /**
     * Sets the value of the setupDefaultDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSetupDefaultDataResult(Integer value) {
        this.setupDefaultDataResult = value;
    }

}
