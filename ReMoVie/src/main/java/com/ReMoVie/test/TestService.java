package com.ReMoVie.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ReMoVie.infra.openApi.BoxOfficeOpenApi;
import com.ReMoVie.infra.openApi.TmdbOpenApi;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {

	private final TestRepository testRepository;
	private final BoxOfficeOpenApi boxOpenApi;
	private final TmdbOpenApi tmdbOpenApi;
	
	public Test test(Long i) {
		Test result = testRepository.findById(i).orElse(null);
		
		return result;
		
	}
	
	public List<String> testImagePath() {
		List<Map<String, Object>> mapList = boxOpenApi.getDailyBoxOffice();
		List<String> strList = new ArrayList<>();
		List<String> nameList = new ArrayList<>();
		
		for (Map<String, Object> m : mapList) {
			String movieNm = (String)m.get("movieNm");
			nameList.add(movieNm);
		}
		
		for (String name : nameList) {
			if (name.contains(":")) {
				String[] s = name.split(":");
				name = s[0];
			}
			String poster = tmdbOpenApi.getTmdbSearch(name).get(0).get("poster_path").toString();
			strList.add("https://image.tmdb.org/t/p/original" + poster);
		}
		
		return strList; 
	}
}
