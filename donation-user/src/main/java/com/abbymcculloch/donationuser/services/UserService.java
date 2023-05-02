package com.abbymcculloch.donationuser.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abbymcculloch.donationuser.models.User;
import com.abbymcculloch.donationuser.repositories.UserRepository;



@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
//	FIND ALL-------------
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
//	CREATE -------------

	public User createUser(User newUser) {
		return userRepo.save(newUser);
	}
	
//	FIND ONE-------------

	public User findUser(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }
	
//	UPDATE -------------
	public User updateUser(User oneUser) {
		return userRepo.save(oneUser);
	}
	
//	DELETE-------------
	public void removeUser(Long id) {
		userRepo.deleteById(id);
	}
	
}

