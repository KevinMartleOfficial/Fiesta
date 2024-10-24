package be.vdab.fiesta.Verhuringen;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VerhuringRepository extends JpaRepository<Verhuring, Long> {
    @EntityGraph(attributePaths = {"klant", "vestiging", "materiaal", "vestiging.woonplaats"})
    Optional<Verhuring> findVerhuringById(long id);
}
