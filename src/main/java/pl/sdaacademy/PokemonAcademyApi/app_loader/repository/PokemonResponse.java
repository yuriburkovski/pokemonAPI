package pl.sdaacademy.PokemonAcademyApi.app_loader.repository;

import java.util.List;

public class PokemonResponse {

    private String next;
    private List<PokemonResult> results;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<PokemonResult> getResults() {
        return results;
    }

    public void setResults(List<PokemonResult> results) {
        this.results = results;
    }
}
