package pl.sdaacademy.PokemonAcademyApi.common.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sdaacademy.PokemonAcademyApi.common.service.NoPokemonFoundException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PokemonRepositoryTest {
    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void when_no_data_return_empty_list(){
        //given
        //when
        List<Pokemon> pokemons = pokemonRepository.findAll();
        //then
        assertEquals(0, pokemons.size());
    }

    @Test
    public void when_find_by_name_return_pokemon_with_provided_name(){
        //given
        Pokemon pokemon = new Pokemon(1, "Pikachu", "https://pikachu");
        //when
        pokemonRepository.save(pokemon);
        Pokemon savedPokemon = pokemonRepository.findByName("Pikachu").<NoPokemonFoundException>orElseThrow(() -> {
            throw new NoPokemonFoundException("Pikachu");
        });
        //then
        assertEquals(pokemon.getId(), savedPokemon.getId());
    }
    @Test
    public void when_find_by_name_which_is_not_exist_in_DB_it_does_not_return(){
        //given
        Pokemon pokemon = new Pokemon(1, "Pikachu", "https://pikachu");
        //when
        pokemonRepository.save(pokemon);
        Optional<Pokemon> searchPokemon = pokemonRepository.findByName("bulbasaur");
        //then
        assertEquals(false ,searchPokemon.isPresent());
    }
}