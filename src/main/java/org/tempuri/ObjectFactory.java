
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.wcfreservavehiculos_business.CancelarReservaRequest;
import org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarCiudadesRequest;
import org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarReservasRequest;
import org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarReservasResponse;
import org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarVehiculosRequest;
import org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ReservarVehiculoRequest;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarReservaConsultarReservaRequest_QNAME = new QName("http://tempuri.org/", "ConsultarReservaRequest");
    private final static QName _ConsultarCiudadesResponseConsultarCiudadesResult_QNAME = new QName("http://tempuri.org/", "ConsultarCiudadesResult");
    private final static QName _ConsultarCiudadesConsultarCiudadesRequest_QNAME = new QName("http://tempuri.org/", "ConsultarCiudadesRequest");
    private final static QName _ConsultarVehiculosDisponiblesResponseConsultarVehiculosDisponiblesResult_QNAME = new QName("http://tempuri.org/", "ConsultarVehiculosDisponiblesResult");
    private final static QName _ReservarVehiculoReservarVehiculoRequest_QNAME = new QName("http://tempuri.org/", "ReservarVehiculoRequest");
    private final static QName _CancelarReservaCancelarReservaRequest_QNAME = new QName("http://tempuri.org/", "CancelarReservaRequest");
    private final static QName _ConsultarVehiculosDisponiblesConsultarVehiculosRequest_QNAME = new QName("http://tempuri.org/", "ConsultarVehiculosRequest");
    private final static QName _ConsultarPaisesResponseConsultarPaisesResult_QNAME = new QName("http://tempuri.org/", "ConsultarPaisesResult");
    private final static QName _ConsultarReservaResponseConsultarReservaResult_QNAME = new QName("http://tempuri.org/", "ConsultarReservaResult");
    private final static QName _CancelarReservaResponseCancelarReservaResult_QNAME = new QName("http://tempuri.org/", "CancelarReservaResult");
    private final static QName _ReservarVehiculoResponseReservarVehiculoResult_QNAME = new QName("http://tempuri.org/", "ReservarVehiculoResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link org.tempuri.ConsultarPaisesResponse }
     * 
     */
    public org.tempuri.ConsultarPaisesResponse createConsultarPaisesResponse() {
        return new org.tempuri.ConsultarPaisesResponse();
    }

    /**
     * Create an instance of {@link ConsultarCiudades }
     * 
     */
    public ConsultarCiudades createConsultarCiudades() {
        return new ConsultarCiudades();
    }

    /**
     * Create an instance of {@link CancelarReserva }
     * 
     */
    public CancelarReserva createCancelarReserva() {
        return new CancelarReserva();
    }

    /**
     * Create an instance of {@link ReservarVehiculo }
     * 
     */
    public ReservarVehiculo createReservarVehiculo() {
        return new ReservarVehiculo();
    }

    /**
     * Create an instance of {@link org.tempuri.CancelarReservaResponse }
     * 
     */
    public org.tempuri.CancelarReservaResponse createCancelarReservaResponse() {
        return new org.tempuri.CancelarReservaResponse();
    }

    /**
     * Create an instance of {@link ConsultarReserva }
     * 
     */
    public ConsultarReserva createConsultarReserva() {
        return new ConsultarReserva();
    }

    /**
     * Create an instance of {@link org.tempuri.ConsultarVehiculosDisponiblesResponse }
     * 
     */
    public org.tempuri.ConsultarVehiculosDisponiblesResponse createConsultarVehiculosDisponiblesResponse() {
        return new org.tempuri.ConsultarVehiculosDisponiblesResponse();
    }

    /**
     * Create an instance of {@link ConsultarReservaResponse }
     * 
     */
    public ConsultarReservaResponse createConsultarReservaResponse() {
        return new ConsultarReservaResponse();
    }

    /**
     * Create an instance of {@link org.tempuri.ConsultarCiudadesResponse }
     * 
     */
    public org.tempuri.ConsultarCiudadesResponse createConsultarCiudadesResponse() {
        return new org.tempuri.ConsultarCiudadesResponse();
    }

    /**
     * Create an instance of {@link ConsultarVehiculosDisponibles }
     * 
     */
    public ConsultarVehiculosDisponibles createConsultarVehiculosDisponibles() {
        return new ConsultarVehiculosDisponibles();
    }

    /**
     * Create an instance of {@link org.tempuri.ReservarVehiculoResponse }
     * 
     */
    public org.tempuri.ReservarVehiculoResponse createReservarVehiculoResponse() {
        return new org.tempuri.ReservarVehiculoResponse();
    }

    /**
     * Create an instance of {@link ConsultarPaises }
     * 
     */
    public ConsultarPaises createConsultarPaises() {
        return new ConsultarPaises();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarReservasRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsultarReservaRequest", scope = ConsultarReserva.class)
    public JAXBElement<ConsultarReservasRequest> createConsultarReservaConsultarReservaRequest(ConsultarReservasRequest value) {
        return new JAXBElement<ConsultarReservasRequest>(_ConsultarReservaConsultarReservaRequest_QNAME, ConsultarReservasRequest.class, ConsultarReserva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarCiudadesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsultarCiudadesResult", scope = org.tempuri.ConsultarCiudadesResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarCiudadesResponse> createConsultarCiudadesResponseConsultarCiudadesResult(org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarCiudadesResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarCiudadesResponse>(_ConsultarCiudadesResponseConsultarCiudadesResult_QNAME, org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarCiudadesResponse.class, org.tempuri.ConsultarCiudadesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCiudadesRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsultarCiudadesRequest", scope = ConsultarCiudades.class)
    public JAXBElement<ConsultarCiudadesRequest> createConsultarCiudadesConsultarCiudadesRequest(ConsultarCiudadesRequest value) {
        return new JAXBElement<ConsultarCiudadesRequest>(_ConsultarCiudadesConsultarCiudadesRequest_QNAME, ConsultarCiudadesRequest.class, ConsultarCiudades.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarVehiculosDisponiblesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsultarVehiculosDisponiblesResult", scope = org.tempuri.ConsultarVehiculosDisponiblesResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarVehiculosDisponiblesResponse> createConsultarVehiculosDisponiblesResponseConsultarVehiculosDisponiblesResult(org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarVehiculosDisponiblesResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarVehiculosDisponiblesResponse>(_ConsultarVehiculosDisponiblesResponseConsultarVehiculosDisponiblesResult_QNAME, org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarVehiculosDisponiblesResponse.class, org.tempuri.ConsultarVehiculosDisponiblesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservarVehiculoRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ReservarVehiculoRequest", scope = ReservarVehiculo.class)
    public JAXBElement<ReservarVehiculoRequest> createReservarVehiculoReservarVehiculoRequest(ReservarVehiculoRequest value) {
        return new JAXBElement<ReservarVehiculoRequest>(_ReservarVehiculoReservarVehiculoRequest_QNAME, ReservarVehiculoRequest.class, ReservarVehiculo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelarReservaRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CancelarReservaRequest", scope = CancelarReserva.class)
    public JAXBElement<CancelarReservaRequest> createCancelarReservaCancelarReservaRequest(CancelarReservaRequest value) {
        return new JAXBElement<CancelarReservaRequest>(_CancelarReservaCancelarReservaRequest_QNAME, CancelarReservaRequest.class, CancelarReserva.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarVehiculosRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsultarVehiculosRequest", scope = ConsultarVehiculosDisponibles.class)
    public JAXBElement<ConsultarVehiculosRequest> createConsultarVehiculosDisponiblesConsultarVehiculosRequest(ConsultarVehiculosRequest value) {
        return new JAXBElement<ConsultarVehiculosRequest>(_ConsultarVehiculosDisponiblesConsultarVehiculosRequest_QNAME, ConsultarVehiculosRequest.class, ConsultarVehiculosDisponibles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarPaisesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsultarPaisesResult", scope = org.tempuri.ConsultarPaisesResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarPaisesResponse> createConsultarPaisesResponseConsultarPaisesResult(org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarPaisesResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarPaisesResponse>(_ConsultarPaisesResponseConsultarPaisesResult_QNAME, org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ConsultarPaisesResponse.class, org.tempuri.ConsultarPaisesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarReservasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ConsultarReservaResult", scope = ConsultarReservaResponse.class)
    public JAXBElement<ConsultarReservasResponse> createConsultarReservaResponseConsultarReservaResult(ConsultarReservasResponse value) {
        return new JAXBElement<ConsultarReservasResponse>(_ConsultarReservaResponseConsultarReservaResult_QNAME, ConsultarReservasResponse.class, ConsultarReservaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.wcfreservavehiculos_business.CancelarReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "CancelarReservaResult", scope = org.tempuri.CancelarReservaResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.wcfreservavehiculos_business.CancelarReservaResponse> createCancelarReservaResponseCancelarReservaResult(org.datacontract.schemas._2004._07.wcfreservavehiculos_business.CancelarReservaResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.wcfreservavehiculos_business.CancelarReservaResponse>(_CancelarReservaResponseCancelarReservaResult_QNAME, org.datacontract.schemas._2004._07.wcfreservavehiculos_business.CancelarReservaResponse.class, org.tempuri.CancelarReservaResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ReservarVehiculoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ReservarVehiculoResult", scope = org.tempuri.ReservarVehiculoResponse.class)
    public JAXBElement<org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ReservarVehiculoResponse> createReservarVehiculoResponseReservarVehiculoResult(org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ReservarVehiculoResponse value) {
        return new JAXBElement<org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ReservarVehiculoResponse>(_ReservarVehiculoResponseReservarVehiculoResult_QNAME, org.datacontract.schemas._2004._07.wcfreservavehiculos_business.ReservarVehiculoResponse.class, org.tempuri.ReservarVehiculoResponse.class, value);
    }

}
