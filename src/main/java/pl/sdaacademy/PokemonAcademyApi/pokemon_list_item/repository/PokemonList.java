package pl.sdaacademy.PokemonAcademyApi.pokemon_list_item.repository;

import java.util.List;

public class PokemonList {
    private long count;
    private String next;
    private String prev;

    private List<PokemonListItem> results;

    public PokemonList(long count, String next, String prev, List<PokemonListItem> results) {
        this.count = count;
        this.next = next;
        this.prev = prev;
        this.results = results;
    }

    public PokemonList() {

    }

    public long getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public List<PokemonListItem> getResults() {
        return results;
    }

    public void setResults(List<PokemonListItem> results) {
        this.results = results;
    }
}
