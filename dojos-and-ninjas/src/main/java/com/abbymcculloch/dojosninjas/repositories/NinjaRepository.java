package com.abbymcculloch.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.abbymcculloch.dojosninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}