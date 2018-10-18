/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.services;

import hu.elte.pubManager.entities.User;
import hu.elte.pubManager.repositories.UserRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 *
 * @author madave91
 */
public class UserRepositoryCommandLineRunner implements CommandLineRunner{
    private static final Logger log = 
            LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
    
    @Autowired
    private UserRepository userRepository;
    
    Date date = new GregorianCalendar(1991, Calendar.MARCH, 24).getTime();
    @Override
    public void run(String... args) throws Exception {
        User user = new User("David", date);
        userRepository.save(user);
        log.info("New User is created " + user);
        
        Optional<User> userWithIdOne = userRepository.findById(1); 
        log.info("User one is retrieved " + user);
        
        List<User> users = userRepository.findAll();
        log.info("All users: " + users);
        
        //delete, ...
        
    }
    
}
