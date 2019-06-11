
package org.datacontract.schemas._2004._07.wcfreservavehiculos_business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ConsultarVehiculosRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConsultarVehiculosRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdCiudad" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="FechaHoraRetiro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FechaHoraDevolucion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarVehiculosRequest", propOrder = {
    "idCiudad",
    "fechaHoraRetiro",
    "fechaHoraDevolucion"
})
public class ConsultarVehiculosRequest {

    @XmlElement(name = "IdCiudad")
    protected Integer idCiudad;
    @XmlElement(name = "FechaHoraRetiro")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraRetiro;
    @XmlElement(name = "FechaHoraDevolucion")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraDevolucion;

    /**
     * Gets the value of the idCiudad property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdCiudad() {
        return idCiudad;
    }

    /**
     * Sets the value of the idCiudad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdCiudad(Integer value) {
        this.idCiudad = value;
    }

    /**
     * Gets the value of the fechaHoraRetiro property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraRetiro() {
        return fechaHoraRetiro;
    }

    /**
     * Sets the value of the fechaHoraRetiro property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraRetiro(XMLGregorianCalendar value) {
        this.fechaHoraRetiro = value;
    }

    /**
     * Gets the value of the fechaHoraDevolucion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaHoraDevolucion() {
        return fechaHoraDevolucion;
    }

    /**
     * Sets the value of the fechaHoraDevolucion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaHoraDevolucion(XMLGregorianCalendar value) {
        this.fechaHoraDevolucion = value;
    }

}
