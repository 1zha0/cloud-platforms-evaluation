
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
 *         &lt;element name="deleteDataByNumberResult" type="{http://cloudComputingEvaluation.org/}Result" minOccurs="0"/>
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
    "deleteDataByNumberResult"
})
@XmlRootElement(name = "deleteDataByNumberResponse")
public class DeleteDataByNumberResponse {

    protected Result deleteDataByNumberResult;

    /**
     * Gets the value of the deleteDataByNumberResult property.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getDeleteDataByNumberResult() {
        return deleteDataByNumberResult;
    }

    /**
     * Sets the value of the deleteDataByNumberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setDeleteDataByNumberResult(Result value) {
        this.deleteDataByNumberResult = value;
    }

}
