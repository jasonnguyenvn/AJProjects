/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sample.entity.Users;

/**
 *
 * @author Hau
 */
@Stateless
public class UserSessionBean 
        implements UserSessionBeanLocal, UserSessionBeanRemote {
    @PersistenceContext(unitName = "EntityExmple-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public boolean checkLogin(String username, String password) {
        String jpql = "Select u From Users u WHERE u.username = :username "
                + " AND u.password = :password ";
        Query query = em.createQuery(jpql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        
        try {
            query.getSingleResult();
            return true;
        } catch (NoResultException ex) {
            return false;
        }
        
    }

    @Override
    public java.util.List searchLikeName(String lastname) {
        String jpql = "Users.findLikeLastname";
        
        Query query = em.createNamedQuery(jpql);
        query.setParameter("lastname", "%" + lastname + "%");
        
        List result = query.getResultList();
        
        return result; 
    }

    @Override
    public boolean deleteUser(String pk) {
        Users userObj = em.find(Users.class, pk);
        
        if (userObj == null) {
            return false;
        }
        
        em.remove(userObj);
        
        return true;
    }

    @Override
    public boolean updateUser(String pk, String password, boolean role) {
        Users userObj = em.find(Users.class, pk);
        
        if (userObj == null) {
            return false;
        }
        
        userObj.setPassword(password);
        userObj.setIsAdmin(role);
        
        em.merge(userObj);
        
        return true;
    }

    @Override
    public boolean insertUser(String pk, String username, String password, String lastname, boolean role) {
        Users userObj = em.find(Users.class, pk);
        
        if (userObj != null) {
            return false;
        }
        
        userObj = new Users(username, password, lastname, role);
        
        em.persist(userObj);
        
        return true;
    }
    
    
    
}
