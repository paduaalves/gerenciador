package br.com.alura.gerenciador.modelo;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ConnectionFactory {

    public static EntityManager gEntityManager() {
        return Persistence.createEntityManagerFactory("gerenciador").createEntityManager();
    }
}