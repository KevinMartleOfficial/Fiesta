package be.vdab.fiesta.Vestigingen;

import be.vdab.fiesta.Woonplaatsen.Woonplaats;
import jakarta.persistence.*;

@Entity
@Table(name = "vestigingen")
public class Vestiging {
    @Id
    private long id;
    private String straat;
    private String huisnummer;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "woonplaatsId")
    private Woonplaats woonplaats;

    protected Vestiging(){}

    public long getId() {
        return id;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public Woonplaats getWoonplaats() {
        return woonplaats;
    }
}
