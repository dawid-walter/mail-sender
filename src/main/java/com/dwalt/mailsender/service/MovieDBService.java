package com.dwalt.mailsender.service;

import com.dwalt.mailsender.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieDBService {
    private List<Movie> movieList;

    public MovieDBService() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("Shrek", 1998));
        movieList.add(new Movie("Matrix", 1997));
        movieList.add(new Movie("Speed", 2001));
        movieList.add(new Movie("Fast and Furious", 2010));
        movieList.add(new Movie("Vikings", 2018));
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void save(Movie movie) {
        movieList.add(movie);
    }
}
