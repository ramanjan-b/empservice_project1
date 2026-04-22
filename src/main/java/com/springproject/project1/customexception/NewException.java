package com.springproject.project1.customexception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;


@Builder
@AllArgsConstructor
public class NewException extends Exception{
    public NewException(String message) {
        super(message);
    }

    public NewException(String message, Throwable cause) {
        super(message, cause);
    }
}
