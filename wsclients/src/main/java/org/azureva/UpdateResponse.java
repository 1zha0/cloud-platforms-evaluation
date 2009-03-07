
package org.azureva;

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
 *         &lt;element name="updateResult" type="{http://azureva.org/}Result" minOccurs="0"/>
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
    "updateResult"
})
@XmlRootElement(name = "updateResponse")
public class UpdateResponse {

    protected Result updateResult;

    /**
     * Gets the value of the updateResult property.
     * 
     * @return
     *     possible object is
     *     {@link Result }
     *     
     */
    public Result getUpdateResult() {
        return updateResult;
    }

    /**
     * Sets the value of the updateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Result }
     *     
     */
    public void setUpdateResult(Result value) {
        this.updateResult = value;
    }

}
