package com.ReMoVie.test;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {

	private final TestRepository testRepository;
	
	public Test test(Long i) {
		Test result = testRepository.findById(i).orElse(null);
		
		return result;
		
	}
	
}
