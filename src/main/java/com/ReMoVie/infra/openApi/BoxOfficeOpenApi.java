package com.ReMoVie.infra.openApi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class BoxOfficeOpenApi {

	public List<Map<String, Object>> getDailyBoxOffice() {
		
		String jsonString = "";
		String url = " http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		String key = "key=0a3d75ef1d272ded4accb0dcb474129a";
		String targetDate = "targetDt=";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar day = Calendar.getInstance();
		day.add(Calendar.DATE, -1);
		targetDate += sdf.format(day.getTime());
		
		
		OkHttpClient client = new OkHttpClient();
		
		Request request = new Request.Builder()
				  .url(url + "?" + key + "&" + targetDate)
				  .get()
				  .build();
		
		Map<String, Object> map = null;
		List<Map<String, Object>> result = new ArrayList<>();
		
		try {
			Response response = client.newCall(request).execute();
			jsonString = response.body().string();
			map = new ObjectMapper().readValue(jsonString, Map.class);
			
			String mapKey = "";
			for (String menu : map.keySet()) {
				mapKey = menu;
			}
			
			map = (Map<String, Object>) map.get(mapKey);
			result = (List<Map<String, Object>>)map.get("dailyBoxOfficeList");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
