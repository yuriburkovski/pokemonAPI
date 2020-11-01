package pl.sdaacademy.PokemonAcademyApi.common.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.PokemonDetails;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.service.PokemonDetailService;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository.PokemonList;
import pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.service.PokemonListService;
import pl.sdaacademy.PokemonAcademyApi.registration.repository.PokemonApiUser;
import pl.sdaacademy.PokemonAcademyApi.registration.service.PokemonApiUserDto;
import pl.sdaacademy.PokemonAcademyApi.registration.service.PokemonUserApiService;

import java.util.List;

@RequestMapping("/pokemons")
@RestController
public class PokemonController {

    public final PokemonDetailService pokemonDetailService;
    private final PokemonListService pokemonListService;
    private final PokemonUserApiService pokemonUserApiService;

    @Autowired
    public PokemonController(PokemonDetailService pokemonDetailService,
                             PokemonListService pokemonListService, PokemonUserApiService pokemonUserApiService) {
        this.pokemonDetailService = pokemonDetailService;
        this.pokemonListService = pokemonListService;
        this.pokemonUserApiService = pokemonUserApiService;
    }

    @GetMapping("{name}")
    @CrossOrigin
    public PokemonDetails getPokemonDetails(@PathVariable String name) {
        return pokemonDetailService.getPokemonDetails(name);
    }

    @GetMapping()
    @CrossOrigin
    public List<PokemonDetails> getPokemonDetailsList(@RequestParam List<String> names) {
        return pokemonDetailService.getPokemonDetailsList(names);
    }

    @GetMapping("/list")
    @CrossOrigin
    public PokemonList getPokemonsList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return pokemonListService.getPokemonListItem(page, size);
    }

    @PostMapping("/signup")
    @CrossOrigin
    public PokemonApiUserDto addUser(@RequestBody PokemonApiUser pokemonApiUser) {
        return pokemonUserApiService.addUser(pokemonApiUser);
    }
}
