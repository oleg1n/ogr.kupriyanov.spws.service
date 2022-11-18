package ogr.kupriyanov.spws;

import ogr.kupriyanov.spws.service.SoapWebServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class SpwsConfig {
    @Autowired
    private Bus bus;

    @Bean
    public Endpoint myEndpoint (){
        EndpointImpl endpoint = new EndpointImpl(bus, new SoapWebServiceImpl());
        endpoint.publish("/SoapWebService");
        return endpoint;
    }
}
