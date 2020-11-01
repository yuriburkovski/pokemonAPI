package pl.sdaacademy.PokemonAcademyApi.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonApiUserRepository extends JpaRepository<PokemonApiUser, String> {

}
