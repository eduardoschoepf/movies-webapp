package com.webapp.moviesapp.repository;


import com.webapp.moviesapp.CustomProperties;
import com.webapp.moviesapp.model.Movie;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TmdbMovieRepository implements MovieRepository{
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
	private CustomProperties props;

    public TmdbMovieRepository(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Movie> findAll() {
        String baseApiUrl = props.getApiUrl();
        String apiKey = props.getApiKey();
        String url = baseApiUrl + apiKey;
        String jsonResponse = restTemplate.getForObject(url, String.class);
        return parseMovies(jsonResponse);
    }

    private List<Movie> parseMovies(String jsonResponse) {
        List<Movie> movies = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(jsonResponse);
            JsonNode results = root.path("results");
            for (JsonNode node : results) {
                Movie movie = new Movie();
                movie.setId(node.path("id").asLong());
                movie.setTitle(node.path("title").asText());
                movie.setOverview(node.path("overview").asText());
                movie.setReleaseDate(node.path("release_date").asText());
                movie.setVoteAverage(node.path("vote_average").asDouble());
                movie.setPosterPath(node.path("poster_path").asText());
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
}