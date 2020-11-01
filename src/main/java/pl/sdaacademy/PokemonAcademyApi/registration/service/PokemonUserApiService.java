package pl.sdaacademy.PokemonAcademyApi.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.registration.repository.PokemonApiUser;
import pl.sdaacademy.PokemonAcademyApi.registration.repository.PokemonApiUserRepository;

@Service
public class PokemonUserApiService {

    private final PasswordEncoder passwordEncoder;
    private final PokemonApiUserRepository pokemonApiUserRepository;
    @Autowired
    public PokemonUserApiService(PasswordEncoder passwordEncoder, PokemonApiUserRepository pokemonApiUserRepository){
        this.passwordEncoder = passwordEncoder;
        this.pokemonApiUserRepository = pokemonApiUserRepository;
    }
    public PokemonApiUser getPokemonApiUserByLogin(String login){
        return pokemonApiUserRepository.findById(login)
                .orElseThrow(() -> {
                    throw new UserNotFoundException(String.format("User with %s could not found in DB!", login));
                });
    }
    public PokemonApiUserDto addUser(PokemonApiUser pokemonApiUser){
        pokemonApiUserRepository.findById(pokemonApiUser.getLogin()).ifPresent((user)->{
            throw new UserAlreadyExistException(String.format("User with %s is already exist in DB!",
                    pokemonApiUser.getLogin()));
        });
        pokemonApiUser.setPassword(passwordEncoder.encode(pokemonApiUser.getPassword()));
        PokemonApiUser addedUser = pokemonApiUserRepository.save(pokemonApiUser);
        return new PokemonApiUserDto(addedUser.getLogin());
    }
}
