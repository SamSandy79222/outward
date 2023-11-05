package com.sahil.springjwt.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.springjwt.models.User;
import com.sahil.springjwt.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
  
  @GetMapping("/list")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<List<User>> listUser(){
	  List<User> userlist=new ArrayList<>();
	  userRepository.findAll().forEach(userlist::add);
	  return new ResponseEntity<List<User>>(userlist,HttpStatus.OK);
	  

  }
  
  @GetMapping("/{userid}")
  @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<User> getUserById(@PathVariable long userid){
		Optional<User> user=userRepository.findById(userid);
		if (user.isPresent()) {
			return new ResponseEntity<User>(user.get(),HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

		}
		
	}
  
  @PutMapping("/update/{userid}")
  @PreAuthorize("hasRole('ADMIN')")

  public String updateUserById(@PathVariable long userid,@RequestBody User user) {
	  Optional<User> userr=userRepository.findById(userid);
	  if(userr.isPresent()) {
		  User existUser=userr.get();
		  existUser.setFirstname(user.getFirstname());
		  existUser.setLastname(user.getLastname());
		  existUser.setUsername(user.getUsername());
		  existUser.setEmail(user.getEmail());
		  existUser.setPassword(passwordEncoder.encode(user.getPassword()));
		  existUser.setRoles(user.getRoles());
		  userRepository.save(existUser);
		  return "user id "+userid+" updated succesfully";
		  
	  }else {
		return "user with id "+userid+" not exist";
	}
	  
  }
  
  
  
}
