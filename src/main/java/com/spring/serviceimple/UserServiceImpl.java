package com.spring.serviceimple;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.dto.UserRequest;
import com.spring.entity.User;
import com.spring.repository.UserRepository;
import com.spring.service.UserService;
import com.spring.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService{
	
	public UserRepository repository;
	public ResponseStructure<User> structure;
	
	

	public UserServiceImpl(UserRepository repository, ResponseStructure<User> structure) {
		super();
		this.repository = repository;
		this.structure = structure;
	}



	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		
		
		return ResponseEntity.ok(structure.setMessage("User saved Successfully")
				.setStatusCode(HttpStatus.OK.value())
				.setData(repository.save(user)));
		
	}


	
	
	
	

	/*
	 * private User mapToUser(UserRequest userRequest, User user) {
	 * user.setUserName(userRequest.getUserName());
	 * user.setUserEmail(userRequest.getUserEmail());
	 * user.setPhoneNo(userRequest.getPhoneNo());
	 * user.setUserPassword(userRequest.getUserPassword()); return user; }
	 */
	
	

}
