package com.mercadoLibre.geolocalizacion.utilidad;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.mercadoLibre.geolocalizacion.business.handler.exception.GeneralException;
import com.mercadoLibre.geolocalizacion.model.rs.IpRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.TimeZoneRsDTO;

@Service
public class RestClient {
	
	private final WebClient webClient;

    public RestClient() {
    	this.webClient = WebClient.builder()
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.codecs(configuracion -> configuracion.defaultCodecs().maxInMemorySize(2*1024*1024*1024))
				.build();
    }
    
    /**
     * Method in charge of connecting and obtaining the Ip information.
     * @param parUrl url to consume the service
     * @return object with the information found
     * @author Miguel Hernandez
     */
    public IpRsDTO getInformationIpRest (String parUrl)  {
    	IpRsDTO respuesta = new IpRsDTO();
		try {
			respuesta=this.webClient.get().uri(parUrl).retrieve().bodyToMono((new ParameterizedTypeReference<IpRsDTO>() {
			})).block();
		} catch (Exception e) {			
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		
		return respuesta;
	}
    
    /**
     * Method in charge of connecting and obtaining the time zones
     * @param parUrl url to consume the service
     * @return object with the information found
     * @author Miguel Hernandez
     */
    public TimeZoneRsDTO getTimeZone (String parUrl) {
    	TimeZoneRsDTO respuesta = new TimeZoneRsDTO();
		try {
			respuesta=this.webClient.get().uri(parUrl).retrieve().bodyToMono((new ParameterizedTypeReference<TimeZoneRsDTO>() {
			})).block();
		} catch (Exception e) {			
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		
		return respuesta;
    }
    
    

}
