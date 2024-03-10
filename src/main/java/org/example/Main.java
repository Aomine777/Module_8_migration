package org.example;

import org.example.dao.ClientDao;
import org.example.entities.Client;
import org.flywaydb.core.Flyway;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Flyway flyway = Flyway.configure().dataSource(PropertyReader.getDbUrl(), PropertyReader.getBdUserName(), PropertyReader.getBdPassword()).load();
        flyway.migrate();

        ClientDao clientDao = new ClientDao();
        Optional<List<Client>> client = clientDao.listAll();
        if (client.isPresent()) {
            System.out.println(">>>>>>" + client.get());
        } else {
            System.out.println(">>>>>>" +  " not " );
        }
    }
}