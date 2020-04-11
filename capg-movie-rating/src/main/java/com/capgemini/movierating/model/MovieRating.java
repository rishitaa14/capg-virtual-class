package com.capgemini.movierating.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class MovieRating {
	@Id
	private long id;
	private int rating;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public MovieRating(long id, int rating) {
		super();
		this.id = id;
		this.rating = rating;
	}
	public MovieRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MovieRating [id=" + id + ", rating=" + rating + "]";
	}
	

}
