package com.capgemini.movierating.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.movierating.model.MovieRating;

public interface MovieRatingRepo extends JpaRepository<MovieRating, Long> {

}
