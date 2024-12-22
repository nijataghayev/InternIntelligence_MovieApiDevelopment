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
public class UserDto {
    @Schema(description = "Unique ID of the user", example = "1")
    private Long id;

    @Schema(description = "User's username", example = "nijat_aghayev")
    private String username;

    @Schema(description = "User's first name", example = "Nijat")
    private String firstName;

    @Schema(description = "User's last name", example = "Aghayev")
    private String lastName;

    @Schema(description = "User's email", example = "nijataghayev99@gmail.com")
    private String email;

    @Schema(description = "User's password", example = "NT12345!")
    private String password;
}
