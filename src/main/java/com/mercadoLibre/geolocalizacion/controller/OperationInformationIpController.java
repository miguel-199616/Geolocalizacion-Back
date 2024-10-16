package com.mercadoLibre.geolocalizacion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mercadoLibre.geolocalizacion.business.IInformationIPService;
import com.mercadoLibre.geolocalizacion.model.rq.ObjectString;
import com.mercadoLibre.geolocalizacion.model.rs.AverageDistanceRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.GenericDataRsDTO;
import com.mercadoLibre.geolocalizacion.model.rs.InformationIpRsDTO;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/operations-ips")
public class OperationInformationIpController {
	
	@Autowired
	private IInformationIPService informationIpService;
	
	@PostMapping(value = "/get-information-ip", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<GenericDataRsDTO<InformationIpRsDTO>> getInformationIps(@Valid @RequestBody ObjectString parObject){
		GenericDataRsDTO<InformationIpRsDTO> result = this.informationIpService.getInformationIp(parObject.getMessage());
		return new ResponseEntity<GenericDataRsDTO<InformationIpRsDTO>>(result, HttpStatus.OK);		
	}
	
	@PostMapping(value = "/average-distance-countrys", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<GenericDataRsDTO<AverageDistanceRsDTO>> averageDistanceCountrys(){
		GenericDataRsDTO<AverageDistanceRsDTO> result = this.informationIpService.averageDistance();
		return new ResponseEntity<GenericDataRsDTO<AverageDistanceRsDTO>>(result, HttpStatus.OK);		
	}
	
	

}
