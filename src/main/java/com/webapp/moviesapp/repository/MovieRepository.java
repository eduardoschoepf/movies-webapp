package com.webapp.moviesapp.repository;

import com.webapp.moviesapp.model.Movie;
import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();
}