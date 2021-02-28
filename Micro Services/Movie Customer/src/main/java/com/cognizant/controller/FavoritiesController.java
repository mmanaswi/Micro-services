package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.MovieNotFoundException;
import com.cognizant.model.Movie;
import com.cognizant.service.CustomerService;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FavoritiesController {

	@Autowired
	CustomerService movieService;

	
	/**
	 * Gets favorite movie list for customer
	 * http://localhost:9095/favoritiesMovies/1
	 * @param userId
	 * @param map
	 * @return favorite movie list for customer
	 * @throws MovieNotFoundException if no movie is in list
	 * 
	 */
	
	@GetMapping("/favoritiesMovies/{id}")
	public List<Movie> showFav(@PathVariable("id") Integer id) throws MovieNotFoundException {

		log.info("Start");
			List<Movie> movie= movieService.getFaviorateMovies(id);
			log.info("End");
			return movie;

	}

	/**
	 * Adds the movie to list
	 * http://localhost:9095/addToFavorities/2
	 * @param movie_id
	 * @param modelMap
	 * @return success status if movie does not exist else display movie already
	 * exist
	 */
	@GetMapping("/addToFavorities/{id}")
	public String addFaviorateMovie(@PathVariable("id") Integer id) {
		log.info("Start");
		String url = "";
		movieService.getMoviesListCustomer();
		try {
			if (movieService.getFaviorateMovies(1).contains(movieService.getByMovieId(id))) {

				url = "movie-list-customer-already-present";
			} else {
				movieService.saveToFaviorate(movieService.getByMovieId(id));
				url = "success";
			}

		} catch (MovieNotFoundException e) {
			// TODO: handle exception
			movieService.saveToFaviorate(movieService.getByMovieId(id));
			url = "suceess";

		}

		log.info("End");
		return url;
	}

	/**
	 * Deletes from favorites
	 * http://localhost:9095/deleteFromFavorities/1
	 * @param movie_id
	 * @param map
	 * @return success status if movie is deleted else empty page
	 * 
	 */
	@GetMapping("/deleteFromFavorities/{id}")
	public String deleteFromFaviorates(@PathVariable("id") Integer movie_id) {
		log.info("Start");
		movieService.deleteFaviorate(movie_id);
			return "success";	
	}
}