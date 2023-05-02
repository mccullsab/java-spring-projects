package com.abbymcculloch.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbymcculloch.dojosninjas.models.Ninja;
import com.abbymcculloch.dojosninjas.repositories.NinjaRepository;


@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepo;
	
//	FIND ALL-------------
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
//	CREATE -------------

	public Ninja createNinja(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
//	FIND ONE-------------

	public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
	
//	UPDATE -------------
	public Ninja updateNinja(Ninja oneNinja) {
		return ninjaRepo.save(oneNinja);
	}
	
//	DELETE-------------
	public void removeNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
	
}
