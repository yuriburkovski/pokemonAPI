package pl.sdaacademy.PokemonAcademyApi.app_loader.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokeApiRepository {
    private final String url;

    private final  RestTemplate restTemplate;

    @Autowired
    public PokeApiRepository(RestTemplate restTemplate, @Value("${pokeapi.url}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public PokemonResponse getPokemon(int offset, int limit) {
        return restTemplate.getForObject(String.format(url, limit, offset), PokemonResponse.class);
    }

}
