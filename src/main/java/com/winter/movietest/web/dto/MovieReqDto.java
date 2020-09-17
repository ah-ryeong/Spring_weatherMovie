package com.winter.movietest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieReqDto {
	
	private String title;
	private String name;
	private int id;
	private double voteAverage;
	private String releaseDate;
	private String posterPath;
	private String overview;
	private String video;
}
