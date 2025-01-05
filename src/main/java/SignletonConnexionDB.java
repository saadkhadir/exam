import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class SignletonConnexionDB {
        private static Connection connection;

        static {
            try {
                // Chargez le driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Initialisez la connexion
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/prep2", // Remplacez par votre URL JDBC
                        "root", // Remplacez par votre utilisateur MySQL
                        "Elgrandejcole03" // Remplacez par votre mot de passe MySQL
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


