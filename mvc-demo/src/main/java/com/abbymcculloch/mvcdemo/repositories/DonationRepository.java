package com.abbymcculloch.mvcdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abbymcculloch.mvcdemo.models.Donation;

//this is to query the DB

@Repository
//long reflects the IDs datatype

public interface DonationRepository extends CrudRepository<Donation, Long> {
//	this is all I need
	List<Donation> findAll();
	
//	extras depend on model
//	List<Donation> findByDonor(String donor);
}
