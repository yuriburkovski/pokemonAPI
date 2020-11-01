package pl.sdaacademy.PokemonAcademyApi.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.sdaacademy.PokemonAcademyApi.registration.repository.PokemonApiUser;
import pl.sdaacademy.PokemonAcademyApi.registration.repository.PokemonApiUserRepository;

import java.util.Collections;

@Component
public class PokemonApiUserProvider implements UserDetailsService {
    private final PokemonApiUserRepository pokemonApiUserRepository;

    @Autowired
    public PokemonApiUserProvider(PokemonApiUserRepository pokemonApiUserRepository) {
        this.pokemonApiUserRepository = pokemonApiUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        PokemonApiUser pokemonApiUser = pokemonApiUserRepository.findById(userName)
                .<UsernameNotFoundException>orElseThrow(() -> {
                    throw new UsernameNotFoundException(userName);
                });
        return new User(pokemonApiUser.getLogin(), pokemonApiUser.getPassword(), Collections.emptyList());
    }
}
