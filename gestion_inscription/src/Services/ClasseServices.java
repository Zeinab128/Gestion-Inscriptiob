package Services;

import java.util.List;

import Entities.Classe;
import Entities.Etudiant;
import Repositories.ClasseRepository;

public class ClasseServices {
     private ClasseRepository classeRepository=new ClasseRepository();
    
  public List<Classe> listerClasse(){
      return classeRepository.selectAll();
   }
   public void ajouterClasse(Classe classe){
    classeRepository.insert(classe);
   }

    public Classe rechercheClasseParId(int id){
        return classeRepository.selectClasseBYId(id);
    }

    public Classe rechercheClasseParLibelle(String libelle){
        return classeRepository.selectClasseBYLibelle(libelle);
    }

}
