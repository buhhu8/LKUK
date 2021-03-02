package org.lk.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<AwesomeException> handleValidationException(ValidationException ex) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fileName = Exception.class.getName();
        String exception = ex.getMessage();
        

        return new ResponseEntity<>(new AwesomeException(timestamp.getTime(), HttpStatus.BAD_REQUEST.toString(), exception, fileName, ex.toString()), HttpStatus.BAD_REQUEST);
    }

    @Data
    @AllArgsConstructor
    private static class AwesomeException {
        private Long timestamp;
        private String statusCode;
        private String message;
        private String fileName;
        private String exceptionMessage;

    }


}
