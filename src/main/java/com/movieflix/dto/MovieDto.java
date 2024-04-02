package com.movieflix.dto;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto 
{

	private Integer movieId;
	

	@NotBlank(message = "Please Provide movies Title!")
	private String title;
	
	
	@NotBlank(message = "Please Provide movies Director!")
	private String director;
	
	
	@NotBlank(message = "Please Provide movies Studio")
	private String studio;
	

	private Set<String> movieCast;
	
	
	
	private Integer releaseYear;
	
	
	@NotBlank(message = "Please Provide movies Poster")
	private String poster;
	
	@NotBlank(message = "Please provide poster's url!")
	private String posterUrl;
}
