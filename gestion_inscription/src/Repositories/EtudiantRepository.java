package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Classe;
import Entities.Etudiant;
import Entities.Professeur;

public class EtudiantRepository {

    public void insert(Etudiant etudiant){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java"
                    , "root", "");
            Statement statement = conn.createStatement();
            String sql=String.format("INSERT INTO `etudiant` (`mat_etudiant`, `nom_complet`, `tutor_etudiant`) "
                      + " VALUES ('"+etudiant.getMatri()+"' , '"+etudiant.getNomComplet()+"' , '"+etudiant.getTuteur()+"')",
                      etudiant.getMatri(),etudiant.getNomComplet(),etudiant.getTuteur());
             int nbreLigne=statement.executeUpdate(sql);
             statement.close();
             conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver");
        }
        catch (SQLException e) {
            System.out.println("Erreur de Connexion a la BD");
        }
    }

    public List<Etudiant> selectAll(){
         List<Etudiant> etudiants=new ArrayList<>();
        try {
    
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java"
                       , "root", "");
           Statement statement = conn.createStatement();
           String sql="Select * from etudiant";
           ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {
               //Une ligne ==> rs de la requete
                Etudiant etudiant =new Etudiant();
                etudiant.setMatri(rs.getString("mat_etudiant"));
                etudiant.setNomComplet(rs.getString("nom_complet"));
                etudiant.setTuteur(rs.getString("tutor_etudiant"));
                etudiants.add(etudiant);
            }
            statement.close();
            rs.close();
            conn.close();
       } catch (ClassNotFoundException e) {
           System.out.println("Erreur de chargement de Driver");
       }
       catch (SQLException e) {
         System.out.println("Erreur de Connexion a la BD");
       }
       return etudiants;
      }
      public Etudiant selectEtudiantBYMatri(String matri){
        Etudiant etudiant=null;
        try {
    
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java" 
                   , "root", "");
           Statement statement = conn.createStatement();
           String sql=String.format("Select * from etudiant where mat_etudiant  like '%s' ",matri);
           ResultSet rs=statement.executeQuery(sql);
            if (rs.next()) {
               //Une ligne ==> rs de la requete
                etudiant=new Etudiant();
                etudiant.setMatri(rs.getString("mat_etudiant"));
                etudiant.setNomComplet(rs.getString("nom_complet"));
                etudiant.setTuteur(rs.getString("tutor_etudiant"));
            }
            statement.close();
            rs.close();
            conn.close();
       } catch (ClassNotFoundException e) {
           System.out.println("Erreur de chargement de Driver");
       }
       catch (SQLException e) {
         System.out.println("Erreur de Connexion a la BD");
       }
           return etudiant;
      }

       public Etudiant selectEtudiantById(int etudiantId) {
        Etudiant etudiant = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java", "root", "");
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM etudiant WHERE id_etudiant = " + etudiantId;
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs.next()) {
                etudiant = new Etudiant();
                etudiant.setId(rs.getInt("id_etudiant"));
                etudiant.setMatri(rs.getString("mat_etudiant"));
                etudiant.setNomComplet(rs.getString("nom_complet"));
                etudiant.setTuteur(rs.getString("tutor_etudiant"));
            }
            
            rs.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement de Driver : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur de Connexion a la BD : " + e.getMessage());
        }
        return etudiant;
    }
}
