
package com.ruoyi.common.demoservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kibo.web.demoservice package. 
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

    private final static QName _TASCTLMsgSendRequest_QNAME = new QName("http://www.jscb.com.cn/ecifmsg/ECIFMSGTAS_CTL_MsgSend/", "TAS_CTL_MsgSendRequest");
    private final static QName _TASCTLMsgSendResponse_QNAME = new QName("http://www.jscb.com.cn/ecifmsg/ECIFMSGTAS_CTL_MsgSend/", "TAS_CTL_MsgSendResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kibo.web.demoservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TASCTLMsgSendResponse }
     * 
     */
    public TASCTLMsgSendResponse createTASCTLMsgSendResponse() {
        return new TASCTLMsgSendResponse();
    }

    /**
     * Create an instance of {@link TASCTLMsgSendRequest }
     * 
     */
    public TASCTLMsgSendRequest createTASCTLMsgSendRequest() {
        return new TASCTLMsgSendRequest();
    }

    /**
     * Create an instance of {@link GRPADDRALISTResponse }
     * 
     */
    public GRPADDRALISTResponse createGRPADDRALISTResponse() {
        return new GRPADDRALISTResponse();
    }

    /**
     * Create an instance of {@link GROUPSNDLISTRequest }
     * 
     */
    public GROUPSNDLISTRequest createGROUPSNDLISTRequest() {
        return new GROUPSNDLISTRequest();
    }

    /**
     * Create an instance of {@link GROUPSNDRequest }
     * 
     */
    public GROUPSNDRequest createGROUPSNDRequest() {
        return new GROUPSNDRequest();
    }

    /**
     * Create an instance of {@link GRPADDRAResponse }
     * 
     */
    public GRPADDRAResponse createGRPADDRAResponse() {
        return new GRPADDRAResponse();
    }

    /**
     * Create an instance of {@link ExtHeadList }
     * 
     */
    public ExtHeadList createExtHeadList() {
        return new ExtHeadList();
    }

    /**
     * Create an instance of {@link ResponseBase }
     * 
     */
    public ResponseBase createResponseBase() {
        return new ResponseBase();
    }

    /**
     * Create an instance of {@link RequestBase }
     * 
     */
    public RequestBase createRequestBase() {
        return new RequestBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TASCTLMsgSendRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jscb.com.cn/ecifmsg/ECIFMSGTAS_CTL_MsgSend/", name = "TAS_CTL_MsgSendRequest")
    public JAXBElement<TASCTLMsgSendRequest> createTASCTLMsgSendRequest(TASCTLMsgSendRequest value) {
        return new JAXBElement<TASCTLMsgSendRequest>(_TASCTLMsgSendRequest_QNAME, TASCTLMsgSendRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TASCTLMsgSendResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.jscb.com.cn/ecifmsg/ECIFMSGTAS_CTL_MsgSend/", name = "TAS_CTL_MsgSendResponse")
    public JAXBElement<TASCTLMsgSendResponse> createTASCTLMsgSendResponse(TASCTLMsgSendResponse value) {
        return new JAXBElement<TASCTLMsgSendResponse>(_TASCTLMsgSendResponse_QNAME, TASCTLMsgSendResponse.class, null, value);
    }

}
