package pl.sdaacademy.PokemonAcademyApi.demo.paging;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Test {

    @Id
    private String item;

    public Test(String item) {
        this.item = item;
    }

    public Test() {

    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}