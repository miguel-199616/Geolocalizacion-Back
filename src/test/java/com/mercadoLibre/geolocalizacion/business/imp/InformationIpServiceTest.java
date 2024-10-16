package com.mercadoLibre.geolocalizacion.business.imp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mercadoLibre.geolocalizacion.entityManager.LocationEntityManager;
import com.mercadoLibre.geolocalizacion.model.Location;
import com.mercadoLibre.geolocalizacion.model.rs.IpRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.LanguagesRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.LocationRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.TimeZoneRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.ZonesDTO;
import com.mercadoLibre.geolocalizacion.repository.LocationRepository;
import com.mercadoLibre.geolocalizacion.utilidad.Constants;
import com.mercadoLibre.geolocalizacion.utilidad.RestClient;

public class InformationIpServiceTest {
	
	@InjectMocks
	private InformationIpService informationIpService;
	
	@Mock
	private RestClient restClient;
	
	@Mock
	private LocationRepository locationRepository;
	
	@Mock
	private LocationEntityManager locationEntityManager;
	
	public static final IpRsDTO response = new IpRsDTO();
	public static final TimeZoneRsDTO responseTimeZone = new TimeZoneRsDTO();
	public static final ZonesDTO responseZonesOne = new ZonesDTO();
	public static final List<ZonesDTO> responseListZones = new ArrayList<>();
	public static final Location responseLocation = new Location();
	public static final Location responseLocationLargestDistance = new Location();
	public static final LocationRsDTO locationResponse = new LocationRsDTO();
	public static final LanguagesRsDTO languagesResponse = new LanguagesRsDTO();
	public static final List<LanguagesRsDTO> listLanguagesResponse = new ArrayList<>();
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	
	public InformationIpServiceTest () {
		
	}
	
	@Test
	@DisplayName("Get information ip")
	public void getInformationIp() {
		response.setIp("100.0.91.000");
		response.setType("ipv4");
		response.setContinentCode("SA");
		response.setContinentName("South America");
		response.setCountryCode("CO");
		response.setCountryName("Colombia");
		response.setRegionCode("DC");
		response.setRegionName("Bogota D.C.");
		response.setCity("Bogotá");
		response.setZip("110431");
		response.setLatitude(4.534299850463867);
		response.setLongitude(-74.06729888916016);
		locationResponse.setGeonameId(new BigDecimal(3688689));
		locationResponse.setCapital("Bogotá");
		languagesResponse.setCode("es");
		languagesResponse.setName("Spanish");
		languagesResponse.setNativeResult("Español");
		listLanguagesResponse.add(languagesResponse);
		locationResponse.setLanguages(listLanguagesResponse);
		response.setLocation(locationResponse);
        when(restClient.getInformationIpRest(anyString())).thenReturn(response);
        responseTimeZone.setMessage("OK");
        responseTimeZone.setStatus(Constants.EMPTY_STRING);
        responseZonesOne.setCountryName("Ivory Coast");
        responseZonesOne.setCountryCode("CO");
        responseZonesOne.setTimestamp(1729115041);
        responseZonesOne.setGmtOffset(0);
        responseListZones.add(responseZonesOne);
        responseTimeZone.setZones(responseListZones);
        when(restClient.getTimeZone(anyString())).thenReturn(responseTimeZone);
        
        assertEquals(informationIpService.getInformationIp(anyString()).getSuccessful(), Boolean.TRUE);
      
        
	}
	@Test
	@DisplayName("Get average distance without register in data base")
	public void getAverageDistanceWithoutRegisterInDatabase() {		
		responseLocation.setCountryName(null);
		responseLocation.setDistance(0.0);
		responseLocation.setId(null);
        when(locationEntityManager.findShortestDistance()).thenReturn(responseLocation);
        assertEquals(informationIpService.averageDistance().getSuccessful(), Boolean.FALSE);        	
	}
	
	@Test
	@DisplayName("Get average distance with register in data base")
	public void getAverageDistanceWithRegisterInDatabase() {
		responseLocation.setCountryName("Colombia");
		responseLocation.setDistance(450.87);
		responseLocation.setId("12345");
        when(locationEntityManager.findShortestDistance()).thenReturn(responseLocation);
        
        responseLocationLargestDistance.setCountryName("España");
        responseLocationLargestDistance.setDistance(8757.02);
        responseLocationLargestDistance.setId("8710578");
        when(locationEntityManager.findLargestDistance()).thenReturn(responseLocationLargestDistance);
        
        List<Location> responseFindByNameShortest = new ArrayList<>();
        responseFindByNameShortest.add(responseLocation);
        when(locationRepository.findLocationsByCountryName(responseLocation.getCountryName())).thenReturn(responseFindByNameShortest);

        List<Location> responseFindByNameLargest = new ArrayList<>();
        responseFindByNameLargest.add(responseLocationLargestDistance);
        when(locationRepository.findLocationsByCountryName(responseLocation.getCountryName())).thenReturn(responseFindByNameLargest);
        assertEquals(informationIpService.averageDistance().getSuccessful(), Boolean.TRUE);        

	}
	
	


}
