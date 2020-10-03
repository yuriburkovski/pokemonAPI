package pl.sdaacademy.PokemonAcademyApi.app_loader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.app_loader.repository.PokemonRepository;

import java.util.List;

@Service
public class PokemonLoaderService {

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonLoaderService(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemon(){
        return pokemonRepository.findAll();
    }

    public Pokemon addPokemon(Pokemon pokemonToAdd){
        pokemonRepository.save(pokemonToAdd);
        return pokemonToAdd;
    }

    public Pokemon deletePokemon(int id) throws EmptyResultDataAccessException{
        pokemonRepository.deleteById(id);
        return pokemonRepository.getOne(id);
    }


}
