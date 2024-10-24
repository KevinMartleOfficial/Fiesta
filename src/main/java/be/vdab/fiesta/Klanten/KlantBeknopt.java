package be.vdab.fiesta.Klanten;

public record KlantBeknopt(long id,
                           String voornaam,
                           String familienaam,
                           String straat,
                           String huisnummer,
                           int postcode,
                           String woonplaats) {
    KlantBeknopt(Klant klant){
        this(
                klant.getId(),
                klant.getVoornaam(),
                klant.getFamilienaam(),
                klant.getStraat(),
                klant.getHuisnummer(),
                klant.getWoonplaats().getPostcode(),
                klant.getWoonplaats().getNaam());
    }

}
