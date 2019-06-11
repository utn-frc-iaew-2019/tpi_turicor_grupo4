
package org.datacontract.schemas._2004._07.wcfreservavehiculos_business;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EstadoReservaEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EstadoReservaEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Activa"/>
 *     &lt;enumeration value="Cancelada"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EstadoReservaEnum", namespace = "http://schemas.datacontract.org/2004/07/WCFReservaVehiculos.Business.DataBaseModel")
@XmlEnum
public enum EstadoReservaEnum {

    @XmlEnumValue("Activa")
    ACTIVA("Activa"),
    @XmlEnumValue("Cancelada")
    CANCELADA("Cancelada");
    private final String value;

    EstadoReservaEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoReservaEnum fromValue(String v) {
        for (EstadoReservaEnum c: EstadoReservaEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
