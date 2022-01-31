package entidades;

import org.junit.jupiter.api.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProfesorTest {

    private static EntityManager em ;

    private static Profesor profesor;
    private static Direccion direccion;

    @BeforeAll
    static void getEntityManager(){

        assertDoesNotThrow(()->{
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
        });

        direccion = new Direccion(12,
                "Calle Las Marmotas",
                "Madrid",
                "Madrid",
                12);

        profesor = new Profesor(25,
                "Juan Carlos",
                "Gonzalez",
                "Perez",
                direccion);
    }

    @AfterAll
    static void closeEntityManager(){
        assertDoesNotThrow(()->{
            if(em != null)
                em.close();
        });
    }

    @Test
    @Order(5)
    void insertarProfesor(){
        assertDoesNotThrow(()->{
            EntityTransaction tax = em.getTransaction();
            tax.begin();
            em.persist(profesor);
            tax.commit();
        });
    }

    @Test
    @Order(6)
    void consultarProfesor(){

        assertEquals( em.find(Profesor.class,profesor.getId()).getDireccion(), direccion );
    }

    @Test
    @Order(15)
    void borrarProfesor(){

    /*    assertDoesNotThrow(()->{
            Profesor profesorBorrar = em.find(Profesor.class ,25);
            EntityTransaction tax = em.getTransaction();
            tax.begin();
            em.remove( profesorBorrar );
            tax.commit();
        });*/

    }
}