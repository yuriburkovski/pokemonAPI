package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository.pokeapi.type;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Types {
    @JsonProperty("type")
    private TypeDetails typeDetails;

    public TypeDetails getType() {
        return typeDetails;
    }

    public void setType(TypeDetails typeDetails) {
        this.typeDetails = typeDetails;
    }
}
