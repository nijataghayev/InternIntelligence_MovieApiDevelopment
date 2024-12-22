package com.example.internintelligence_movieapidevelopment.controller;

import com.example.internintelligence_movieapidevelopment.model.GenreDto;
import com.example.internintelligence_movieapidevelopment.service.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: nijataghayev
 */

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping
    @Operation(summary = "Add a new genre", description = "Adds a new genre to the system.")
    public void addGenre(@RequestBody GenreDto genreDto) {
        genreService.addGenre(genreDto);
    }

    @GetMapping
    @Operation(summary = "Get all genres", description = "Retrieves a list of all genres available in the system.")
    public List<GenreDto> getAllGenres() {
        return genreService.getAllGenres();
    }
}
