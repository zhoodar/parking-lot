package com.example.parkinglot.web.rest.advice;

import com.example.parkinglot.common.NoFreeSpaceException;
import com.example.parkinglot.web.rest.dto.ErrorBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandleRestAdvice {

    private final static String TAG = ExceptionHandleRestAdvice.class.getName();
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandleRestAdvice.class);


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorBody> commonException(Exception ex) {
        logger.error(TAG, ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorBody("UNHANDLED EXCEPTION LOGGED DURING REQUEST"));
    }

    @ExceptionHandler(NoFreeSpaceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorBody> fileDidNotLoadException(NoFreeSpaceException ex) {
        logger.error(TAG, ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorBody(ex.getLocalizedMessage()));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorBody> MethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error(TAG, ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorBody(ex.getLocalizedMessage()));
    }

}
