package Entities;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private int Id;
    private String matri;
    private String nomComplet;
    private String tuteur;

     //OneToMany
    List<Inscription>  inscriptions =new ArrayList<>();
    
    public List<Inscription> getInscriptions() {
        return inscriptions;
    }
    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
    
    public Etudiant() {
    }
    public String getMatri() {
        return matri;
    }
    public void setMatri(String string) {
        this.matri = string;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public String getTuteur() {
        return tuteur;
    }
    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        this.Id = id;
    }
}
