
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarVehiculosRequest;


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
 *         &lt;element name="ConsultarVehiculosRequest" type="{http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.Entities}ConsultarVehiculosRequest" minOccurs="0"/>
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
    "consultarVehiculosRequest"
})
@XmlRootElement(name = "ConsultarVehiculosDisponibles")
public class ConsultarVehiculosDisponibles {

    @XmlElementRef(name = "ConsultarVehiculosRequest", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ConsultarVehiculosRequest> consultarVehiculosRequest;

    /**
     * Gets the value of the consultarVehiculosRequest property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConsultarVehiculosRequest }{@code >}
     *     
     */
    public JAXBElement<ConsultarVehiculosRequest> getConsultarVehiculosRequest() {
        return consultarVehiculosRequest;
    }

    /**
     * Sets the value of the consultarVehiculosRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConsultarVehiculosRequest }{@code >}
     *     
     */
    public void setConsultarVehiculosRequest(JAXBElement<ConsultarVehiculosRequest> value) {
        this.consultarVehiculosRequest = value;
    }

}
