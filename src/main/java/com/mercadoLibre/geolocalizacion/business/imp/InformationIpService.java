package com.mercadoLibre.geolocalizacion.business.imp;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadoLibre.geolocalizacion.business.IInformationIPService;
import com.mercadoLibre.geolocalizacion.business.handler.exception.GeneralException;
import com.mercadoLibre.geolocalizacion.entityManager.LocationEntityManager;
import com.mercadoLibre.geolocalizacion.model.Location;
import com.mercadoLibre.geolocalizacion.model.rs.AverageDistanceRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.GenericDataRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.InformationIpRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.IpRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.LanguageInformationIpRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.LanguagesRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.TimeZoneRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.ZoneInformationIpRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.ZonesDTO;
import com.mercadoLibre.geolocalizacion.repository.LocationRepository;
import com.mercadoLibre.geolocalizacion.utilidad.Constants;
import com.mercadoLibre.geolocalizacion.utilidad.RestClient;

@Service
public class InformationIpService implements IInformationIPService {
	
	@Autowired
	private RestClient restClient;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private LocationEntityManager locationEntityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GenericDataRsDTO<InformationIpRsDTO> getInformationIp(String parIp) {
		
		GenericDataRsDTO<InformationIpRsDTO> result = new GenericDataRsDTO<>();
		try {
			InformationIpRsDTO information = new InformationIpRsDTO();
			IpRsDTO ipResult = this.restClient.getInformationIpRest(this.createUrlGetInformationIp(parIp));						
			information.setIp(ipResult.getIp());
			information.setCurrentlyDate(this.formatDate(new Date()));
			information.setCountry(ipResult.getCountryName());
			information.setIsoCode(ipResult.getLocation().getCountryFlagEmoji());
			information.setLanguages(this.getLanguagesCountry(ipResult.getLocation().getLanguages()));
			information.setCurrency(this.getCurrencyCode(ipResult.getCountryCode()));
			information.setTimeZones(this.getTimeZones(ipResult.getCountryCode()));
			double estimatedDistance = this.calculateDistanceToBuenosAires(ipResult.getLatitude(), ipResult.getLongitude(), Constants.LATITUDE_BUENOS_AIRES,
																			Constants.LONGITUDE_BUENOS_AIRES,Constants.EARTH_RADIUS);
			 
			information.setEstimatedDistance((this.createResponseDistanceEstimated(estimatedDistance,ipResult.getLatitude(), ipResult.getLongitude(), 
												Constants.LATITUDE_BUENOS_AIRES,Constants.LONGITUDE_BUENOS_AIRES)));
			this.insertLocation(ipResult.getCountryName(), estimatedDistance);
			result.setData(information);
			result.setResponse(Boolean.TRUE, null, null);
			
		} catch (GeneralException e) {
			throw new GeneralException(e.getErrorType(), e.getMessage());
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
			
		}
		return result;
	}
	
