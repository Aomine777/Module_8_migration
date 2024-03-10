package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static  String getDbUrl(){
        Properties properties = getPropertySource();

        return new StringBuilder("jdbc:postgresql://")
                .append(properties.getProperty("postgres.db.host"))
                .append(":")
                .append(properties.getProperty("postgres.db.port"))
                .append("/")
                .append(properties.getProperty("postgres.db.database"))
                .append("?currentSchema=public")
                .toString();
    }
    public static String getBdUserName(){
        Properties properties = getPropertySource();
        return properties.getProperty("postgres.db.username");
    }
    public static String getBdPassword(){
        Properties properties = getPropertySource();
        return properties.getProperty("postgres.db.password");
    }
    private static Properties getPropertySource(){
        Properties properties = null;
        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream("application.properties")){
            properties = new Properties();

            if(input == null){
                System.out.println("Unable to find application.properties");
                return null;
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
}
