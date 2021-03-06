
package org.cloudcomputingevaluation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="ReadByRangeResult" type="{http://cloudComputingEvaluation.org/}Result" minOccurs="0"/>
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
    "readByRangeResult"
})
@XmlRootElement(name = "ReadByRangeResponse")
public class ReadByRangeResponse {

    @XmlElementRef(name = "ReadByRangeResult", namespace = "http://cloudComputingEvaluation.org/", type = JAXBElement.class)
    protected JAXBElement<Result> readByRangeResult;

    /**
     * Gets the value of the readByRangeResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Result }{@code >}
     *     
     */
    public JAXBElement<Result> getReadByRangeResult() {
        return readByRangeResult;
    }

    /**
     * Sets the value of the readByRangeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Result }{@code >}
     *     
     */
    public void setReadByRangeResult(JAXBElement<Result> value) {
        this.readByRangeResult = ((JAXBElement<Result> ) value);
    }

}
