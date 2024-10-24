package be.vdab.fiesta.Klanten;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Stream;

@RestController
@RequestMapping("klanten")
public class KlantController {
    private final KlantService klantService;

    public KlantController(KlantService klantService) {
        this.klantService = klantService;
    }

    @GetMapping(params = "familienaambevat")
    Stream<KlantBeknopt> findKlantByFamilienaamContaining(String familienaambevat){
        return klantService.findKlantByFamilienaamContaining(familienaambevat)
                .stream()
                .map(KlantBeknopt::new);
    }
}
