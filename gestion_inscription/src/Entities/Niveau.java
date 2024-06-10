package Entities;

import java.sql.Date;
import java.util.ArrayList;

public class Niveau {
    private int idR;
    private Date dateR;
     //OneToMany
    private ArrayList<Classe>classes=new ArrayList<>();
    public ArrayList<Classe> getClasses() {
        return classes;
    }
    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }
    public Niveau() {
    }
    public int getIdR() {
        return idR;
    }
    public void setIdR(int idR) {
        this.idR = idR;
    }
    public Date getDateR() {
        return dateR;
    }
    public void setDateR(Date dateR) {
        this.dateR = dateR;
    }
}
