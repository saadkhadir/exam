package com.example.exam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
    public class SignletonConnexionDB {
        private static Connection connection;

        static {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/exam",
                        "root",
                        "Elgrandejcole03"
                );
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Erreur lors de la connexion à la base de données");
            }
        }

        public static Connection getConnection() {
            return connection;
        }
    }


