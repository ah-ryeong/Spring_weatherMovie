package com.winter.movietest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieApiClient {

	private final String API_KEY = "13989236e4a4d414a34074e137adb54e";
	private final String keyword = "";
	
	@Autowired // RestTemplate : HTTP 서버와 쉽게 통신가능한 자바 라이브러리, 응답을 JSON, xml 형식으로 쉽게 변환
	private final RestTemplate restTemplate;
	
	@Transactional(readOnly = true)
	public ResponseEntity findByKeyword(String keyword) {		
		String OpenMovieApiUrl_getMovies = "https://api.themoviedb.org/3/search/keyword?api_key="+ API_KEY +"&query="+keyword+"&page=1";
		System.out.println("MovieApiClient : URL ::: " + OpenMovieApiUrl_getMovies);
		
		// 헤더에 key 담아줄거임 , HttpHeaders : Authorization같은 Key들 여기 헤더에 넣어서 보냄 
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		final HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity response = restTemplate.exchange(OpenMovieApiUrl_getMovies, HttpMethod.GET, entity, String.class, keyword);
		System.out.println("MovieApiClient : Json ::: " + response);
		
		// RestTemplate.exchange : Get메소드로 뭐시기뭐시기
		return response;
	}
}
