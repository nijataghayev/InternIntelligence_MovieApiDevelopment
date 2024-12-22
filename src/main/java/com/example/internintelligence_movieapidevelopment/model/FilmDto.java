package com.example.internintelligence_movieapidevelopment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: nijataghayev
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
    @Schema(description = "Unique ID of the film", example = "1")
    private Long id;

    @Schema(description = "Title of the film", example = "Inception")
    private String title;

    @Schema (description = "Brief description of the film", example = "A mind-bending thriller")
    private String description;

    @Schema (description = "Release date of the film", example = "2010-07-16")
    private String releaseDate;

    @Schema(description = "IMDB rating of the film", example = "8.8")
    private Double imdbRating;

    @Schema(description = "Genre details associated with the film")
    private GenreDto genre;
}
