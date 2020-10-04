package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.pokeapi.ability;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ability {
    @JsonProperty("ability")
    private AbilityDetails abilityDetails;

    public AbilityDetails getAbility() {
        return abilityDetails;
    }

    public void setAbility(AbilityDetails abilityDetails) {
        this.abilityDetails = abilityDetails;
    }
}
