package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.exception.MovieNotFoundException;
import com.cognizant.model.Favorities;
import com.cognizant.model.Movie;
import com.cognizant.repository.FaviorateRepository;
import com.cognizant.repository.MovieRepository;
import com.cognizant.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Shiyam
 *
 */
@Service
@Slf4j
public class CustomerService {


	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FaviorateRepository faviorateRepository;
	
	public List<Movie> getFaviorateMovies(int userId) throws MovieNotFoundException {
		log.info("Start");
		List<Movie> movies = new ArrayList<>();
		faviorateRepository.getFaviorateMovies(userId).stream().forEach(id -> movies.add(movieRepository.getOne(id)));
		log.info("End");
		if(movies.isEmpty())
			throw new MovieNotFoundException();
		return movies;
	}
	@Transactional
	public void deleteFaviorate(Integer movie_id)
	{
		
		faviorateRepository.deleteFromFaviorate(1, movie_id);
		
	}
	@Transactional
	public boolean saveToFaviorate(Movie movie)
	{
		
		log.info("Start");
		Favorities favorities = new Favorities();
		favorities.setMovie(movie);
		favorities.setUser(userRepository.getOne(1));
		log.info("End");
		if(faviorateRepository.save(favorities)==null)
			return false;
		return true;
	}
	public Movie getByMovieId(int id) {
		log.info("Start");
		return movieRepository.getOne(id);
	}
public List<Movie> getMoviesListCustomer() {
		
		// TODO Auto-generated method stub
		log.info("Start");
		return movieRepository.findCustomerMovies();
	}
}
