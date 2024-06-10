package Entities;
import Entities.Etudiant;
import Entities.Classe;

public class EtudiantClasse {
    private int id;
    
    private Classe classe;
    private Etudiant etudiant;

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public EtudiantClasse() {
    }
  
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
}
