package com.example.internintelligence_movieapidevelopment.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: nijataghayev
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto {

    @Schema(description = "Unique ID of the genre", example = "1")
    private Long id;

    @Schema(description = "Name of the genre", example = "Action")
    private String name;
}
