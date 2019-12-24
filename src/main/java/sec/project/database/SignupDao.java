package sec.project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SignupDao {

    Connection dbConnection = null;

    public void addSignup(String name, String address, String religion) throws SQLException {
        try {
            dbConnection = DriverManager.getConnection("jdbc:h2:mem:db", "admin", "admin");
            dbConnection.createStatement()
                    .executeUpdate("INSERT INTO Signup (name, address, religion) VALUES ('" + name + "', '" + address + "', '" + religion + "')");
            dbConnection.close();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

    }

}