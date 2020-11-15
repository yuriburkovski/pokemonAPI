package pl.sdaacademy.PokemonAcademyApi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdaacademy.PokemonAcademyApi.registration.repository.PokemonApiUser;
import pl.sdaacademy.PokemonAcademyApi.registration.service.PokemonUserApiService;

@Component
public class CommandLineAppStartRunner implements CommandLineRunner {
    private final PokemonUserApiService pokemonUserApiService;

    @Autowired
    public CommandLineAppStartRunner(PokemonUserApiService pokemonUserApiService) {
        this.pokemonUserApiService = pokemonUserApiService;
    }

    @Override
    public void run(String... args) throws Exception {
        PokemonApiUser user = new PokemonApiUser("admin", "test");
        pokemonUserApiService.addUser(user);
    }
}
