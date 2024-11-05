package fr.diginamic;

import fr.diginamic.entity.Client;
import fr.diginamic.entity.Emprunt;
import fr.diginamic.entity.Livre;
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

       Emprunt e1 = em.find(Emprunt.class, 1);
        if(e1 != null){
            System.out.println(e1);
            for (Livre var : e1.getLivres()){
                System.out.println("-" + var);
            }
        }

        Client c1 = em.find(Client.class, 1);
        if (c1 != null){
            for (Emprunt var : c1.getEmprunts()){
                System.out.println(var);
            }
        }

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
