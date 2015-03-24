/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import model.Group;

/**
 *
 * @author danecek
 */
@Stateless
public class GroupsDAO {

    @PersistenceContext
    EntityManager em;

    public void create(Group g) {
        em.persist(g);
    }

    public Collection<Group> all() {
        TypedQuery<Group> tq = em.createQuery("SELECT c FROM CUST_GROUP c", Group.class); // todo
        return tq.getResultList();
    }

    public Group find(int groupId) {
        return em.find(Group.class, groupId);
    }

}
