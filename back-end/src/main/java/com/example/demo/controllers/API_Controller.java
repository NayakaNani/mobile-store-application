package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MobileStore;
import com.example.demo.entity.MobileStoreService;
import com.example.demo.responseenity.AppResponse;

@RestController
@RequestMapping("/mobiles")
public class API_Controller {

	@Autowired
	private MobileStoreService mobileStoreService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value ="/all",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<AppResponse> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(HttpStatus.OK.value(), mobileStoreService.findAll()));
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<AppResponse> create(@RequestBody @Valid List<MobileStore> mobile,BindingResult result) {
		if(result.hasErrors())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AppResponse(HttpStatus.BAD_REQUEST.value(),"Invalid Request"));
		mobileStoreService.save(mobile);
		return ResponseEntity.status(HttpStatus.CREATED).body(new AppResponse(HttpStatus.CREATED.value(),"Created Successfully"));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value ="/budjet",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<AppResponse> getBudjet(@RequestParam Integer a){
		return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(HttpStatus.OK.value(), mobileStoreService.priceLessThan(a)));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value ="/flagship",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<AppResponse> getFlagship(){
		return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(HttpStatus.OK.value(), mobileStoreService.flagshipPhone()));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value ="/bandf",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<AppResponse> getBudjetAndFlagship(@RequestParam Integer a){
		return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(HttpStatus.OK.value(), mobileStoreService.priceLTandFlagshipPhone(a)));
	}
	
	@DeleteMapping
	public ResponseEntity<AppResponse> getdelete(@RequestParam Integer a){
		mobileStoreService.delete(a);
		return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(HttpStatus.OK.value(),"Deleted successfully."));
	}
}
