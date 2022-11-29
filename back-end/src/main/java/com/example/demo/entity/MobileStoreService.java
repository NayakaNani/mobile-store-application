package com.example.demo.entity;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.StorRepository;

@Service
public class MobileStoreService {

	@Autowired
	private StorRepository storRepositoty;
	
	public List<MobileStore> findAll(){
		return storRepositoty.findAll();
	}
	
	public List<MobileStore> priceLessThan(Integer a){
		return storRepositoty.findPriceLessThan(a);
	}
	
	public List<MobileStore> priceLTandFlagshipPhone(Integer a){
		return storRepositoty.findPriceLTandFlagship(a);
	}
	
	public List<MobileStore> flagshipPhone(){
		return storRepositoty.findFlagshipPhones();
	}
	
	public void save(List<MobileStore> a){
		storRepositoty.saveAll(a);
	}
	
	@Transactional
	public void delete(Integer a){
		storRepositoty.delete(a);
	}
	
	public List<MobileStore> brandSpecificMobiles(String name){
	  return storRepositoty.findBrandSpecificMobiles(name);
	}
	
	public List<MobileStore> brandSpecificFlagshipMobiles(String name){
		return storRepositoty.findBrandSpecificFlagshipMobiles(name);
	}
	
	public List<MobileStore> brandSpecificBudjectMobiles(String name,Integer a){
		return storRepositoty.findBrandSpecificBudjetMobiles(name, a);
	}
	
	public List<MobileStore> brandSpecificFlagshipBudjetMobiles(String name,Integer a){
		return storRepositoty.findBrandSpecificFlagshipBudjetMobiles(name, a);
	}
}
