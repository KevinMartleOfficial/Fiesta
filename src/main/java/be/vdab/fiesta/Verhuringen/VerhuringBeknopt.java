package be.vdab.fiesta.Verhuringen;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VerhuringBeknopt(long id,
                               String voornaam,
                               String familienaam,
                               String vestigingStraat,
                               String vestigingHuisnummer,
                               String vestigingWoonplaats,
                               String materiaal,
                               LocalDate verhuurdOp,
                               int aantalDagen,
                               LocalDate teruggebrachtOp,
                               BigDecimal boete) {
    public VerhuringBeknopt(Verhuring verhuring){
        this(verhuring.getId(),
                verhuring.getKlant().getVoornaam(),
                verhuring.getKlant().getFamilienaam(),
                verhuring.getVestiging().getStraat(),
                verhuring.getVestiging().getHuisnummer(),
                verhuring.getVestiging().getWoonplaats().getNaam(),
                verhuring.getMateriaal().getNaam(),
                verhuring.getVerhuurdOp(),
                verhuring.getAantalDagen(),
                verhuring.getTerugGebrachtOp() == null ? LocalDate.now(): verhuring.getTerugGebrachtOp(),
                verhuring.berekenBoete()
                );
    }

}
