package com.abbymcculloch.loginreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.abbymcculloch.loginreg.models.LoginUser;
import com.abbymcculloch.loginreg.models.User;
import com.abbymcculloch.loginreg.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
//      1. find user in db by email
    	Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
//  	2. if user is present, then reject
    	if(optionalUser.isPresent()) {
    		result.rejectValue("email", "unique", "This email is already registered");
    	}
//    	3. Reject if password doesnt match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())){
    		result.rejectValue("confirm", "match", "Confirm password does not match");
    	}
//    	4.if result has error, return
    	if(result.hasErrors()) {
    		return null;
    	}
//      5. hash and set password, save user to DB
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);
    	return userRepo.save(newUser);
        
          }
    public User login(LoginUser newLogin, BindingResult result) {
//      1. find user in the db by email
    	Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
//    	2. if the email is not present reject
    	if(!optionalUser.isPresent()) {
    		result.rejectValue("email", "unique", "This email is not registered");
    		return null;
    	}
//    	3. grab the user from potential user
    	User user = optionalUser.get();
//    	4. if result has errors, return
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    			result.rejectValue("password", "matches", "the password is not right");
    	}
//    	5. Otherwise return the user object
    	return user;
    	
    	
    }
}
