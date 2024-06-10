package Entities;
import Entities.Classe;
import Entities.Professeur;


public class ProfesseurClasse {
   private int id;
   private Professeur professeur;
   private Classe classe;

   
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public Professeur getProfesseur() {
    return professeur;
}
public void setProfesseur(Professeur professeur) {
    this.professeur = professeur;
}
public Classe getClasse() {
    return classe;
}
public void setClasse(Classe classe) {
    this.classe = classe;
}
@Override
public String toString() {
    return  professeur.getNomCompletp();
}
}
