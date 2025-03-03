package com.mlastovsky.controller;

import com.mlastovsky.exception.MovieNotFoundException;
import com.mlastovsky.model.Movie;
import com.mlastovsky.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<Iterable<Movie>> getAllMovies() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) throws MovieNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(movieService.getMovieById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) throws MovieNotFoundException {
        movieService.deleteMovie(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
