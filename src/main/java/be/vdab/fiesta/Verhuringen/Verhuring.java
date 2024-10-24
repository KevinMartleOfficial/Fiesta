package be.vdab.fiesta.Verhuringen;

import be.vdab.fiesta.Klanten.Klant;
import be.vdab.fiesta.Materialen.Materiaal;
import be.vdab.fiesta.Vestigingen.Vestiging;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "verhuringen")
public class Verhuring {
    @Id
    private long id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "klantId")
    private Klant klant;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "vestigingId")
    private Vestiging vestiging;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "materiaalId")
    private Materiaal materiaal;
    private LocalDate verhuurdOp;
    private int aantalDagen;
    private LocalDate terugGebrachtOp;
    @Version
    private long versie;

    protected Verhuring(){}

    public long getId() {
        return id;
    }

    public Klant getKlant() {
        return klant;
    }

    public Vestiging getVestiging() {
        return vestiging;
    }

    public Materiaal getMateriaal() {
        return materiaal;
    }

    public LocalDate getVerhuurdOp() {
        return verhuurdOp;
    }

    public int getAantalDagen() {
        return aantalDagen;
    }

    public LocalDate getTerugGebrachtOp() {
        return terugGebrachtOp;
    }

    public long getVersie() {
        return versie;
    }

    public BigDecimal berekenBoete(){
        if(verhuurdOp.plusDays(aantalDagen).isAfter(terugGebrachtOp ==null ? LocalDate.now() : terugGebrachtOp)){
            return BigDecimal.ZERO;
        }
        else {
            return materiaal.getDagPrijs().multiply(BigDecimal.valueOf(ChronoUnit.DAYS.between(verhuurdOp.plusDays(aantalDagen), terugGebrachtOp == null ? LocalDate.now() : terugGebrachtOp)));
        }
    }

    public void setTerugGebrachtOp(){
        this.terugGebrachtOp = LocalDate.now();
    }
}
