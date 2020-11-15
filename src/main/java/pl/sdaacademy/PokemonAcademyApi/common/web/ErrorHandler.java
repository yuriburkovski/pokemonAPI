package pl.sdaacademy.PokemonAcademyApi.common.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sdaacademy.PokemonAcademyApi.common.service.NoPokemonFoundException;
import pl.sdaacademy.PokemonAcademyApi.registration.service.UserAlreadyExistException;
import pl.sdaacademy.PokemonAcademyApi.registration.service.UserNotFoundException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = NoPokemonFoundException.class)
    public ResponseEntity<Object> notFoundException(NoPokemonFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<Object> userAlreadyExistException(UserAlreadyExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Object> userNotFoundException(UserNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
