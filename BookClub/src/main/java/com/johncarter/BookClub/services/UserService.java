package com.johncarter.BookClub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.johncarter.BookClub.models.RegisterLogin;
import com.johncarter.BookClub.models.User;
import com.johncarter.BookClub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired 
	UserRepository urepo;
	
	public User findById(Long id) {
		Optional<User> r = urepo.findById(id);
		if(r.isPresent()) {
			return r.get();
		}
		return null;
	}

	public User findByEmail(String email) {
		Optional<User> r = urepo.findByEmail(email);
		if(r.isPresent()) {
			return r.get();
		}
		return null;
	}
	
	/*
	* CrudRepository services
	*/
	public List<User> all() {
		return urepo.findAll();
	}
	
	public User update(User u) {
		return urepo.save(u);
	}
	
	public User create(User u) {
		return urepo.save(u);
	}
	
	public void delete(User u) {
		urepo.delete(u);
	}



	/**
	* Login and Registration services
	*/
	public User reg(User nUser, BindingResult r) {
		//look up user through the db
		Optional<User> potentialUser = urepo.findByEmail(nUser.getEmail());
		if (potentialUser.isPresent()) {
			r.rejectValue("email", "Unique", "Sorry this email is tied to an account that already exists");
		}

		//check if the confirm password to see if it matches the pw
		if(!nUser.getPassword().equals(nUser.getConfirm())){
			r.rejectValue("confirm", "The two passwords do not match!");
		}

		//if the result has errors then reject
		if(r.hasErrors()) {
			return null;
		}

		//hash then set the pw in the db
		String hashedpw = BCrypt.hashpw(nUser.getPassword(), BCrypt.gensalt());
		nUser.setPassword(hashedpw);

		nUser = urepo.save(nUser);
		return nUser;
	}

	public User login(RegisterLogin nLog, BindingResult r) {
		Optional<User> potentialUser = urepo.findByEmail(nLog.getEmail());
		if (!potentialUser.isPresent()) {
                	r.rejectValue("email", "There is no account tied to this email");
			return null;
		}
		//retrieve the user from the db
		User user = potentialUser.get();

		//BCrypt val to reject password if it doesnt match
		if(!BCrypt.checkpw(nLog.getPassword(), user.getPassword())) {
			r.rejectValue("password", "The password is invalid");
		}

		//if the result has errors then reject
		if(r.hasErrors()) {
			return null;
		}
		
		//return the object user
		return user;
	}
	
	

}
