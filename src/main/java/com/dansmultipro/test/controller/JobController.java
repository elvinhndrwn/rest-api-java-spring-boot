package com.dansmultipro.test.controller;

import com.dansmultipro.test.dto.JobResponse;
import com.dansmultipro.test.service.UserProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

	@Autowired
	private UserProcessService userDetailsService;

	@GetMapping("/job")
	public List<JobResponse> job() throws IOException {
		return userDetailsService.getJob();
	}

	@GetMapping("/job/{id}")
	public JobResponse jobDetail(@PathVariable String id) throws IOException {
		return userDetailsService.getJobDetails(id);
	}

}