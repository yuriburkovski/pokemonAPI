package pl.sdaacademy.PokemonAcademyApi.pokemon_details.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.service.PokemonDetailService;

import java.util.List;

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

    @GetMapping()
    public List<PokemonDetails> getPokemonDetailsList(@RequestParam List<String> names) {
        return pokemonDetailService.getPokemonDetailsList(names);
    }


}
