package com.dansmultipro.test.service;

import com.dansmultipro.test.repository.UserRepository;
import com.dansmultipro.test.model.UserModel;
import com.dansmultipro.test.dto.JobResponse;
import com.dansmultipro.test.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UserProcessService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${url.job}")
	private String urlJob;

	@Value("${url.job.detail}")
	private String urlJobDetail;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public UserModel register(UserDTO user) {
		UserModel userModel = new UserModel();
		userModel.setUsername(user.getUsername());
		userModel.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(userModel);
	}

	public List<JobResponse> getJob() throws IOException {
		URL url = new URL(urlJob);
		JobResponse[] jobResponses = objectMapper.readValue(url, JobResponse[].class);
		log.info("length: {}", jobResponses.length);
		return Arrays.asList(jobResponses);
	}

	public JobResponse getJobDetails(String id) throws IOException {
		URL url = new URL(urlJobDetail+id);
		return objectMapper.readValue(url, JobResponse.class);
	}

}