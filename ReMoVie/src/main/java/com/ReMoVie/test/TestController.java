package com.ReMoVie.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@ResponseBody
    @GetMapping("/test1")
    public String helloWorld() {
        return "Hello world!";
    }
  
  	@ResponseBody
	@GetMapping("/test2")
	public Map<String, Object> test2() {
		Map<String, Object> result = new HashMap<>();
		result.put("test1", 1);
		result.put("test2", 2);
		return result;
	}
  	
  	@ResponseBody
  	@GetMapping("/test3")
  	public Map<String, Object> test3() {
  		
  	}
}