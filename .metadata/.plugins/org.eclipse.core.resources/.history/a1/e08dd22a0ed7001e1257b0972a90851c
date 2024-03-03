package com.ReMoVie.infra.openApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class TmdbOpenApi {

	public List<Map<String, Object>> getTmdbSearch(String search) {
		String jsonString = "";
		String accept = "application/json";
		String authorization = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwMjZjNDA2MTFhMjhlZGFiYzZlOTcwMzAyNzEyNGVlYiIsInN1YiI6IjY1NDRhZDE2NmJlYWVhMDBlYWY2YzIzMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.mguPzNsLT0CT2GCM2hzC-vS2UHllTu_ebKDT12-Kmn0";
		
		OkHttpClient client = new OkHttpClient();
		
		Request request = new Request.Builder()
				  .url("https://api.themoviedb.org/3/search/multi?include_adult=false&language=ko-KR&page=1&query=" + search)
				  .get()
				  .addHeader("accept", accept)
				  .addHeader("Authorization", authorization)
				  .build();
		
		Map<String, Object> map = null;
		List<Map<String, Object>> result = new ArrayList<>();
		
		try {
			Response response = client.newCall(request).execute();
			jsonString = response.body().string();
			
			map = new ObjectMapper().readValue(jsonString, Map.class);
			result = (List<Map<String, Object>>) map.get("results");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
