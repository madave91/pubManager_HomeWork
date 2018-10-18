/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.services;

import hu.elte.pubManager.entities.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author madave91
 */
@Repository
@Transactional
public class UserDaoService {
    @PersistenceContext
    private EntityManager entityManager;
    public long insert(User user){
        entityManager.persist(user);
        return user.getId();
    }
}
/*
public class ProductDaoService {
    @PersistenceContext
    private EntityManager entityManager;
    public long insert(User user){
        entityManager.persist(user);
        return user.getId();
    }
}*/