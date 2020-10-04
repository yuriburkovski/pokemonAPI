package pl.sdaacademy.PokemonAcademyApi.pokemon_details.service;

public class NoPokemonFoundException extends RuntimeException{
    public NoPokemonFoundException(String pokemonName){
        super(String.format("No pokemon %s found!", pokemonName));
    }
}
