package pl.sdaacademy.PokemonAcademyApi.pokemon_details.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.service.PokemonDetailService;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository.PokemonList;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository.PokemonListItem;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.service.PokemonListService;

import java.util.List;

@RequestMapping("/pokemons")
@RestController
public class PokemonController {

    public final PokemonDetailService pokemonDetailService;
    private final PokemonListService pokemonListService;

    @Autowired
    public PokemonController(PokemonDetailService pokemonDetailService,
                             PokemonListService pokemonListService) {
        this.pokemonDetailService = pokemonDetailService;
        this.pokemonListService = pokemonListService;
    }

    @GetMapping("{name}")
    public PokemonDetails getPokemonDetails(@PathVariable String name) {
        return pokemonDetailService.getPokemonDetails(name);
    }

    @GetMapping()
    public List<PokemonDetails> getPokemonDetailsList(@RequestParam List<String> names) {
        return pokemonDetailService.getPokemonDetailsList(names);
    }

    @GetMapping("/list")
    public PokemonList getPokemonsList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return pokemonListService.getPokemonListItem(page, size);
    }

}
