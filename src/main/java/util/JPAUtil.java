package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory emf;

    private JPAUtil(){}

    public static EntityManagerFactory getEntityManagerFactory(){

        if(emf == null)
            emf = Persistence.createEntityManagerFactory("Profesor");

        return emf;
    }

}