	/**
	 * Method in charge of building the url to obtain the information of the Ip
	 * @param parIp url to consume the service
	 * @return generated url
	 * @author Miguel Hernandez
	 */
	private String createUrlGetInformationIp (String parIp) {
		String result = Constants.EMPTY_STRING;
		try {
			StringBuilder urlString = new StringBuilder();
			urlString.append(Constants.INFORMATION_URL_STRING);
			urlString.append(parIp);
			urlString.append(Constants.INTERROGATION_ICON);
			urlString.append(Constants.ACCESS_KEY);
			urlString.append(Constants.EQUAL_ICON);
			urlString.append(Constants.KEY_INFORMATION_IP);
			result = urlString.toString();			
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		return result;
	}
	
	/**
	 * Method for obtaining the currency code with respect to the country code
	 * @param parCountryCode country code of the country to be queried for the currency
	 * @return currency code found
	 * @author Miguel Hernandez
	 */
	private String getCurrencyCode(String parCountryCode) {
		return Currency.getInstance(new Locale(Constants.EMPTY_STRING, parCountryCode)).getCurrencyCode(); 
	}
	
	/**
	 * Method to obtain the time zones of a country based on the country's time code
	 * @param parCountryCode country code of the country to be queried for the times zones
	 * @return list of time zones found
	 * @author Miguel Hernandez
	 */
	private List<ZoneInformationIpRsDTO> getTimeZones(String parCountryCode){
		List<ZoneInformationIpRsDTO> result = new ArrayList<>();
		
		try {
			
			TimeZoneRsDTO timesZones = this.restClient.getTimeZone(this.createUrlGetTimesZones());
			if(timesZones.getZones() != null && !timesZones.getZones().isEmpty()) {
				for(ZonesDTO zone : timesZones.getZones()) {
					if(zone.getCountryCode().equals(parCountryCode)) {
						ZoneInformationIpRsDTO zoneInformation = new ZoneInformationIpRsDTO();
						zoneInformation.setZoneName(zone.getZoneName());
						long time = (zone.getTimestamp()-zone.getGmtOffset())*1000;						
						zoneInformation.setCurrentlyDate(this.formatHour(time));
						result.add(zoneInformation);
					}
				}
			}
			
		} catch(GeneralException e) {
			throw new GeneralException(e.getMessage(), e.getMessage());
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		
		
		return result;
	}
	
	/**
	 * Method in charge of building the url to obtain the times zones
	 * @return generated url
	 * @author Miguel Hernandez
	 */
	private String createUrlGetTimesZones () {
		String result = Constants.EMPTY_STRING;
		try {
			StringBuilder urlString = new StringBuilder();
			urlString.append(Constants.TIMES_ZONES_URL_STRING);			
			urlString.append(Constants.INTERROGATION_ICON);
			urlString.append(Constants.KEY);
			urlString.append(Constants.EQUAL_ICON);
			urlString.append(Constants.KEY_TIMES_ZONES);
			urlString.append(Constants.AMPERSAND_ICON);
			urlString.append(Constants.FORMAT);
			urlString.append(Constants.EQUAL_ICON);
			urlString.append(Constants.JSON);
			result = urlString.toString();			
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		return result;
	}
	
	/**
	 * Method for calculating the distance from the IP location to Buenos Aires
	 * @param parLatitudeUbicationIp latitude of the Ip location
	 * @param parLongitudeUbicationIp length of the Ip location
	 * @param parLatitudeBuenosAires latitude of the Buenos Aires
	 * @param parLongitudeBuenosAire length of the Buenos Aires
	 * @param parEarthRadius approximate radius of the earth
	 * @return approximate distance from Ip location to Buenos Aires
	 * @author Miguel Hernandez
	 */
	private double calculateDistanceToBuenosAires(double parLatitudeUbicationIp, double parLongitudeUbicationIp,
											      double parLatitudeBuenosAires, double parLongitudeBuenosAire, 
											      double parEarthRadius) {
		double result = 0;	
		try {
			
			double lat1rad = Math.toRadians(parLatitudeUbicationIp);
		    double lon1rad = Math.toRadians(parLongitudeUbicationIp);
		    double lat2rad = Math.toRadians(parLatitudeBuenosAires);
		    double lon2rad = Math.toRadians(parLongitudeBuenosAire);

		    double difLatitud = lat1rad - lat2rad;
		    double difLongitud = lon1rad - lon2rad;

		    double a = Math.pow(Math.sin(difLatitud/2), 2) +
		            Math.cos(lat1rad) *
		            Math.cos(lat2rad) *
		            Math.pow(Math.sin(difLongitud/2), 2);
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
			
			double distance = parEarthRadius*c;
			
			result = distance;
						
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		return result;
	}
	
	/**
	 * Method responsible for creating the estimated distance response
	 * @param parDistance distance between the ip and Buenos Aires
	 * @param parLatitudeUbicationIp latitude of the Ip location
	 * @param parLongitudeUbicationIp length of the Ip location
	 * @param parLatitudeBuenosAires latitude of the Buenos Aires
	 * @param parLongitudeBuenosAire length of the Buenos Aires
	 * @return
	 */
	private String createResponseDistanceEstimated(double parDistance, double parLatitudeUbicationIp, double parLongitudeUbicationIp,
		      									   double parLatitudeBuenosAires, double parLongitudeBuenosAire) {		
		String result = Constants.EMPTY_STRING;		
		try {			
			StringBuilder resultString = new StringBuilder();
			resultString.append(parDistance);
			resultString.append(Constants.KILOMETERS);
			resultString.append(Constants.OPEN_PARENTHESIS);
			resultString.append(parLatitudeUbicationIp);
			resultString.append(Constants.COMMA);	
			resultString.append(parLongitudeUbicationIp);
			resultString.append(Constants.CLOSE_PARENTHESIS);
			resultString.append(Constants.A_ICON);
			resultString.append(Constants.OPEN_PARENTHESIS);
			resultString.append(parLatitudeBuenosAires);
			resultString.append(Constants.COMMA);	
			resultString.append(parLongitudeBuenosAire);
			resultString.append(Constants.CLOSE_PARENTHESIS);
			result = resultString.toString();
			
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		
		return result;
		
	}
	
	/**
	 * Method in charge of formatting the date
	 * @param parDate date to be formatted 
	 * @return formatted date
	 * @author Miguel Hernandez
	 */
	private String formatDate(Date parDate) {
		String result = Constants.EMPTY_STRING;
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			result = format.format(parDate);			
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		return result;
	}
	
	/**
	 * Method in charge of formatting the hpur
	 * @param parTimetstamp value in milliseconds of the hour 
	 * @return formatted hour
	 * @author Miguel Hernandez
	 */
	private String formatHour(long parTimetstamp) {
		String result = Constants.EMPTY_STRING;
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.HOUR_FORMAT);			
			Timestamp timeZone = new Timestamp(parTimetstamp);			
			result = format.format(timeZone);			
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		return result;
	}
	
	/**
	 * Method to obtain the languages of the country
	 * @param parListLanguages list of languages 
	 * @return list of languages found
	 * @author Miguel Hernandez
	 */
	private List<LanguageInformationIpRsDTO> getLanguagesCountry(List<LanguagesRsDTO> parListLanguages){
		List<LanguageInformationIpRsDTO> result = new ArrayList<>();
		try {
			if(parListLanguages != null && !parListLanguages.isEmpty()) {
				for(LanguagesRsDTO language: parListLanguages) {
					LanguageInformationIpRsDTO languageInformation = new LanguageInformationIpRsDTO();
					languageInformation.setCode(language.getCode());
					languageInformation.setLanguageName(language.getNativeResult());
					result.add(languageInformation);
				}
			}
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		return result;
	}
	
	/**
	 * Method in charge of inserting the record in the database
	 * @param parCountryName name of the country from which the service was consumed
	 * @param parDistance estimated distance between the location of the Ip and Buenos Aires
	 * @author Miguel Hernandez
	 */
	private void insertLocation(String parCountryName, double parDistance) {
		
		try {
			Location location = new Location();
			location.setCountryName(parCountryName);
			location.setDistance(parDistance);
			this.locationRepository.save(location);
			
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GenericDataRsDTO<AverageDistanceRsDTO> averageDistance() {
		GenericDataRsDTO<AverageDistanceRsDTO> result = new GenericDataRsDTO<>();
		AverageDistanceRsDTO averageDistanceResult = new AverageDistanceRsDTO();
		try {
			Location shortestLocation = this.locationEntityManager.findShortestDistance();
			if(shortestLocation.getCountryName() == null && shortestLocation.getId()== null && 
			   shortestLocation.getDistance() == 0.0) {
				result.setResponse(Boolean.FALSE, Constants.WARNING_MESSAGE, Constants.EMPTY_QUERY);
			}else {
				Location largestLocation = this.locationEntityManager.findLargestDistance();
				int quantityInvocationShortestLocation = this.locationRepository.findLocationsByCountryName(shortestLocation.getCountryName()).size();
				int quantityInvocationLargestLocation = this.locationRepository.findLocationsByCountryName(largestLocation.getCountryName()).size();
				String averageDistance = this.generateAverageDistance(shortestLocation.getDistance(), 
						                                              quantityInvocationShortestLocation, 
						                                              largestLocation.getDistance(), 
						                                              quantityInvocationLargestLocation);
				averageDistanceResult.setAverageDistance(averageDistance);
				averageDistanceResult.setDistanceCountryShortestDistance(this.generateResponseKilometers(shortestLocation.getDistance()));
				averageDistanceResult.setNameCountryShortestDistance(shortestLocation.getCountryName());
				averageDistanceResult.setQuantityInvocationsShortestDistance(quantityInvocationShortestLocation);
				averageDistanceResult.setDistanceCountryLongestDistance(this.generateResponseKilometers(largestLocation.getDistance()));
				averageDistanceResult.setNameCountryLongestDistance(largestLocation.getCountryName());
				averageDistanceResult.setQuantityInvocationsLongestDistance(quantityInvocationLargestLocation);
				result.setData(averageDistanceResult);
				result.setResponse(Boolean.TRUE, null, null);
		
			}
		} catch (GeneralException e) {
			throw new GeneralException(e.getErrorType(), e.getMessage());
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}		
		return result;
	}
	
	/**
	 * Method for performing the mathematical operation to obtain the average distance of service consumption
	 * @param parShortestDistance shortest consumption distance
	 * @param parShortestQuantity number of times the service has been consumed from the shortest distance
	 * @param parLargestDistance largest consumption distance
	 * @param parLargestQuantity number of times the service has been consumed from the largest distance
	 * @return average distance obtained
	 * @author Miguel Hernandez
	 */
	private String generateAverageDistance(double parShortestDistance, int parShortestQuantity, 
			                               double parLargestDistance, int parLargestQuantity) {
		String result = Constants.EMPTY_STRING;
		try {
			double valueShortest = this.getMultiplyingDistanceByQuantity(parShortestDistance, parShortestQuantity);
			double valueLargest = this.getMultiplyingDistanceByQuantity(parLargestDistance, parLargestQuantity);
			double sumQuantity = parShortestQuantity+parLargestQuantity;
			double sumValue = valueShortest+valueLargest;
			double resultValue = sumValue/sumQuantity;
			result = this.generateResponseKilometers(resultValue);			
		} catch(GeneralException e) {
			throw new GeneralException(e.getErrorType(), e.getMessage());
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}		
		return result;
	}
	
	/**
	 * Method to obtain the distance by number of service calls
	 * @param parDistance obtained distance
	 * @param parQuantity obtained quantity
	 * @return value obtained in the multiplication
	 * @author Miguel Hernandez
	 */
	private double getMultiplyingDistanceByQuantity(double parDistance, int parQuantity) {
		double result = 0;
		try {
			double quantity = parQuantity;
			result = parDistance*quantity;
			
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}
		return result;
	}
	
	/**
	 * Method for generating the distance response in kilometers
	 * @param parDistance distance to generate the response
	 * @return string with distance with unit of measure
	 * @author Miguel Hernandez 
	 */
	private String generateResponseKilometers(double parDistance) {		
		String result = Constants.EMPTY_STRING;		
		try {
			StringBuilder resultString = new StringBuilder();
			resultString.append(parDistance);
			resultString.append(Constants.KILOMETERS);
			result = resultString.toString();			
		} catch (Exception e) {
			throw new GeneralException(Constants.MENSAJE_ERROR, e.getMessage());
		}		
		return result;		
	}
	
	

}
