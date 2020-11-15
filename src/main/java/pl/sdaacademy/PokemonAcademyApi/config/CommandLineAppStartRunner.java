package pl.sdaacademy.PokemonAcademyApi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdaacademy.PokemonAcademyApi.registration.repository.PokemonApiUser;
import pl.sdaacademy.PokemonAcademyApi.registration.repository.PokemonApiUserRepository;

@Component
public class CommandLineAppStartRunner implements CommandLineRunner {
    private PokemonApiUserRepository pokemonApiUserRepository;

    @Autowired
    public CommandLineAppStartRunner(PokemonApiUserRepository pokemonApiUserRepository) {
        this.pokemonApiUserRepository = pokemonApiUserRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        PokemonApiUser user = new PokemonApiUser("admin", "test");
        pokemonApiUserRepository.save(user);
    }
}
