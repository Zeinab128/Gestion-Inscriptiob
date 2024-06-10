package Entities;

import java.util.ArrayList;

public class Filiere {
    private int id;
    private String libelle;
      //OneToMany
    private ArrayList<Classe>classes=new ArrayList<>();
    public ArrayList<Classe> getClasses() {
        return classes;
    }
    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }
    public Filiere() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
