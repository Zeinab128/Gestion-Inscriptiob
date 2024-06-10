package Entities;

import java.util.ArrayList;
import java.util.List;

public class Professeur {
    private int Idp;
    private String Nci;
    private String nomCompletp;
    private String grade;

    public String getNci() {
        return Nci;
    }
    public void setNci(String Nci) {
        this.Nci = Nci;
    }
    public String getNomCompletp() {
        return nomCompletp;
    }
    public void setNomCompletp(String nomCompletp) {
        this.nomCompletp = nomCompletp;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public int getIdp() {
        return Idp;
    }
    public void setIdp(int idp) {
        this.Idp = idp;
    }
}
