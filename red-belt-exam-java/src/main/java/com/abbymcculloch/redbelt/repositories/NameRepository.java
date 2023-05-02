package com.abbymcculloch.redbelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abbymcculloch.redbelt.models.Name;

@Repository
public interface NameRepository extends CrudRepository<Name, Long> {
	List<Name> findAll();

}
