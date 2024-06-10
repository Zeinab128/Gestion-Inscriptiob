package Services;

import java.util.List;

import Entities.Etudiant;
import Entities.EtudiantClasse;
import Entities.Professeur;
import Entities.ProfesseurClasse;
import Repositories.EtudiantClasseRepository;
import Repositories.EtudiantRepository;

public class EtudiantServices {
    EtudiantRepository etudiantRepository= new EtudiantRepository();
    EtudiantClasseRepository etudiantClasseRepository = new EtudiantClasseRepository();

    public List<Etudiant>listerEtudiant(){
        return etudiantRepository.selectAll();
    }

    public Etudiant ajouterEtudiant(Etudiant etudiant){
        // Insérer l'étudiant dans la base de données
        etudiantRepository.insert(etudiant);
        
        // Récupérer l'ID de l'étudiant inséré
        Etudiant etudiantInsere = etudiantRepository.selectEtudiantBYMatri(etudiant.getMatri());
        
        if (etudiantInsere != null) {
            // Retourner l'objet Etudiant inséré
            return etudiantInsere;
        } else {
            // Gérer l'échec de l'insertion de l'étudiant (vous pouvez lever une exception ou retourner null, selon vos besoins)
            return null;
        }
    }
    

    public Etudiant rechercheEtudiantParMatri(String matri){
        return etudiantRepository.selectEtudiantBYMatri(matri);
    }

    /*public void ajouterEtudiantClasse(EtudiantClasse etudiantClasse)
    {
        etudiantClasseRepository.AjouterEtudiantClasse(etudiantClasse);
    }*/

     // Méthode pour insérer une association professeur-classe
     public void ajouterEtudiantClasse(EtudiantClasse etudiantClasse) {
        // Appeler la méthode insert du repository
        etudiantClasseRepository.insert(etudiantClasse);
    }

     public Etudiant rechercheEtudiantParId(int id){
        return etudiantRepository.selectEtudiantById(id);
    }

    public List<Etudiant> listerEtudiantParClasse(String libelle){
        return etudiantClasseRepository.selectEtudiantByClasse(libelle);
    }
}
