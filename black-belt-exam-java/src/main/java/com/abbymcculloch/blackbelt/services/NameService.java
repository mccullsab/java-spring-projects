package com.abbymcculloch.blackbelt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.abbymcculloch.blackbelt.models.Name;
import com.abbymcculloch.blackbelt.models.User;
import com.abbymcculloch.blackbelt.repositories.NameRepository;



@Service
public class NameService {

	@Autowired
	private NameRepository nameRepo;
	
	
	public List<Name> getAssignedNames(User user){
		return nameRepo.findAllByUsers(user);
	}
	
	public List<Name> getUnassignedNames(User user){
		return nameRepo.findByUsersNotContains(user);
	}
	
//	FIND ALL-------------
	public List<Name> allNames(){
		return nameRepo.findAll();
	}
	
//	CREATE -------------

	public Name createName(Name newName, BindingResult result) {
		
		List<Name> existingNames = nameRepo.findAll();
		for (Name name : existingNames) {
			if (name.getBabyName().equals(newName.getBabyName())) {
				result.rejectValue("babyName", "unique", "This name is already in the DB");
				break;
			}
		}

//    	4.if result has error, return
    	if(result.hasErrors()) {
    		return null;
    	}
		
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
