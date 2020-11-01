package pl.sdaacademy.PokemonAcademyApi.registration.service;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
