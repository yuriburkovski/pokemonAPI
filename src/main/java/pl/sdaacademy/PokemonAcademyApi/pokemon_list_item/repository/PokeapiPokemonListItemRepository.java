package pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokeapiPokemonListItemRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public PokeapiPokemonListItemRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PokemonListItemResponse getPokemonListItemResponse(String urlDetails) {
        return restTemplate.getForObject(urlDetails, PokemonListItemResponse.class);
    }
}
