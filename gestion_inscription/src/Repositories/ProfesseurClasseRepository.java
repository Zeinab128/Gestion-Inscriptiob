package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Entities.Professeur;
import Entities.ProfesseurClasse;

public class ProfesseurClasseRepository {
    private static final String INSERT_QUERY = "INSERT INTO professeur_classe (idPC, nom_classe, id_prof) VALUES (?, ?, ?)";

    public void insert(ProfesseurClasse professeurClasse) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java", "root", "");

            PreparedStatement statement = conn.prepareStatement(INSERT_QUERY);
            statement.setInt(1, professeurClasse.getId());
            statement.setString(2, professeurClasse.getClasse().getLibelle());
            statement.setInt(3, professeurClasse.getProfesseur().getIdp());

              // Ajouter des instructions de débogage pour vérifier les valeurs
            System.out.println("ID de la classe : " + professeurClasse.getClasse().getId());
            System.out.println("ID du professeur : " + professeurClasse.getProfesseur().getNomCompletp());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("L'association professeur-classe a été insérée avec succès !");
            } else {
                System.out.println("Échec de l'insertion de l'association professeur-classe.");
            }

            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver JDBC : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur SQL lors de l'insertion de l'association professeur-classe : " + e.getMessage());
        }
    }

    public void AjouterProfClasse(ProfesseurClasse professeurClasse) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java", "root", "");
    
            // Afficher l'ID de la classe récupéré
            System.out.println("ID de la classe associée à l'objet ProfesseurClasse : " + professeurClasse.getClasse().getId());
    
            String sql = "INSERT INTO professeur_classe (Id_classe, id_prof) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, professeurClasse.getClasse().getLibelle());
            statement.setInt(2, professeurClasse.getProfesseur().getIdp());
    
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("L'association professeur-classe a été insérée avec succès !");
            } else {
                System.out.println("Échec de l'insertion de l'association professeur-classe.");
            }
    
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver JDBC : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur SQL lors de l'insertion de l'association professeur-classe : " + e.getMessage());
        }
    }
    
}


