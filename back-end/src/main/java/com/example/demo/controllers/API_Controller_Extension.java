package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MobileStoreService;
import com.example.demo.responseenity.AppResponse;

@RestController
@RequestMapping("/mobiles2")
public class API_Controller_Extension {

	@Autowired
	private MobileStoreService mobilestoreservice;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/brand",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	ResponseEntity<AppResponse> getSprecificMobiles(@RequestParam String name){
		return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(HttpStatus.OK.value(),mobilestoreservice.brandSpecificMobiles(name)));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/bandf",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	ResponseEntity<AppResponse> getSprecificFlagshipMobiles(@RequestParam String name){
		return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(HttpStatus.OK.value(),mobilestoreservice.brandSpecificFlagshipMobiles(name)));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/bandb",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	ResponseEntity<AppResponse> getSprecificBudjetMobiles(@RequestParam String name,@RequestParam Integer a){
		return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(HttpStatus.OK.value(),mobilestoreservice.brandSpecificBudjectMobiles(name,a)));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/bandfandb",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	ResponseEntity<AppResponse> getSprecificFlagshipBudjetMobiles(@RequestParam String name,@RequestParam Integer a){
		return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(HttpStatus.OK.value(),mobilestoreservice.brandSpecificFlagshipBudjetMobiles(name, a)));
	}
}
