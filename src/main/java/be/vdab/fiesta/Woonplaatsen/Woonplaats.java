package be.vdab.fiesta.Woonplaatsen;

import jakarta.persistence.*;

@Entity
@Table(name = "woonplaatsen")
public class Woonplaats {
    @Id
    private long id;
    private int postcode;
    private String naam;

    protected Woonplaats(){}

    public long getId() {
        return id;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getNaam() {
        return naam;
    }
}
