package pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.service;

import org.springframework.stereotype.Component;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository.PokemonListItem;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository.PokemonListItemResponse;

@Component
public class PokemonListItemTransformer {

    public PokemonListItem transformToPokemonListItem(PokemonListItemResponse pokemonListItemResponse) {
        String name = pokemonListItemResponse.getName();
        int level = pokemonListItemResponse.getBaseExperience();
        String imageUrl = pokemonListItemResponse.getImages().getFrontDefault();
        return new PokemonListItem(name, imageUrl, level);
    }
}
