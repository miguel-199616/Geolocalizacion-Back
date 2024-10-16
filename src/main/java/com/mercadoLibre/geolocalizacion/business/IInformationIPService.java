package com.mercadoLibre.geolocalizacion.business;

import com.mercadoLibre.geolocalizacion.model.rs.AverageDistanceRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.GenericDataRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.InformationIpRsDTO;

public interface IInformationIPService {
	
	/**
	 * Method in charge of obtaining the information of the location of the entered Ip
	 * @param parIp Ip of which you want to know the information
	 * @return finded ip information
	 * @author Miguel Hernandez
	 */
	public GenericDataRsDTO<InformationIpRsDTO> getInformationIp(String parIp);
	
	/**
	 * Method to obtain the data of the countries that have consumed the most and least IP information 
	 * service and based on the distance of those countries from Buenos Aires, obtain the average distance. 
	 * @return object obtained from the average distance
	 * @author Miguel Hernandez
	 */
	public GenericDataRsDTO<AverageDistanceRsDTO> averageDistance();

}
