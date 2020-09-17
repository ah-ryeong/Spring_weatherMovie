package com.winter.movietest.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.movietest.api.MovieApiClient;
import com.winter.movietest.service.MovieService;
import com.winter.movietest.web.dto.MovieReqDto;

import lombok.RequiredArgsConstructor;

@Controller
@CrossOrigin(origins = "/*")
@RequestMapping("movie") // 컨트롤러 진입 주소
@RequiredArgsConstructor // final과 붙어있는 필드의 생성자를 다 만들어줌
public class MovieApiController {
	
	private final MovieApiClient movieApiClient;
	private final MovieService movieService;
	
	@GetMapping("/")
	public String MovieMain() {
		
		return "movie";
	}

	@GetMapping("/{keyword}")
	public ResponseEntity MovieResponse(@PathVariable String keyword) {
		
		return movieApiClient.findByKeyword(keyword);
	}
	
	@GetMapping("/save")
	public String MovieSave() {
		movieService.영화저장하기();
		
		return "저장완료";
	}

}
