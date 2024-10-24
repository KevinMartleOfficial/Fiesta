package be.vdab.fiesta.Klanten;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class KlantService {
    private final KlantRepository klantRepository;

    public KlantService(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    List<Klant>findKlantByFamilienaamContaining(String familienaamBevat){
        return klantRepository.findKlantByFamilienaamContainingIgnoreCaseOrderByFamilienaamAsc(familienaamBevat);
    }
}
