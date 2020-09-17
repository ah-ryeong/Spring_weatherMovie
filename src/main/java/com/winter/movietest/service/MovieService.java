package com.winter.movietest.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.winter.movietest.domain.Movie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieService {

	private final String API_KEY = "13989236e4a4d414a34074e137adb54e";
	private final String OpenMovieApiUrl_getMovies = "https://api.themoviedb.org/3/discover/movie?api_key="+ API_KEY +"&language=ko&sort_by=popularity.desc&include_adult=false&include_video=false&page=1";
	
	@Transactional
	public String 영화저장하기() {
		
	ObjectMapper mapper = new ObjectMapper();
	try {
		Movie movie = mapper.readValue(new URL(OpenMovieApiUrl_getMovies), Movie.class);
		
		System.out.println("MovieService : movie :::::: "+movie);

	} catch (JsonParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
	}
}
