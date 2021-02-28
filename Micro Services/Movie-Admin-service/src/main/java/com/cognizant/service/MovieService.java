package com.cognizant.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.model.Movie;
import com.cognizant.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Shiyam
 *
 */
@Service
@Slf4j
public class MovieService {

	/**
	 * log
	 */
	// private static final log log =
	// logFactory.getlog(MoviecuriserApplication.class);

	/**
	 * All repositories autowired
	 */
	@Autowired
	MovieRepository movieRepository;

	/**
	 * Gets the list of movies for admin
	 * 
	 * @return
	 */
	public List<Movie> getMoviesListAdmin() {
		log.info("Start");
		return movieRepository.findAll();
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

	@Transactional
	public void editMenuItem(Movie menuItem) {
		log.info("Start");
		Movie menu = movieRepository.getOne(menuItem.getId());
		menu.setId(menuItem.getId());
		menu.setTitle(menuItem.getTitle());
		menu.setBoxOffice(menuItem.getBoxOffice());
		menu.setActive(menuItem.isActive());
		menu.setDateOfLaunch(menuItem.getDateOfLaunch());
		menu.setHasTeaser(menuItem.isHasTeaser());
		menu.setGenre(menuItem.getGenre());
		movieRepository.save(menu);
		log.info("End");

	}

}
