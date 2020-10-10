package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.pokeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokeApiDetailsRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public PokeApiDetailsRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PokemonDetailsResponse getPokemonDetails(String urlDetails) {
        return restTemplate.getForObject(urlDetails, PokemonDetailsResponse.class);
    }


}
