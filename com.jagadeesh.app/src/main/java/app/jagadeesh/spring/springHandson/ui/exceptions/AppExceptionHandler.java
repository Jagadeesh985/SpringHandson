package app.jagadeesh.spring.springHandson.ui.exceptions;

import app.jagadeesh.spring.springHandson.ui.model.response.ErrorMessage;
import app.jagadeesh.spring.springHandson.ui.model.response.UserServiceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> anyExceptionHandler(Exception ex, WebRequest request){
        String message = ex.getLocalizedMessage();
        if(message == null) message = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> anyExceptionHandler(NullPointerException ex, WebRequest request){
        String message = ex.getLocalizedMessage();
        if(message == null) message = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {UserServiceException.class})
    public ResponseEntity<Object> anyExceptionHandler(UserServiceException ex, WebRequest request){
        String message = ex.getLocalizedMessage();
        if(message == null) message = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
