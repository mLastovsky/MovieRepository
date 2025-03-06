package com.mlastovsky.service;

import com.mlastovsky.exception.DirectorNotFoundException;
import com.mlastovsky.model.Director;
import com.mlastovsky.repository.DirectorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class DirectorService {

    private final DirectorRepository directorRepository;

    public Iterable<Director> getAllDirectors() {
        log.debug("fetching All Directors");
        return directorRepository.findAll();
    }

    public Director getDirectorById(Long id) throws DirectorNotFoundException {
        log.debug("fetching Director with id {}", id);
        return directorRepository.findById(id)
                .orElseThrow(DirectorNotFoundException::new);
    }

    public void addDirector(Director director) {
        log.debug("adding Director with firstname {}", director.getFirstname());
        directorRepository.save(director);
    }

    public void deleteDirector(Long id) throws DirectorNotFoundException {
        log.debug("deleting Director with id {}", id);
        var director = this.getDirectorById(id);
        directorRepository.delete(director);
    }
}
