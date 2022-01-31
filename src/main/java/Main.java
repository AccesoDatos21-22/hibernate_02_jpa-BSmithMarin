
import entidades.Correo;
import entidades.Direccion;
import entidades.Modulo;
import entidades.Profesor;
import org.hibernate.Session;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Arrays;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        //Session session = em.unwrap(Session.class);  obtner un objeto session a partir de un entity manager

        Direccion direccion1 = new Direccion("P Castellana","Madrid","Madrid",23);
        Direccion direccion2 = new Direccion("C/Magnolias","Madrid","Madrid",96);

        Profesor profesor1 = new Profesor("Juan","Gonzalez","Izquierdo",direccion1);
        Profesor profesor2 = new Profesor("Margarita","Robles","Martinez",direccion2);

        Correo correo1 = new Correo("profesor1@gmail.com","GMAIL");
        Correo correo2 = new Correo("profesor1_empresa@outlook.com","OUTLOOK");

        Modulo modulo1 = new Modulo("Sistemas Informaticos",1,6);
        Modulo modulo2 = new Modulo("Programacion II",2,12);

        try {
            transaction.begin();

            Set<Modulo> modulos1 = profesor1.getModulos();  //Asignamos asignaturas al profesor
            modulos1.addAll(Arrays.asList(modulo1,modulo2));
            profesor1.setModulos(modulos1);

            profesor1.setCorreos(Arrays.asList(correo1,correo2)); //Ambos correos son del profesor 1

            em.persist(profesor1);  //Guadado de profesor y direccion
            em.persist(profesor2);
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
            Modulo moduloInsertado = em.find(Modulo.class,2);
            Correo correoInsertado = em.find(Correo.class,1);

            Thread.sleep(1500);
            System.out.println("Profesores por modulo:");
            System.out.println(moduloInsertado.getProfesores());
            System.out.println("Modulos por profesor:");
            System.out.println(profesorInsertado.getModulos());
            System.out.println("Correos del profesor:");
            System.out.println(profesorInsertado.getCorreos());
            System.out.println("Profesor del correo");
            System.out.println(correoInsertado.getProfesor());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
