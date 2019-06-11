
package org.datacontract.schemas._2004._07.wcfreservavehiculos_business;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehiculoPorCiudadEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehiculoPorCiudadEntity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CantidadDisponible" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CiudadEntity" type="{http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel}CiudadEntity" minOccurs="0"/>
 *         &lt;element name="CiudadId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="VehiculoEntity" type="{http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel}VehiculoEntity" minOccurs="0"/>
 *         &lt;element name="VehiculoId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehiculoPorCiudadEntity", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", propOrder = {
    "cantidadDisponible",
    "ciudadEntity",
    "ciudadId",
    "id",
    "vehiculoEntity",
    "vehiculoId"
})
public class VehiculoPorCiudadEntity {

    @XmlElement(name = "CantidadDisponible")
    protected Integer cantidadDisponible;
    @XmlElementRef(name = "CiudadEntity", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", type = JAXBElement.class, required = false)
    protected JAXBElement<CiudadEntity> ciudadEntity;
    @XmlElement(name = "CiudadId")
    protected Integer ciudadId;
    @XmlElement(name = "Id")
    protected Integer id;
    @XmlElementRef(name = "VehiculoEntity", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel", type = JAXBElement.class, required = false)
    protected JAXBElement<VehiculoEntity> vehiculoEntity;
    @XmlElement(name = "VehiculoId")
    protected Integer vehiculoId;

    /**
     * Gets the value of the cantidadDisponible property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Sets the value of the cantidadDisponible property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCantidadDisponible(Integer value) {
        this.cantidadDisponible = value;
    }

    /**
     * Gets the value of the ciudadEntity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CiudadEntity }{@code >}
     *     
     */
    public JAXBElement<CiudadEntity> getCiudadEntity() {
        return ciudadEntity;
    }

    /**
     * Sets the value of the ciudadEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CiudadEntity }{@code >}
     *     
     */
    public void setCiudadEntity(JAXBElement<CiudadEntity> value) {
        this.ciudadEntity = value;
    }

    /**
     * Gets the value of the ciudadId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCiudadId() {
        return ciudadId;
    }

    /**
     * Sets the value of the ciudadId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCiudadId(Integer value) {
        this.ciudadId = value;
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
     * Gets the value of the vehiculoEntity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link VehiculoEntity }{@code >}
     *     
     */
    public JAXBElement<VehiculoEntity> getVehiculoEntity() {
        return vehiculoEntity;
    }

    /**
     * Sets the value of the vehiculoEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link VehiculoEntity }{@code >}
     *     
     */
    public void setVehiculoEntity(JAXBElement<VehiculoEntity> value) {
        this.vehiculoEntity = value;
    }

    /**
     * Gets the value of the vehiculoId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVehiculoId() {
        return vehiculoId;
    }

    /**
     * Sets the value of the vehiculoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVehiculoId(Integer value) {
        this.vehiculoId = value;
    }

}
