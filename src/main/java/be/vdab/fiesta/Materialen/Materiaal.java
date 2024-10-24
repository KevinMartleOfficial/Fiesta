package be.vdab.fiesta.Materialen;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import java.math.BigDecimal;

@Entity
@Table(name = "materiaal")
public class Materiaal {
    @Id
    private long id;
    private String naam;
    private BigDecimal dagPrijs;
    private int opTijdTerugGebracht;
    private int teLaatTerugGebracht;
    @Version
    private long versie;

    protected Materiaal(){}

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getDagPrijs() {
        return dagPrijs;
    }

    public int getOpTijdTerugGebracht() {
        return opTijdTerugGebracht;
    }

    public int getTeLaatTerugGebracht() {
        return teLaatTerugGebracht;
    }

    public long getVersie() {
        return versie;
    }

    public void setOpTijdTerugGebracht(){
        opTijdTerugGebracht++;
    }
    public void setTeLaatTerugGebracht(){
        teLaatTerugGebracht++;
    }
}
