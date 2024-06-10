package Services;

import java.util.List;

import Entities.Inscription;
import Repositories.InscriptionRepository;

public class InscriptionServices {
    private InscriptionRepository inscriptionRepository= new InscriptionRepository();
    /* public List<Inscription> ListeInscription(){
        return inscriptionRepository.selectAll();
    } */
    public void inscrireEtudiant(Inscription inscription){
        inscriptionRepository.insert(inscription);
    }
}
