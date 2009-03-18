
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
 *         &lt;element name="bigFileReceiveResult" type="{http://cloudComputingEvaluation.org/}Result" minOccurs="0"/>
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
    "bigFileReceiveResult"
})
@XmlRootElement(name = "bigFileReceiveResponse")
public class BigFileReceiveResponse {

    protected Result bigFileReceiveResult;

    /**
     * Gets the value of the bigFileReceiveResult property.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getBigFileReceiveResult() {
        return bigFileReceiveResult;
    }

    /**
     * Sets the value of the bigFileReceiveResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setBigFileReceiveResult(Result value) {
        this.bigFileReceiveResult = value;
    }

}
