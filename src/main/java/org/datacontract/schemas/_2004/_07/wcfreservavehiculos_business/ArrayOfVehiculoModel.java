
package org.datacontract.schemas._2004._07.wcfreservavehiculos_business;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfVehiculoModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVehiculoModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VehiculoModel" type="{http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.Entities}VehiculoModel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVehiculoModel", propOrder = {
    "vehiculoModel"
})
public class ArrayOfVehiculoModel {

    @XmlElement(name = "VehiculoModel", nillable = true)
    protected List<VehiculoModel> vehiculoModel;

    /**
     * Gets the value of the vehiculoModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehiculoModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehiculoModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehiculoModel }
     * 
     * 
     */
    public List<VehiculoModel> getVehiculoModel() {
        if (vehiculoModel == null) {
            vehiculoModel = new ArrayList<VehiculoModel>();
        }
        return this.vehiculoModel;
    }

}
