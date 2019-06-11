
package org.datacontract.schemas._2004._07.wcfreservavehiculos_business;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LugarRetiroDevolucion.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="LugarRetiroDevolucion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Aeropuerto"/>
 *     &lt;enumeration value="TerminalBuses"/>
 *     &lt;enumeration value="Hotel"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LugarRetiroDevolucion")
@XmlEnum
public enum LugarRetiroDevolucion {

    @XmlEnumValue("Aeropuerto")
    AEROPUERTO("Aeropuerto"),
    @XmlEnumValue("TerminalBuses")
    TERMINAL_BUSES("TerminalBuses"),
    @XmlEnumValue("Hotel")
    HOTEL("Hotel");
    private final String value;

    LugarRetiroDevolucion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LugarRetiroDevolucion fromValue(String v) {
        for (LugarRetiroDevolucion c: LugarRetiroDevolucion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
