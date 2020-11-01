package pl.sdaacademy.PokemonAcademyApi.registration.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PokemonApiUser {
    @Id
    private String login;
    private String password;

    public PokemonApiUser() {
    }

    public PokemonApiUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
