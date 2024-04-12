package fr.hetic;

import java.io.*;
import java.sql.*;

public class CalculateurDonnees implements Reader{
    int param1;
    int param2;
    String operateur;
    int fichier_id;
    int position;
    String type;

    public CalculateurDonnees(int param1, int param2, String operateur, int fichier_id, int position, String type) {
        this.param1 = param1;
        this.param2 = param2;
        this.operateur = operateur;
        this.fichier_id = fichier_id;
        this.position = position;
        this.type = type;
    }


    @Override
    public void read(String folderName) throws Exception {
        String url = "jdbc:postgresql://SG-hetic-mt4-java-5275-pgsql-master.servers.mongodirector.com:5432/TP";
        String utilisateur = "etudiant";
        String motDePasse = "MT4@hetic2324";

        try {
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            System.out.println("Connexion établie avec succès !");

            String sql = "SELECT param1, param2, operateur, fichier_id, position FROM ligne ORDER BY fichier_id, position";
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            FileWriter writer = null;
            String writerNom = null;

            while (resultSet.next()) {
                double param1 = resultSet.getInt("param1");
                double param2 = resultSet.getInt("param2");
                String operateur = resultSet.getString("operateur");
                int fichier_id = resultSet.getInt("fichier_id");
                int position = resultSet.getInt("position");

                String sqlFileInfo = "SELECT type, nom FROM fichier WHERE id = ?";
                PreparedStatement preparedStatement = connexion.prepareStatement(sqlFileInfo);
                preparedStatement.setInt(1, fichier_id);
                ResultSet resultSetFileInfo = preparedStatement.executeQuery();

                while (resultSetFileInfo.next()) {
                    String type = resultSetFileInfo.getString("type");
                    String nom = resultSetFileInfo.getString("nom");

                    if ("OP".equals(type)) {
                        if (writer != null && !nom.equals(writerNom)) {
                            writer.close();
                            writer = null;
                        }
                        if (writer == null) {
                            writer = new FileWriter(nom + ".res");
                            writerNom = nom;
                        }
                        String res = FileProcessor.calculFichier(String.valueOf(param1), String.valueOf(param2),
                                operateur);
                        writer.write(res + "\n");

                        System.out.println(nom + " " + param1 + " " + param2 + res + "\n");
                    }
                }
            }

            if (writer != null) {
                writer.close();
            }

        } catch (SQLException | IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

   
}
