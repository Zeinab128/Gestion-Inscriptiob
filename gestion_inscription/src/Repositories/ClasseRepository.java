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

public class ClasseRepository {
    public  List<Classe> selectAll(){
         List<Classe> classes=new ArrayList<>();
       try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java"
                    , "root", "");
          //3-Execution et Recuperation
           Statement statement = conn.createStatement();
           ResultSet rs=   statement.executeQuery("select * from classes");
             while (rs.next()) {
               //Une ligne du ResultSet ==> Une Agence
                 Classe cl=new Classe();
                 cl.setId(rs.getInt("id_classe"));
                 cl.setLibelle(rs.getString("Libelle_classe"));
                 classes.add(cl);
             }
             rs.close();
             conn.close();
        } catch (ClassNotFoundException e) {
          System.out.println("Erreur de chargement de Driver");
        }
       catch (SQLException e) {
        System.out.println("Erreur de Connexion a la BD");
      }
        return  classes;
    }

    public  void insert(Classe classe){
        try {
             //1-Chargement du Driver
             Class.forName("com.mysql.cj.jdbc.Driver");
             //2-Se Connecter a une BD
             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java"
                       , "root", "");
               //3-Execution et Recuperation
                Statement statement = conn.createStatement();
               
                int nbreLigne=statement.executeUpdate("INSERT INTO `classes` ( `Libelle_classe`) VALUES ('"+classe.getLibelle()+"')");
                conn.close();
           } catch (ClassNotFoundException e) {
               System.out.println("Erreur de chargement de Driver");
           }
          catch (SQLException e) {
             System.out.println("Erreur de Connexion a la BD");
         }
        }

          public Classe selectClasseBYId(int id){
        Classe classe=null;
        try {
    
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java" 
                   , "root", "");
           Statement statement = conn.createStatement();
           String sql=String.format("SELECT * FROM `classes` WHERE Id_classe like '%s' ",id);
           ResultSet rs=statement.executeQuery(sql);
            if (rs.next()) {
               //Une ligne ==> rs de la requete
                classe=new Classe();
                classe.setLibelle(rs.getString("Libelle_classe"));
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
           return classe;
      }

      public Classe selectClasseBYLibelle(String libelle){
        Classe classe=null;
        try {
    
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java" 
                   , "root", "");
           Statement statement = conn.createStatement();
           String sql=String.format("SELECT * FROM `classes` WHERE Libelle_classe like '%s' ",libelle);
           ResultSet rs=statement.executeQuery(sql);
            if (rs.next()) {
               //Une ligne ==> rs de la requete
                classe=new Classe();
                classe.setLibelle(rs.getString("Libelle_classe"));
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
           return classe;
      }
}
