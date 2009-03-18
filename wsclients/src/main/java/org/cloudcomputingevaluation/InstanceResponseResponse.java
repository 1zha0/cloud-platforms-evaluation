
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
 *         &lt;element name="InstanceResponseResult" type="{http://cloudComputingEvaluation.org/}Result" minOccurs="0"/>
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
    "instanceResponseResult"
})
@XmlRootElement(name = "InstanceResponseResponse")
public class InstanceResponseResponse {

    @XmlElement(name = "InstanceResponseResult")
    protected Result instanceResponseResult;

    /**
     * Gets the value of the instanceResponseResult property.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getInstanceResponseResult() {
        return instanceResponseResult;
    }

    /**
     * Sets the value of the instanceResponseResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setInstanceResponseResult(Result value) {
        this.instanceResponseResult = value;
    }

}
