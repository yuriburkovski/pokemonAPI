package pl.sdaacademy.PokemonAcademyApi.registration.service;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);

    }
}
