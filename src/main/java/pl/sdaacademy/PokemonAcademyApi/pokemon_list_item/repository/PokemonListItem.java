package pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository;

public class PokemonListItem {
    private String name;
    private String imageUrl;
    private int level;

    public PokemonListItem() {

    }

    public PokemonListItem(String name, String imageUrl, int level) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
