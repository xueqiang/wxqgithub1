
package de.wxq.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wxq.service.client package. 
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

    private final static QName _SayGreetingResponse_QNAME = new QName("http://service.wxq.com/", "sayGreetingResponse");
    private final static QName _SayGreeting_QNAME = new QName("http://service.wxq.com/", "sayGreeting");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wxq.service.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayGreeting }
     * 
     */
    public SayGreeting createSayGreeting() {
        return new SayGreeting();
    }

    /**
     * Create an instance of {@link SayGreetingResponse }
     * 
     */
    public SayGreetingResponse createSayGreetingResponse() {
        return new SayGreetingResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayGreetingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wxq.com/", name = "sayGreetingResponse")
    public JAXBElement<SayGreetingResponse> createSayGreetingResponse(SayGreetingResponse value) {
        return new JAXBElement<SayGreetingResponse>(_SayGreetingResponse_QNAME, SayGreetingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayGreeting }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.wxq.com/", name = "sayGreeting")
    public JAXBElement<SayGreeting> createSayGreeting(SayGreeting value) {
        return new JAXBElement<SayGreeting>(_SayGreeting_QNAME, SayGreeting.class, null, value);
    }

}
