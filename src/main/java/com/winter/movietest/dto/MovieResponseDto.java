package com.winter.movietest.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponseDto {
	
	public String title;
	public String link;
	public String image;
	public String subtitle;
	public Date pubDate;
	public String actor;
}
