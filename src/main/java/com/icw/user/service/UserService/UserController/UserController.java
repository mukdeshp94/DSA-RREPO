package com.icw.user.service.UserService.UserController;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icw.user.service.UserService.Exception.UserNotFoundException;
import com.icw.user.service.UserService.UserBean.User;
import com.icw.user.service.UserService.UserDaosService.UserDao;

@RestController
public class UserController {

	@Autowired
	private UserDao user;

	@GetMapping("/user")
	public List<User> getAllUsers() {

		return user.findAll();
	}

	@GetMapping("/user/{id}")
	public EntityModel<User> getUsers(@PathVariable Integer id) {

		User findOne = user.findOne(id);
		if (findOne == null) 
			throw new UserNotFoundException("User is not present in the system");
			EntityModel<User> entitymodel =EntityModel.of(findOne);
			WebMvcLinkBuilder links=linkTo(methodOn(this.getClass()).getAllUsers());
			entitymodel.add(links.withRel("all users"));
			
		
		return entitymodel;
	}

	@DeleteMapping("/user/{id}")
	public void deleteUsers(@PathVariable Integer id) {

		user.deleteOne(id);

	}

	@PostMapping("/adduser")
	public ResponseEntity<Object> createUser(@RequestBody User users) {
		User u = user.addUser(users);

		URI Location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(Location).build();
	}
	
	public String UserAddToDb() {
		
		return "Data is successfully inserted";
	}
	
}
