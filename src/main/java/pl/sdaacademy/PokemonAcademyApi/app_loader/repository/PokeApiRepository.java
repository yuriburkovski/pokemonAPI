package pl.sdaacademy.PokemonAcademyApi.app_loader.repository;

import org.springframework.web.client.RestTemplate;

public class PokeApiRepository {
    private final String URL = "https://pokeapi.co/api/v2/pokemon?limit=%d&offset=%d";

    private  RestTemplate restTemplate;

    public PokemonResponse getPokemon(int offset, int limit){
        return restTemplate.getForObject(String.format(URL, limit, offset), PokemonResponse.class);
    }

}
