package com.capgemini.movierating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.movierating.dao.MovieRatingRepo;
import com.capgemini.movierating.model.MovieRating;
@Service
public class MovieRatingService {
	
	@Autowired
	MovieRatingRepo repo;
	
	public MovieRating getMovieRating(long id) {
		return repo.getOne(id);
	}
	public List<MovieRating> getAllMovieRating() {
		return repo.findAll();
	}
	public MovieRating addMovieRating(MovieRating rating) {
		return repo.save(rating);
	}

}
