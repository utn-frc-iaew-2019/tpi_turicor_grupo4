
package org.datacontract.schemas._2004._07.wcfreservavehiculos_business;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ReservaEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReservaEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ApellidoNombreCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodigoReserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Estado" type="{http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel}EstadoReservaEnum" minOccurs="0"/>
 *         &lt;element name="FechaCancelacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FechaHoraDevolucion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FechaHoraRetiro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="FechaReserva" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="LugarDevolucion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LugarRetiro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NroDocumentoCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalReserva" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="UsuarioCancelacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UsuarioReserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VehiculoPorCiudadEntity" type="{http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel}VehiculoPorCiudadEntity" minOccurs="0"/>
 *         &lt;element name="VehiculoPorCiudadId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReservaEntity", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", propOrder = {
    "apellidoNombreCliente",
    "codigoReserva",
    "estado",
    "fechaCancelacion",
    "fechaHoraDevolucion",
    "fechaHoraRetiro",
    "fechaReserva",
    "id",
    "lugarDevolucion",
    "lugarRetiro",
    "nroDocumentoCliente",
    "totalReserva",
    "usuarioCancelacion",
    "usuarioReserva",
    "vehiculoPorCiudadEntity",
    "vehiculoPorCiudadId"
})
public class ReservaEntity {

    @XmlElementRef(name = "ApellidoNombreCliente", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", type = JAXBElement.class, required = false)
    protected JAXBElement<String> apellidoNombreCliente;
    @XmlElementRef(name = "CodigoReserva", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codigoReserva;
    @XmlElement(name = "Estado")
    @XmlSchemaType(name = "string")
    protected EstadoReservaEnum estado;
    @XmlElementRef(name = "FechaCancelacion", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> fechaCancelacion;
    @XmlElement(name = "FechaHoraDevolucion")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraDevolucion;
    @XmlElement(name = "FechaHoraRetiro")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaHoraRetiro;
    @XmlElement(name = "FechaReserva")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaReserva;
    @XmlElement(name = "Id")
    protected Integer id;
    @XmlElementRef(name = "LugarDevolucion", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lugarDevolucion;
    @XmlElementRef(name = "LugarRetiro", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lugarRetiro;
    @XmlElementRef(name = "NroDocumentoCliente", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nroDocumentoCliente;
    @XmlElement(name = "TotalReserva")
    protected BigDecimal totalReserva;
    @XmlElementRef(name = "UsuarioCancelacion", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", type = JAXBElement.class, required = false)
    protected JAXBElement<String> usuarioCancelacion;
    @XmlElementRef(name = "UsuarioReserva", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", type = JAXBElement.class, required = false)
    protected JAXBElement<String> usuarioReserva;
    @XmlElementRef(name = "VehiculoPorCiudadEntity", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", type = JAXBElement.class, required = false)
    protected JAXBElement<VehiculoPorCiudadEntity> vehiculoPorCiudadEntity;
    @XmlElement(name = "VehiculoPorCiudadId")
    protected Integer vehiculoPorCiudadId;

    /**
     * Gets the value of the apellidoNombreCliente property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApellidoNombreCliente() {
        return apellidoNombreCliente;
    }

    /**
     * Sets the value of the apellidoNombreCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApellidoNombreCliente(JAXBElement<String> value) {
        this.apellidoNombreCliente = value;
    }

    /**
     * Gets the value of the codigoReserva property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodigoReserva() {
        return codigoReserva;
    }

    /**
     * Sets the value of the codigoReserva property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodigoReserva(JAXBElement<String> value) {
        this.codigoReserva = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link EstadoReservaEnum }
     *     
     */
    public EstadoReservaEnum getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoReservaEnum }
     *     
     */
    public void setEstado(EstadoReservaEnum value) {
        this.estado = value;
    }

    /**
     * Gets the value of the fechaCancelacion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getFechaCancelacion() {
        return fechaCancelacion;
    }

    /**
     * Sets the value of the fechaCancelacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setFechaCancelacion(JAXBElement<XMLGregorianCalendar> value) {
        this.fechaCancelacion = value;
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
     * Gets the value of the fechaReserva property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaReserva() {
        return fechaReserva;
    }

    /**
     * Sets the value of the fechaReserva property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaReserva(XMLGregorianCalendar value) {
        this.fechaReserva = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the lugarDevolucion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLugarDevolucion() {
        return lugarDevolucion;
    }

    /**
     * Sets the value of the lugarDevolucion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLugarDevolucion(JAXBElement<String> value) {
        this.lugarDevolucion = value;
    }

    /**
     * Gets the value of the lugarRetiro property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLugarRetiro() {
        return lugarRetiro;
    }

    /**
     * Sets the value of the lugarRetiro property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLugarRetiro(JAXBElement<String> value) {
        this.lugarRetiro = value;
    }

    /**
     * Gets the value of the nroDocumentoCliente property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNroDocumentoCliente() {
        return nroDocumentoCliente;
    }

    /**
     * Sets the value of the nroDocumentoCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNroDocumentoCliente(JAXBElement<String> value) {
        this.nroDocumentoCliente = value;
    }

    /**
     * Gets the value of the totalReserva property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalReserva() {
        return totalReserva;
    }

    /**
     * Sets the value of the totalReserva property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalReserva(BigDecimal value) {
        this.totalReserva = value;
    }

    /**
     * Gets the value of the usuarioCancelacion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUsuarioCancelacion() {
        return usuarioCancelacion;
    }

    /**
     * Sets the value of the usuarioCancelacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUsuarioCancelacion(JAXBElement<String> value) {
        this.usuarioCancelacion = value;
    }

    /**
     * Gets the value of the usuarioReserva property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUsuarioReserva() {
        return usuarioReserva;
    }

    /**
     * Sets the value of the usuarioReserva property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUsuarioReserva(JAXBElement<String> value) {
        this.usuarioReserva = value;
    }

    /**
     * Gets the value of the vehiculoPorCiudadEntity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link VehiculoPorCiudadEntity }{@code >}
     *     
     */
    public JAXBElement<VehiculoPorCiudadEntity> getVehiculoPorCiudadEntity() {
        return vehiculoPorCiudadEntity;
    }

    /**
     * Sets the value of the vehiculoPorCiudadEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link VehiculoPorCiudadEntity }{@code >}
     *     
     */
    public void setVehiculoPorCiudadEntity(JAXBElement<VehiculoPorCiudadEntity> value) {
        this.vehiculoPorCiudadEntity = value;
    }

    /**
     * Gets the value of the vehiculoPorCiudadId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVehiculoPorCiudadId() {
        return vehiculoPorCiudadId;
    }

    /**
     * Sets the value of the vehiculoPorCiudadId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVehiculoPorCiudadId(Integer value) {
        this.vehiculoPorCiudadId = value;
    }

}
