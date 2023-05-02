package com.abbymcculloch.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.abbymcculloch.dojosninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();

}
