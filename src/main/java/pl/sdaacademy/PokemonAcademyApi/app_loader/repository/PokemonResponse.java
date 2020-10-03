package pl.sdaacademy.PokemonAcademyApi.app_loader.repository;

import java.lang.reflect.Array;
import java.util.List;

public class PokemonResponse {

    private String next;
    private List<Pokemon> results;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
