package com.praveen.taskManager.error;

import com.praveen.taskManager.dto.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleErrors(Exception e) {
        if (e instanceof ParseException) {

            return ResponseEntity.badRequest().body(new ErrorResponseDTO("Invalid date format"));
        }
        e.printStackTrace();
        return ResponseEntity.internalServerError().body(new ErrorResponseDTO("Internal Server Error"));
    }
}
