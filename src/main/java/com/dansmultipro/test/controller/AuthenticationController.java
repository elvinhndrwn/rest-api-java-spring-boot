package com.dansmultipro.test.controller;

import com.dansmultipro.test.config.JwtTokenUtil;
import com.dansmultipro.test.dto.AuthRequest;
import com.dansmultipro.test.dto.AuthResponse;
import com.dansmultipro.test.dto.UserDTO;
import com.dansmultipro.test.model.UserModel;
import com.dansmultipro.test.service.UserProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserProcessService userDetailsService;

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authenticationRequest) {

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthResponse(token));
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<UserModel> register(@RequestBody UserDTO user) {
		return ResponseEntity.ok(userDetailsService.register(user));
	}

}