package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Classe;
import Entities.Etudiant;
import Entities.Inscription;

public class InscriptionRepository {
    private static final String INSERT_QUERY = "INSERT INTO inscription (Id_inscription, date_inscription, nom_classe,etudiant_id) VALUES (?, ?, ?, ?)";

   public void insert(Inscription inscription) {
    try {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java", "root", "");

        PreparedStatement statement = conn.prepareStatement(INSERT_QUERY);
        statement.setInt(1, inscription.getId());
        statement.setString(2, inscription.getDateI());
        statement.setString(3, inscription.getClasse().getLibelle());
        statement.setInt(4, inscription.getEtudiant().getId());
        

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("L'inscription a été insérée avec succès !");
        } else {
            System.out.println("Échec de l'insertion de l'inscription.");
        }

        statement.close();
        conn.close();
    } catch (ClassNotFoundException e) {
        System.out.println("Erreur de chargement du driver JDBC : " + e.getMessage());
    } catch (SQLException e) {
        System.out.println("Erreur SQL lors de l'insertion de l'inscription : " + e.getMessage());
    }

       
}


}
