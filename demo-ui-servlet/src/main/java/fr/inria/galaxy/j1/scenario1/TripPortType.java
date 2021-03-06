package fr.inria.galaxy.j1.scenario1;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.1
 * Tue May 26 17:11:22 CEST 2009
 * Generated source version: 2.2.1
 * 
 */
 
@WebService(targetNamespace = "http://scenario1.j1.galaxy.inria.fr/", name = "TripPortType")
@XmlSeeAlso({ObjectFactory.class})
public interface TripPortType {

    @WebResult(name = "return", targetNamespace = "http://scenario1.j1.galaxy.inria.fr/")
    @RequestWrapper(localName = "process", targetNamespace = "http://scenario1.j1.galaxy.inria.fr/", className = "fr.inria.galaxy.j1.scenario1.Process")
    @ResponseWrapper(localName = "processResponse", targetNamespace = "http://scenario1.j1.galaxy.inria.fr/", className = "fr.inria.galaxy.j1.scenario1.ProcessResponse")
    @WebMethod
    public java.lang.String process(
        @WebParam(name = "arg0", targetNamespace = "http://scenario1.j1.galaxy.inria.fr/")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "http://scenario1.j1.galaxy.inria.fr/")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "http://scenario1.j1.galaxy.inria.fr/")
        double arg2
    );
}
