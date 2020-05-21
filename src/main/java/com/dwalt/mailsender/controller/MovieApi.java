package com.dwalt.mailsender.controller;

import com.dwalt.mailsender.aspect.MailAnnotation;
import com.dwalt.mailsender.model.Movie;
import com.dwalt.mailsender.service.MovieDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieApi {
    private MovieDBService movieDBService;

    @Autowired
    public MovieApi(MovieDBService movieDBService) {
        this.movieDBService = movieDBService;
    }

    @GetMapping
    public List<Movie> get() {
        return movieDBService.getMovieList();
    }

    @PostMapping
    @MailAnnotation
    public void add(@RequestBody Movie movie) {
        movieDBService.save(movie);
    }
}
