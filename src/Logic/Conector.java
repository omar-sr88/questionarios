/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author omar
 */
public final class Conector {
    
    private static final Conector INSTANCE = new Conector();
    
    EntityManagerFactory factory;
    EntityManager manager;
    
    
    private Conector(){
        factory = Persistence.createEntityManagerFactory("QuestionariosPU");
        manager = factory.createEntityManager();
    }
    
     public static synchronized Conector getInstance(){
           return INSTANCE;
     }
    
     public void adicionar(Questao q){
         
         manager.getTransaction().begin();
         try{
             manager.persist(q);
             manager.getTransaction().commit();
     
         }catch (Exception e) {

            e.printStackTrace();
            manager.getTransaction().rollback();
         } finally {
             manager.close();
         }
    }

     
    
}
