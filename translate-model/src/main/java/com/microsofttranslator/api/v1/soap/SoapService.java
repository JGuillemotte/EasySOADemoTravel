
package com.microsofttranslator.api.v1.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.1 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "SoapService", targetNamespace = "http://api.microsofttranslator.com/v1/soap.svc", wsdlLocation = "http://api.microsofttranslator.com/V1/Soap.svc?WSDL")
public class SoapService
    extends Service
{

    private final static URL SOAP_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = new URL("http://api.microsofttranslator.com/V1/Soap.svc?WSDL");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        SOAP_WSDL_LOCATION = url;
    }

    public SoapService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SoapService() {
        super(SOAP_WSDL_LOCATION, new QName("http://api.microsofttranslator.com/v1/soap.svc", "SoapService"));
    }

    /**
     * 
     * @return
     *     returns LanguageService
     */
    @WebEndpoint(name = "BasicHttpBinding_LanguageService")
    public LanguageService getBasicHttpBindingLanguageService() {
        return (LanguageService)super.getPort(new QName("http://api.microsofttranslator.com/v1/soap.svc", "BasicHttpBinding_LanguageService"), LanguageService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LanguageService
     */
    @WebEndpoint(name = "BasicHttpBinding_LanguageService")
    public LanguageService getBasicHttpBindingLanguageService(WebServiceFeature... features) {
        return (LanguageService)super.getPort(new QName("http://api.microsofttranslator.com/v1/soap.svc", "BasicHttpBinding_LanguageService"), LanguageService.class, features);
    }

}
