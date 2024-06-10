package Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Classe;
import Entities.Professeur;
import Entities.ProfesseurClasse;
import Repositories.ProfesseurClasseRepository;
import Repositories.ProfesseurRepository;

public class ProfesseurServices {
    ProfesseurRepository professeurRepository= new ProfesseurRepository();
    ProfesseurClasseRepository professeurClasseRepository = new ProfesseurClasseRepository();
    public List<Professeur>listerProfesseurs(){
        return professeurRepository.selectAll();
    }

    public void AjouterProf(Professeur professeur){
        professeurRepository.AjouterProf(professeur);
    }

     // Méthode pour insérer une association professeur-classe
     public void ajouterProfesseurClasse(ProfesseurClasse professeurClasse) {
        // Appeler la méthode insert du repository
        professeurClasseRepository.insert(professeurClasse);
    }
      
    public void AjouterProfClasse(ProfesseurClasse professeurClasse){
        professeurClasseRepository.AjouterProfClasse(professeurClasse);
    }

        public Professeur rechercheProfesseurParId(int id){
        return professeurRepository.selectProfById(id);
    }
    
    public List<Professeur> rechercheProfesseurParClasse(Classe classe) {
        return professeurRepository.selectProfesseurByClasse(classe);
    }
    
}
