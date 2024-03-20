package com.spring.service;

import org.springframework.http.ResponseEntity;

import com.spring.dto.UserRequest;
import com.spring.entity.User;
import com.spring.utility.ResponseStructure;

public interface UserService {

	public ResponseEntity<ResponseStructure<User>> saveUser(User user);

}
