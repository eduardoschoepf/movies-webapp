package com.webapp.moviesapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.webapp.moviesapp.model.Movie;
import com.webapp.moviesapp.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getPopularMovies() {
        return movieRepository.findAll();
    }
}