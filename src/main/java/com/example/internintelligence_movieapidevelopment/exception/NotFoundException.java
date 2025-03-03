package com.example.internintelligence_movieapidevelopment.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: nijataghayev
 */

@Getter
@Setter
public class NotFoundException extends RuntimeException {
    private String message;
    private String code;

    public NotFoundException(String code, String message) {
        super(code);
        this.code = code;
        this.message = message;
    }
}
