package com.abbymcculloch.donationuser.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abbymcculloch.donationuser.models.Donation;


//this is to query the DB

//long reflects the IDs datatype

public interface DonationRepository extends CrudRepository<Donation, Long> {
//	this is all I need
	List<Donation> findAll();
	
//	extras depend on model
//	List<Donation> findByDonor(String donor);
}
