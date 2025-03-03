package com.mlastovsky.service;

import com.mlastovsky.exception.MovieNotFoundException;
import com.mlastovsky.model.Movie;
import com.mlastovsky.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) throws MovieNotFoundException {
        return movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovie(Long id) throws MovieNotFoundException {
        var movie = movieRepository.findById(id);
        movie.ifPresent(movieRepository::delete);
    }
}
