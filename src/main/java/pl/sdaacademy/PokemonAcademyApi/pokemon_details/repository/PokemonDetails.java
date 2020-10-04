package pl.sdaacademy.PokemonAcademyApi.pokemon_details.repository;

import java.util.List;


public class PokemonDetails {

    private List<String> abilities;
    private List<String> types;
    private int height;
    private int weight;
    private String imageUrl;
    private String name;

    public PokemonDetails() {
    }

    public PokemonDetails(String name, List<String> abilities, List<String> types, int height, int weight, String imageUrl) {
        this.name = name;
        this.abilities = abilities;
        this.types = types;
        this.height = height;
        this.weight = weight;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "PokemonDetails{" +
                "name='" + name + '\'' +
                ", abilities=" + abilities +
                ", types=" + types +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
