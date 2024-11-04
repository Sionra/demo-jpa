package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {
        //Open
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();

        //request
        livreRequest(1, em);
        livreRequest(2, em);
        livreRequest(3, em);

        //Close
        em.close();
        emf.close();
    }

    public static void livreRequest(int id, EntityManager em){
        Livre l = em.find(Livre.class, id);
        if (l == null){
            System.out.println("Aucun livre trouvé avec l'id :" + id);
        } else {
            System.out.println(l);
            System.out.println("-----------");
        }
    }
}
