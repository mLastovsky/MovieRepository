package com.mlastovsky.controller;

import com.mlastovsky.exception.DirectorNotFoundException;
import com.mlastovsky.model.Director;
import com.mlastovsky.service.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/directors")
@AllArgsConstructor
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping
    public ResponseEntity<Iterable<Director>> getAllDirectors() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(directorService.getAllDirectors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) throws DirectorNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(directorService.getDirectorById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addDirector(@RequestBody Director director) {
        directorService.addDirector(director);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable Long id) throws DirectorNotFoundException {
        directorService.deleteDirector(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}

