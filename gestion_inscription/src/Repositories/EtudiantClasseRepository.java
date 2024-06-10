package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.Etudiant;
import Entities.EtudiantClasse;
import Entities.ProfesseurClasse;

public class EtudiantClasseRepository {
    private static final String INSERT_QUERY = "INSERT INTO etudiant_classe (idEC, nom_classe, etd_id) VALUES (?, ?, ?)";
    private static final String SELECT_etudiant_classe_QUERY = "SELECT e.* FROM etudiant e " +
                                                                "INNER JOIN etudiant_classe ec ON e.id_etudiant = ec.etd_id " +
                                                                "INNER JOIN classes c ON ec.nom_classe = c.Libelle_classe " +
                                                                "WHERE c.Libelle_classe = ?";

    public void insert(EtudiantClasse etudiantClasse) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java", "root", "");

            PreparedStatement statement = conn.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(2, etudiantClasse.getClasse().getLibelle());
            statement.setInt(3, etudiantClasse.getEtudiant().getId());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    etudiantClasse.setId(id); // Mettre à jour l'ID de l'association avec l'ID généré
                }
                System.out.println("L'association etudiant-classe a été insérée avec succès !");
            } else {
                System.out.println("Échec de l'insertion de l'association etudiant-classe.");
            }

            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de chargement du driver JDBC : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur SQL lors de l'insertion de l'association professeur-classe : " + e.getMessage());
        }
    }

   public List<Etudiant> selectEtudiantByClasse(String libelle) {
        List<Etudiant> etudiants = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen_java", "root", "");

            PreparedStatement statement = conn.prepareStatement(SELECT_etudiant_classe_QUERY);
            statement.setString(1, libelle);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Créer un objet Etudiant pour chaque ligne de résultat
                Etudiant etudiant = new Etudiant();
                etudiant.setId(resultSet.getInt("etd_id"));
                etudiant.setNomComplet(resultSet.getString("nom_complet"));
                etudiant.setMatri(resultSet.getString("mat_etudiant"));
                etudiant.setTuteur(resultSet.getString("tutor_etudiant"));
                // Ajouter l'étudiant à la liste
                etudiants.add(etudiant);
            }

            // Fermer les ressources
            resultSet.close();
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Gérer l'exception selon vos besoins
        } catch (SQLException e) {
            e.printStackTrace(); // Gérer l'exception selon vos besoins
        }

        return etudiants;
    }

}
