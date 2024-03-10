package org.example.repository;

import org.example.entities.LongestProject;
import org.example.entities.MaxProjectCountClient;
import org.example.entities.Worker;

import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.*;

public class DatabaseQueryService {

    private static Logger LOGGER = Logger.getLogger(DatabaseQueryService.class.getName());
    static {

        Handler ch =  new ConsoleHandler();
        ch.setFormatter(new SimpleFormatter());
        LOGGER.addHandler(ch);

        try {
            Handler fh = new FileHandler("logs/service.log", false);
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        try (Statement statement = Database.getInstance().createStatement()) {
            ResultSet resultSet = statement.executeQuery(getQueryFromFile("sql/find_max_projects_client.sql"));
            List<MaxProjectCountClient> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new MaxProjectCountClient(
                        resultSet.getInt("client_id"), resultSet.getString("client_name"), resultSet.getInt("count_of_entries")));
            }
            resultSet.close();
            return result;
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            throw new RuntimeException();
        }
    }


    public List<LongestProject> findLongestProject() {
        try (Statement statement = Database.getInstance().createStatement()) {
            ResultSet resultSet = statement.executeQuery(getQueryFromFile("sql/find_longest_project.sql"));
            List<LongestProject> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new LongestProject(
                        resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("date_diff")));
            }
            resultSet.close();
            return result;
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            throw new RuntimeException();
        }
    }


    public List<Worker> findMaxSalaryWorker() {
        try (Statement statement = Database.getInstance().createStatement()) {
            ResultSet resultSet = statement.executeQuery(getQueryFromFile("sql/find_max_salary_worker.sql"));
            List<Worker> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Worker(
                        resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getDate("birthday").toLocalDate(),
                        resultSet.getString("level"), resultSet.getInt("salary")));
            }
            resultSet.close();
            return result;
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            throw new RuntimeException();
        }
    }


    public List<Worker> findOldestAndYoungestWorker() {
        try (Statement statement = Database.getInstance().createStatement()) {
            ResultSet resultSet = statement.executeQuery(getQueryFromFile("sql/find_youngest_eldest_workers.sql"));
            List<Worker> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Worker(
                        resultSet.getString("type"),
                        resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getDate("birthday").toLocalDate(),
                        resultSet.getString("level"), resultSet.getInt("salary")));
            }

            resultSet.close();
            return result;
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            throw new RuntimeException();
        }
    }


    public static String getQueryFromFile(String filename) throws InputMismatchException {
        InputStream input = DatabaseInitService.class.getClassLoader().getResourceAsStream(filename);

        if (input == null) throw new InputMismatchException();

        Scanner scanner = new Scanner(input).useDelimiter("\\A");
        String query = scanner.hasNext() ? scanner.next() : "";
        scanner.close();
        return query;
    }
}
