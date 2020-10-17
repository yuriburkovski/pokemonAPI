package pl.sdaacademy.PokemonAcademyApi.pokemon_details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.common.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.common.repository.PokemonRepository;
import pl.sdaacademy.PokemonAcademyApi.common.service.NoPokemonFoundException;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetailsRepository;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.pokeapi.PokeApiDetailsRepository;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.pokeapi.PokemonDetailsResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonDetailService {

    private final PokemonRepository pokemonRepository;
    private final PokeApiDetailsRepository pokeApiDetailsRepository;
    private final PokemonDetailsTransformer pokemonDetailsTransformer;
    private final PokemonDetailsRepository pokemonDetailsRepository;

    @Autowired
    public PokemonDetailService(PokemonRepository pokemonRepository,
                                PokeApiDetailsRepository pokeApiDetailsRepository,
                                PokemonDetailsTransformer pokemonDetailsTransformer,
                                PokemonDetailsRepository pokemonDetailsRepository) {
        this.pokemonRepository = pokemonRepository;
        this.pokeApiDetailsRepository = pokeApiDetailsRepository;
        this.pokemonDetailsTransformer = pokemonDetailsTransformer;
        this.pokemonDetailsRepository = pokemonDetailsRepository;
    }

//    public PokemonDetails getPokemonDetails(String name) {
//        Pokemon pokemonTemp = pokemonRepository.findByName(name).orElseThrow(() -> {
//            throw new NoPokemonFoundException(name);
//        });
//        return providePokemonDetails(pokemonTemp);
//    }

    public List<PokemonDetails> getPokemonDetailsList(List<String> names) {
        List<PokemonDetails> pokemonsList = names.stream()
                .map(pokemonRepository::findByName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(this::providePokemonDetails)
                .collect(Collectors.toList());
        pokemonsList.forEach(this::savePokemonDetails);
        return pokemonsList;
    }

    private void savePokemonDetails(PokemonDetails details) {
        pokemonDetailsRepository.findById(details.getName())
                .orElseGet(() -> pokemonDetailsRepository.save(details));
    }

    private PokemonDetails providePokemonDetails(Pokemon pokemon) {
        return pokemonDetailsRepository
                .findById(pokemon.getName())
                .orElseGet(() -> {
                    PokemonDetails pokemonDetails = getPokemonDetailsFromApi(pokemon.getUrl());
                    savePokemonDetails(pokemonDetails);
                    return pokemonDetails;
                });
    }

    private PokemonDetails getPokemonDetailsFromApi(String url) {
        PokemonDetailsResponse response = pokeApiDetailsRepository
                .getPokemonDetails(url);
        return pokemonDetailsTransformer.transformToPokemonDetails(response);
    }
}
