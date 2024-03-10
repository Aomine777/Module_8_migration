package org.example.repository;


import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseInitService {
    public static void main(String[] args) throws SQLException {
        InputStream input = DatabaseInitService.class.getClassLoader().getResourceAsStream("migration/V1__init_database.sql");
        Scanner scanner = new Scanner(input).useDelimiter(";");
        Statement statement = Database.getInstance().createStatement();

        while(scanner.hasNext()){
            String query = scanner.next();
            statement.addBatch(query);
        }
        statement.executeBatch();
        scanner.close();
        Database.getInstance().closeConnection();
    }
}
