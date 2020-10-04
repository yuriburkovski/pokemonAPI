package pl.sdaacademy.PokemonAcademyApi.pokemon_details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.common.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.common.repository.PokemonRepository;
import pl.sdaacademy.PokemonAcademyApi.common.service.NoPokemonFoundException;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.pokeapi.PokemonDetailsRepository;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.pokeapi.PokemonDetailsResponse;

@Service
public class PokemonDetailService {

    private final PokemonRepository pokemonRepository;
    private final PokemonDetailsRepository pokemonDetailsRepository;
    private final PokemonDetailsTransformer pokemonDetailsTransformer;

    @Autowired
    public PokemonDetailService(PokemonRepository pokemonRepository,
                                PokemonDetailsRepository pokemonDetailsRepository,
                                PokemonDetailsTransformer pokemonDetailsTransformer) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonDetailsRepository = pokemonDetailsRepository;
        this.pokemonDetailsTransformer = pokemonDetailsTransformer;
    }

    public PokemonDetails getPokemonDetails(String name) {
        Pokemon pokemonTemp = pokemonRepository.findByName(name).orElseThrow(() -> {
            throw new NoPokemonFoundException(name);
        });
        PokemonDetailsResponse response = pokemonDetailsRepository
                .getPokemonDetails(pokemonTemp.getUrl());
        return pokemonDetailsTransformer.transformToPokemonDetails(response);
    }

}
