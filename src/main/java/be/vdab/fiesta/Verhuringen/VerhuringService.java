package be.vdab.fiesta.Verhuringen;

import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Service
@Transactional(readOnly = true)
public class VerhuringService {
    private final VerhuringRepository verhuringRepository;

    public VerhuringService(VerhuringRepository verhuringRepository) {
        this.verhuringRepository = verhuringRepository;
    }

    public VerhuringBeknopt findVerhuringById(long id){
        return verhuringRepository.findVerhuringById(id)
                .map(VerhuringBeknopt::new)
                .orElseThrow(VerhuringBestaatNietExcepion::new);
    }

    @Transactional
    public void brengVerhuringTerug(long id){
        try{
            Verhuring verhuring =  verhuringRepository.findVerhuringById(id)
                    .orElseThrow(VerhuringBestaatNietExcepion::new);
            if(verhuring.getTerugGebrachtOp() != null){
                throw new VerhuringIsAlTeruggebrachtException();

            }
            verhuring.setTerugGebrachtOp();
            BigDecimal boete = verhuring.berekenBoete();
            if(boete.compareTo(BigDecimal.ZERO)!= 0){
                verhuring.getKlant().setTeLaatTerugGebracht();
                verhuring.getMateriaal().setTeLaatTerugGebracht();
            }
            else {
                verhuring.getKlant().setOpTijdTerugGebracht();
                verhuring.getMateriaal().setOpTijdTerugGebracht();
            }
        }
        catch(ObjectOptimisticLockingFailureException ex){
            throw new EenAndereGebruikerWijzigdeDeVerhuringException();
        }
    }
}
