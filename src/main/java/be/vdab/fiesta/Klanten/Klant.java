package be.vdab.fiesta.Klanten;

import be.vdab.fiesta.Woonplaatsen.Woonplaats;
import jakarta.persistence.*;

@Entity
@Table(name = "klanten")
public class Klant {
    @Id
    private long id;
    private String familienaam;
    private String voornaam;
    private String straat;
    private String huisnummer;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "woonplaatsId")
    private Woonplaats woonplaats;
    private int opTijdTerugGebracht;
    private int teLaatTerugGebracht;
    @Version
    private long versie;

    public Klant(long id, String familienaam, String voornaam, String straat, String huisnummer, Woonplaats woonplaats, int opTijdTerugGebracht, int teLaatTerugGebracht) {
        this.id = id;
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.woonplaats = woonplaats;
        this.opTijdTerugGebracht = opTijdTerugGebracht;
        this.teLaatTerugGebracht = teLaatTerugGebracht;
    }

    protected Klant(){};

    public long getId() {
        return id;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public String getVoornaam() {
        return voornaam;
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
