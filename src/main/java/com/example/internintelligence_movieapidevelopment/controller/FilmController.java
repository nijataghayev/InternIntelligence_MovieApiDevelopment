package com.example.internintelligence_movieapidevelopment.controller;

import com.example.internintelligence_movieapidevelopment.model.FilmDto;
import com.example.internintelligence_movieapidevelopment.service.FilmService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: nijataghayev
 */

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;

    @PostMapping
    @Operation(summary = "Add a new film", description = "Adds a new film to the system.")
    public void addFilm(@RequestBody FilmDto filmDto) {
        filmService.addFilm(filmDto);
    }

    @Operation(summary = "Get films by genre", description = "Retrieves a list of films by the given genre ID.")
    @GetMapping("/genre/{genreId}")
    public List<FilmDto> getAllFilmsByGenre(@PathVariable Long genreId) {
        return filmService.getFilmsByGenre(genreId);
    }

    @Operation(summary = "Find film by title", description = "Finds a film by its title.")
    @GetMapping("/title/{title}")
    public FilmDto findByTitle(@PathVariable String title) {
        return filmService.findByTitle(title);
    }
}
