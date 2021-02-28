package com.cognizant.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.model.Movie;
import com.cognizant.service.MovieService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Shiyam
 *
 */
@RestController
@Slf4j
public class MovieController {

	

	/**
	 * 
	 *movie service interacts with repositories
	 * 
	 */
	@Autowired
	MovieService service;

	/**
	 * Gets movie list for admin
	 * http://localhost:9095/movie-list-admin
	 * @param map
	 * @return movie list for admin and add it to model map
	 * 
	 */
	@GetMapping("/movie-list-admin")
	public List<Movie> showAdminPage() {
		log.info("showMenuItemListAdmin -Start");
		List<Movie> items = service.getMoviesListAdmin();
		log.debug("AdminList:{}", items);
		log.info("showMenuItemListAdmin -End");
		return items;
	}

	/**
	 * Displays edit page for admin
	 * http://localhost:9095/movieDetails/1
	 * @param id
	 * @param movie
	 * @param map
	 * @return edit movie for admin and add the current movie to model map
	 * 
	 //* not work
	 */
	@GetMapping("/movieDetails/{id}")
	public Movie showEditMovie(@PathVariable("id") Integer id) {
		log.info("Start");
		Movie movie=service.getByMovieId(id);
		log.debug("Movie :{}", movie);
		log.info("End");
		return movie;
	}
	

	/**
	 * Updates movie
	 * http://localhost:9095/update
	 * @param movie
	 * @return success status if movie is updated else display save page
	 * 
	 */
	@PutMapping("/update")
	public String editMovie(@RequestBody @Valid Movie movie) {
		log.info("Start");
		service.editMenuItem(movie);
		log.info("End");
			return "editied Successfully";
	}

	/**
	 * Gets movie list for customers
	 * http://localhost:9095/movie-list-customer
	 * @param map
	 * @return movie list for customers
	 * 
	 */
	@GetMapping("/movie-list-customer")
	public List<Movie> showCustomerPage() {
		log.info("Start");
		List<Movie> movie=service.getMoviesListCustomer();
		log.info("End");
		return movie;
	}
}