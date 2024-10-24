package be.vdab.fiesta.Verhuringen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VerhuringBestaatNietExcepion extends RuntimeException {
    VerhuringBestaatNietExcepion(){
        super("De verhuring bestaat niet");
    }
}
