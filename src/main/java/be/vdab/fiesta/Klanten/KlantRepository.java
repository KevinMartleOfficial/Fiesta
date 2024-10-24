package be.vdab.fiesta.Klanten;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KlantRepository extends JpaRepository<Klant, Long> {

    @EntityGraph(attributePaths = "woonplaats")
    List<Klant> findKlantByFamilienaamContainingIgnoreCaseOrderByFamilienaamAsc(String familienaamBevat);

}
