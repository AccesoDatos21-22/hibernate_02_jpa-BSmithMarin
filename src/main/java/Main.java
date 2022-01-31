
import entidades.Direccion;
import entidades.Modulo;
import entidades.Profesor;
import org.hibernate.Session;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        //Session session = em.unwrap(Session.class);  obtner un objeto session a partir de un entity manager

        Direccion direccion1 = new Direccion("P Castellana","Madrid","Madrid",23);
        Direccion direccion2 = new Direccion("C/Magnolias","Madrid","Madrid",96);
        Profesor profesor1 = new Profesor("Juan","Gonzalez","Izquierdo",direccion1);
        Profesor profesor2 = new Profesor("Margarita","Robles","Martinez",direccion2);

        Modulo modulo1 = new Modulo("Sistemas Informaticos",1,6);
        Modulo modulo2 = new Modulo("Programacion II",2,12);
        try {
            transaction.begin();

            em.persist(profesor1);  //Guadado de profesor y direccion
            em.persist(profesor2);

            /*modulo2.setListaProfesores(Arrays.asList(profesor1,profesor2));
            modulo1.setListaProfesores(Arrays.asList(profesor1,profesor2));*/

            em.persist(modulo1);       //ambos profesores imparten las 2 asignaturas
            em.persist(modulo2);
            
            profesor1.setModulo(modulo1);
            profesor2.setModulo(modulo2);

            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (transaction.isActive())
                transaction.rollback();
            em.close();
        }

        //Consulta de entidad insertada

        em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try{
            Profesor profesorInsertado = em.find(Profesor.class,1);
            Modulo moduloInsertado = em.find(Modulo.class,1);
            System.out.println(moduloInsertado.getListaProfesores());
            System.out.println(profesorInsertado.getDireccion());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
