package com.abbymcculloch.redbelt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbymcculloch.redbelt.models.Name;
import com.abbymcculloch.redbelt.repositories.NameRepository;

@Service
public class NameService {

	@Autowired
	private NameRepository nameRepo;
	
//	FIND ALL-------------
	public List<Name> allNames(){
		return nameRepo.findAll();
	}
	
//	CREATE -------------

	public Name createName(Name newName) {
		return nameRepo.save(newName);
	}
	
//	FIND ONE-------------

	public Name findName(Long id) {
        Optional<Name> optionalName = nameRepo.findById(id);
        if(optionalName.isPresent()) {
            return optionalName.get();
        } else {
            return null;
        }
    }
	
//	UPDATE -------------
	public Name updateName(Name oneName) {
		return nameRepo.save(oneName);
	}
	
//	DELETE-------------
	public void removeName(Long id) {
		nameRepo.deleteById(id);
	}
	
}
