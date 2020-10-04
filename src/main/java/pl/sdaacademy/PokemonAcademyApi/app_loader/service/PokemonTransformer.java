package pl.sdaacademy.PokemonAcademyApi.app_loader.service;

import org.springframework.stereotype.Component;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonResult;
import pl.sdaacademy.PokemonAcademyApi.common.repository.Pokemon;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PokemonTransformer {

    public Pokemon transformToPokemon(PokemonResult pokemonResult) {
        String[] urlData = pokemonResult.getUrl().split("/");
        int id = Integer.parseInt(urlData[urlData.length - 1]);
        return new Pokemon(id, pokemonResult.getName(), pokemonResult.getUrl());
    }

    public List<Pokemon> transformToPokemonList(List<PokemonResult> pokemonResults) {
        return pokemonResults.stream()
                .filter(pokemonResult -> pokemonResult != null)
                .map(this::transformToPokemon)
                .collect(Collectors.toList());
    }
}
