package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MobileStore;

@Repository
public interface StorRepository extends JpaRepository<MobileStore, Integer> {

	@Query(nativeQuery = true,value = "select * from mobile_store e where e.price<=:price")
	public List<MobileStore> findPriceLessThan(@Param("price") Integer a);
	
	@Query(nativeQuery = true,value = "select * from mobile_store e where e.price<=:price and e.flagshipPhone=true")
	public List<MobileStore> findPriceLTandFlagship(@Param("price") Integer a);
	
	@Query(nativeQuery = true,value = "select * from mobile_store e where e.flagshipPhone=true")
	public List<MobileStore> findFlagshipPhones();
	
	@Modifying
	@Query(nativeQuery = true,value = "delete from mobile_store e where e.id=:id")
	public void delete(@Param("id") Integer a);
	
	@Query(nativeQuery = true,value = "select * from mobile_store e where e.company=:name")
	public List<MobileStore> findBrandSpecificMobiles(@Param("name") String name);
	
	@Query(nativeQuery = true,value = "select * from mobile_store e where e.company=:name and e.flagshipPhone=true")
	public List<MobileStore> findBrandSpecificFlagshipMobiles(@Param("name") String name);
	
	@Query(nativeQuery = true,value = "select * from mobile_store e where e.company=:name and e.price<=:price")
	public List<MobileStore> findBrandSpecificBudjetMobiles(@Param("name") String name,@Param("price") Integer a);
	
	@Query(nativeQuery = true,value = "select * from mobile_store e where e.company=:name and e.flagshipPhone=true and e.price<=:price")
	public List<MobileStore> findBrandSpecificFlagshipBudjetMobiles(@Param("name") String name,@Param("price") Integer a);
}
