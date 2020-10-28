package pl.sdaacademy.PokemonAcademyApi.app_loader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokeApiRepository;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonResponse;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonResult;
import pl.sdaacademy.PokemonAcademyApi.common.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.common.repository.PokemonRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonLoaderService {

    private final PokemonRepository pokemonRepository;
    private final PokeApiRepository pokeApiRepository;
    private final PokemonTransformer pokemonTransformer;
    private int startOffset;
    private final int limit;

    @Autowired
    public PokemonLoaderService(PokemonRepository pokemonRepository,
                                PokeApiRepository pokeApiRepository,
                                PokemonTransformer pokemonTransformer
            , @Value("${pokeapi.start_offset}") int startOffset
            , @Value("${pokeapi.limit}") int limit) {
        this.pokemonRepository = pokemonRepository;
        this.pokeApiRepository = pokeApiRepository;
        this.pokemonTransformer = pokemonTransformer;
        this.startOffset = startOffset;
        this.limit = limit;
    }

    @PostConstruct
    public void getPokemonList() {
        PokemonResponse pokemonResponse;
        List<PokemonResult> pokemonResults = new ArrayList<>();

        do {
            pokemonResponse = pokeApiRepository.getPokemon(startOffset, limit);
            pokemonResults.addAll(pokemonResponse.getResults());
            startOffset += limit;
        } while (pokemonResponse.getNext() != null);

        List<Pokemon> pokemons = pokemonTransformer.transformToPokemonList(pokemonResults);
        pokemonRepository.saveAll(pokemons);
    }

}
