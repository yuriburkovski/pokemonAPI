package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonDetailsResponse {
    @JsonProperty("abilities")
    private List<Ability> abilityList;
    @JsonProperty("height")
    private int height;
    @JsonProperty("weight")
    private int weight;
    @JsonProperty("types")
    private List<Types> typeList;
    @JsonProperty("sprites")
    private Sprites spritesList;
    @JsonProperty("name")
    private String name;

    public List<Ability> getAbilityList() {
        return abilityList;
    }

    public void setAbilityList(List<Ability> abilityList) {
        this.abilityList = abilityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Types> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Types> typeList) {
        this.typeList = typeList;
    }

    public Sprites getSpritesList() {
        return spritesList;
    }

    public void setSpritesList(Sprites spritesList) {
        this.spritesList = spritesList;
    }
}
