package implementation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Encargada de la creación del Entity Manager factory
 */
public class PersistenceManager {
    private static EntityManagerFactory instance = Persistence.createEntityManagerFactory("Example");

    private PersistenceManager() {

    }

    public static EntityManagerFactory getInstance() {
        return instance;
    }
}
