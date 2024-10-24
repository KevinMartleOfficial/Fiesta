package be.vdab.fiesta.Verhuringen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EenAndereGebruikerWijzigdeDeVerhuringException extends RuntimeException{
    EenAndereGebruikerWijzigdeDeVerhuringException(){
        super("Een andere gebruiker voltooide alreeds de verhuring");
    }
}
