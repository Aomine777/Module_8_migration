package org.example.repository;

import org.example.PropertyReader;

import java.sql.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Database {
        public static Logger LOGGER = Logger.getLogger(Database.class.getName());
        static {
            Handler ch = new ConsoleHandler();
            ch.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(ch);
        }
        private Connection connection = null;
        private static final Database instance = new Database();

        private Database(){
            getConnection();
        }
        public static Database getInstance(){
            return instance;
        }
        public Connection getConnection() {
            if (connection == null) {
                try {
                    connection = DriverManager.getConnection(PropertyReader.getDbUrl(), PropertyReader.getBdUserName(), PropertyReader.getBdPassword());
                } catch (SQLException e) {
                    LOGGER.warning("Connection failed" + e.getMessage());
                    throw new RuntimeException(e);
                }
            }
            return connection;
        }

        public Statement createStatement(){
            try{
                return getConnection().createStatement();
            } catch (SQLException e) {
                LOGGER.warning("Unable to create statement");
                throw new RuntimeException(e);
            }
        }
        public int executeUpdate(String query){
            try(Statement statement = connection.createStatement()){
                return statement.executeUpdate(query);
            } catch (SQLException e) {
                LOGGER.warning("Exception. Reason: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        public ResultSet executeResult(String query){
            try {
                Statement statement = connection.createStatement();
                return statement.executeQuery(query);
            } catch (SQLException e) {
                LOGGER.warning("Exception. Reason: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
        public void closeConnection(){
            if(connection == null)
                return;
            try{
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}
