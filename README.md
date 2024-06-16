# Movies Webapp

![License](https://img.shields.io/badge/license-MIT-blue.svg)
![Version](https://img.shields.io/badge/version-0.0.1--SNAPSHOT-brightgreen.svg)
![Build Status](https://github.com/eduardoschoepf/movies-webapp/actions/workflows/ci.yml/badge.svg)

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Configuration](#configuration)

## Introduction

MoviesApp is a web application developed with Java Spring Boot. It allows users to browse popular movies based on The Movie Database (TMDb) API.  

<img src="/assets/movies_webapp.png" alt="Movies interface" width="300"/>

## Features

- **Browse Popular Movies**: Display a list of popular movies.
- **Movie Details**: View details of a specific movie.
- **Search Movies**: Search for movies by title.
- **User Management**: Create and manage user accounts.

## Configuration

### `application.properties` File

```properties
# Global configuration
spring.application.name=moviesapp

# Tomcat configuration
server.port=8080

# Log level configuration
logging.level.root=ERROR
logging.level.org.springframework.boot.web.embedded.tomcat=INFO

# Movie DB API configuration
com.webapp.moviesapp.apiUrl=https://api.themoviedb.org/3/movie/popular?api_key=
com.webapp.moviesapp.apiKey=your_api_key
