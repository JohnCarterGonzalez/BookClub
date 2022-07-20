package com.johncarter.BookClub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

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
	public User reg(User nUser, BindingResult result) {
		Optional<User> potentialUser = urepo.findByEmail(nUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Sorry this email is tied to an account that already exists");
		}
		if(!nUser.getPassword().equals(nUser.getConfirm()){
			result.rejectValue("confirm", "The two passwords do not match!");
		}

		if(result.hasErrors()) {
			return null;
		}

		String hashedpw = BCrypt.hashpw(nUser.getPassword(), BCrypt.gensalt());
		nUser.setPassword(hashedpw);

		nUser = urepo.save(nUser);
		return nUser;
	}
	
	

}
