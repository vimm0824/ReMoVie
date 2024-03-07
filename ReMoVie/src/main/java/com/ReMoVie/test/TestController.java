package com.ReMoVie.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ReMoVie.infra.openApi.BoxOfficeOpenApi;
import com.ReMoVie.infra.openApi.TmdbOpenApi;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TestController {
	
	private final TestService testService;
	private final TmdbOpenApi tmdbOpenApi;
	private final BoxOfficeOpenApi boxOfficeOpenApi;
	
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
  	public Test test3() {
  		return testService.test(1L);
  	}
  	
  	@ResponseBody
  	@GetMapping("/test4/{search}")
  	public List<Map<String, Object>> test4(
  			@PathVariable("search") String search
  			) {
  		List<Map<String, Object>> result = new ArrayList<>();
  		
  		result = tmdbOpenApi.getTmdbSearch(search);
  		
  		return result;
  	}
  	
  	@ResponseBody
  	@GetMapping("/test5")
  	public List<Map<String, Object>> test5() {
  		List<Map<String, Object>> result = new ArrayList<>();
  		
  		result = boxOfficeOpenApi.getDailyBoxOffice();
  		
  		return result;
  	}
  	
  	@GetMapping("/test6")
  	public String test6(Model model) {
  		model.addAttribute("viewName", "testReMoVie");
  		
  		List<String> strList = testService.testImagePath();
  		model.addAttribute("strList", strList);
  		return "test/test";
  	}
  	
}