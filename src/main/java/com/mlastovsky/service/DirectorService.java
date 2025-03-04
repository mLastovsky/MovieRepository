package com.mlastovsky.service;

import com.mlastovsky.exception.DirectorNotFoundException;
import com.mlastovsky.model.Director;
import com.mlastovsky.repository.DirectorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;

    public Iterable<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Director getDirectorById(Long id) throws DirectorNotFoundException {
        return directorRepository.findById(id)
                .orElseThrow(DirectorNotFoundException::new);
    }

    public void addDirector(Director director) {
        directorRepository.save(director);
    }

    public void deleteDirector(Long id) throws DirectorNotFoundException {
        var director = directorRepository.findById(id);
        director.ifPresent(directorRepository::delete);
    }
}
