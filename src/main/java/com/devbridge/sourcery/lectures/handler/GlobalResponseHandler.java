package com.devbridge.sourcery.lectures.handler;

import com.devbridge.sourcery.lectures.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalResponseHandler {

  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity handleNullPointer() {
    return ResponseEntity.notFound().build();
  }
}
