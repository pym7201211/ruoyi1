
package com.ruoyi.wsdl.esbService;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kibo.service package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kibo.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PushMessageRequest }
     * 
     */
    public PushMessageRequest createPushMessageRequest() {
        return new PushMessageRequest();
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
     * Create an instance of {@link ITEM }
     * 
     */
    public ITEM createITEM() {
        return new ITEM();
    }

    /**
     * Create an instance of {@link PushMessageResponse }
     * 
     */
    public PushMessageResponse createPushMessageResponse() {
        return new PushMessageResponse();
    }

    /**
     * Create an instance of {@link USER }
     * 
     */
    public USER createUSER() {
        return new USER();
    }

    /**
     * Create an instance of {@link PushMessageRequest.DIRECTTOUSERLIST }
     * 
     */
    public PushMessageRequest.DIRECTTOUSERLIST createPushMessageRequestDIRECTTOUSERLIST() {
        return new PushMessageRequest.DIRECTTOUSERLIST();
    }

    /**
     * Create an instance of {@link PushMessageRequest.ITEMLIST }
     * 
     */
    public PushMessageRequest.ITEMLIST createPushMessageRequestITEMLIST() {
        return new PushMessageRequest.ITEMLIST();
    }

}
