package pl.sdaacademy.PokemonAcademyApi.pokemon_details.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.service.PokemonDetailService;

@RequestMapping("/pokemons")
@RestController
public class PokemonController {

    public final PokemonDetailService pokemonDetailService;

    @Autowired
    public PokemonController(PokemonDetailService pokemonDetailService) {
        this.pokemonDetailService = pokemonDetailService;
    }

    @GetMapping("{name}")
    public PokemonDetails getPokemonDetails(@PathVariable String name) {
        return pokemonDetailService.getPokemonDetails(name);
    }


}
