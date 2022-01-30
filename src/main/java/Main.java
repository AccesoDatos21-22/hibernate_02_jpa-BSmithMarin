
import entidades.Direccion;
import entidades.Profesor;
import org.hibernate.Session;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        //Session session = em.unwrap(Session.class);  obtner un objeto session a partir de un entity manager

        Direccion direccion = new Direccion(1,"P Castellana","Madrid","Madrid",23);
        Profesor profesor = new Profesor(1,"Juan","Gonzalez","Izquierdo",direccion);

        try {
            transaction.begin();
            em.persist(profesor);

            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (transaction.isActive())
                transaction.rollback();
            em.close();
        }

        em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try{
            Profesor profesorInsertado = em.find(Profesor.class,1);
            System.out.println(profesorInsertado.getDireccion());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
