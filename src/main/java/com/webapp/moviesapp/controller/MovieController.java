package com.webapp.moviesapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.webapp.moviesapp.model.Movie;
import com.webapp.moviesapp.service.MovieService;


@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String home(Model model) {
        List<Movie> movies = movieService.getPopularMovies();
        model.addAttribute("movies", movies);
        System.out.println(movies);
        return "home";
    }
}

