package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonDetailsRepository extends JpaRepository<PokemonDetails, String> {

    PokemonDetails save(PokemonDetails pokemonDetails);
}
