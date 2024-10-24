package be.vdab.fiesta.Verhuringen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class VerhuringIsAlTeruggebrachtException extends RuntimeException{
    VerhuringIsAlTeruggebrachtException(){
        super("De verhuring is al teruggebracht");
    }
}
