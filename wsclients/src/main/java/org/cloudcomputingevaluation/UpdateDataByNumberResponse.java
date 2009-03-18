
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
 *         &lt;element name="updateDataByNumberResult" type="{http://cloudComputingEvaluation.org/}Result" minOccurs="0"/>
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
    "updateDataByNumberResult"
})
@XmlRootElement(name = "updateDataByNumberResponse")
public class UpdateDataByNumberResponse {

    protected Result updateDataByNumberResult;

    /**
     * Gets the value of the updateDataByNumberResult property.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getUpdateDataByNumberResult() {
        return updateDataByNumberResult;
    }

    /**
     * Sets the value of the updateDataByNumberResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setUpdateDataByNumberResult(Result value) {
        this.updateDataByNumberResult = value;
    }

}
