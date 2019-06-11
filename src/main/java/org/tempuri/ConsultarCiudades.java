
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarCiudadesRequest;


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
 *         &lt;element name="ConsultarCiudadesRequest" type="{http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.Entities}ConsultarCiudadesRequest" minOccurs="0"/>
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
    "consultarCiudadesRequest"
})
@XmlRootElement(name = "ConsultarCiudades")
public class ConsultarCiudades {

    @XmlElementRef(name = "ConsultarCiudadesRequest", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ConsultarCiudadesRequest> consultarCiudadesRequest;

    /**
     * Gets the value of the consultarCiudadesRequest property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConsultarCiudadesRequest }{@code >}
     *     
     */
    public JAXBElement<ConsultarCiudadesRequest> getConsultarCiudadesRequest() {
        return consultarCiudadesRequest;
    }

    /**
     * Sets the value of the consultarCiudadesRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConsultarCiudadesRequest }{@code >}
     *     
     */
    public void setConsultarCiudadesRequest(JAXBElement<ConsultarCiudadesRequest> value) {
        this.consultarCiudadesRequest = value;
    }

}
