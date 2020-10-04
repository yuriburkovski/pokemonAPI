package pl.sdaacademy.PokemonAcademyApi.pokemon_details.service;

import org.springframework.stereotype.Component;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.pokeapi.PokemonDetailsResponse;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PokemonDetailsTransformer {
    public PokemonDetails transformToPokemonDetails(PokemonDetailsResponse pokemonDetailsResponse) {
        String name = pokemonDetailsResponse.getName();
        int height = pokemonDetailsResponse.getHeight();
        int weight = pokemonDetailsResponse.getWeight();
        String imageUrl = pokemonDetailsResponse
                .getSpritesList()
                .getOtherList()
                .getOficialArtWorkList()
                .getImageUrl();
        List<String> types = pokemonDetailsResponse
                .getTypeList()
                .stream()
                .map(type -> type.getType().getName())
                .collect(Collectors.toList());
        List<String> abilities = pokemonDetailsResponse
                .getAbilityList()
                .stream()
                .map(ability -> ability.getAbility().getName())
                .collect(Collectors.toList());
        return new PokemonDetails(name, abilities, types, height, weight, imageUrl);
    }
}
