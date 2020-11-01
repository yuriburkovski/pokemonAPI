package pl.sdaacademy.PokemonAcademyApi.registration.service;

public class PokemonApiUserDto {
    private String userName;

    public PokemonApiUserDto() {
    }

    public PokemonApiUserDto(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
