package be.vdab.fiesta.Verhuringen;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("verhuringen")
public class VerhuringController {
    private final VerhuringService verhuringService;

    public VerhuringController(VerhuringService verhuringService) {
        this.verhuringService = verhuringService;
    }
    
    @GetMapping("{id}")
    VerhuringBeknopt findVerhuringById(@PathVariable long id){
        return verhuringService.findVerhuringById(id);
    }

    @PatchMapping("{id}/terug")
    void brengVerhuringTerug(@PathVariable long id){
        verhuringService.brengVerhuringTerug(id);
    }
}
