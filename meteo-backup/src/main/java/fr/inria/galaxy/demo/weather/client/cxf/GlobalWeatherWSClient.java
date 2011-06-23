package fr.inria.galaxy.demo.weather.client.cxf;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.net.URL;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.namespace.QName;

import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

/**
 * This class was generated by Apache CXF 2.2.1 Tue Nov 03 12:16:13 CET 2009
 * Generated source version: 2.2.1
 * 
 */

public final class GlobalWeatherWSClient {

	private static final QName SERVICE_NAME = new QName("http://www.webserviceX.NET", "GlobalWeather");

	private GlobalWeatherWSClient() {
	}

	public static void main(String args[]) throws Exception {
		//URL wsdlURL = new URL("https://java2.inrialpes.fr/meteo-backup/services/GlobalWeather?wsdl");
		URL wsdlURL = GlobalWeatherWSClient.class.getResource("/meteo.wsdl");
		
		GlobalWeather ss = new GlobalWeather(wsdlURL, SERVICE_NAME);
		GlobalWeatherSoap port = ss.getGlobalWeatherSoap();
		allowSSLConnection(port);

		{
			System.out.println("Invoking getCitiesByCountry...");
			java.lang.String _getCitiesByCountry_countryName = "France";
			java.lang.String _getCitiesByCountry__return = port.getCitiesByCountry(_getCitiesByCountry_countryName);
			System.out.println("getCitiesByCountry.result=" + _getCitiesByCountry__return);

		}
		{
			System.out.println("Invoking getWeather...");
			java.lang.String _getWeather_cityName = "Grenoble";
			java.lang.String _getWeather_countryName = "France";
			java.lang.String _getWeather__return = port.getWeather(_getWeather_cityName, _getWeather_countryName);
			System.out.println("getWeather.result=" + _getWeather__return);

		}

		System.exit(0);
	}

	private static void allowSSLConnection(Object service) {
		Client clientProxy = ClientProxy.getClient(service);

		HTTPConduit conduit = (HTTPConduit) clientProxy.getConduit();
		String targetAddr = conduit.getTarget().getAddress().getValue();
		if (targetAddr.toLowerCase().startsWith("https:")) {
			TrustManager[] simpleTrustManager = new TrustManager[] { new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}

				public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
				}
			} };
			TLSClientParameters tlsParams = new TLSClientParameters();
			tlsParams.setTrustManagers(simpleTrustManager);
			tlsParams.setDisableCNCheck(true);
			conduit.setTlsClientParameters(tlsParams);
		}
	}

}