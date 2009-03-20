
package org.cloudcomputingevaluation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas.sitka._2008._03.Error;


/**
 * <p>Java class for CloudComputatonEvaluationException complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CloudComputatonEvaluationException">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.microsoft.com/sitka/2008/03/}Error">
 *       &lt;sequence>
 *         &lt;element name="Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CloudComputatonEvaluationException", propOrder = {
    "reason"
})
public class CloudComputatonEvaluationException
    extends Error
{

    @XmlElementRef(name = "Reason", namespace = "http://cloudComputingEvaluation.org/", type = JAXBElement.class)
    protected JAXBElement<String> reason;

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReason(JAXBElement<String> value) {
        this.reason = ((JAXBElement<String> ) value);
    }

}
