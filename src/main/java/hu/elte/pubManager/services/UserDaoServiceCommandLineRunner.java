/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.services;

import hu.elte.pubManager.entities.User;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 *
 * @author madave91
 */
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{
    private static final Logger log = 
            LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
    
    @Autowired
    private UserDaoService userDaoService;
    
    Date date = new GregorianCalendar(1991, Calendar.MARCH, 24).getTime();
    @Override
    public void run(String... args) throws Exception {
        User user = new User("David", date);
        long insert = userDaoService.insert(user);
        log.info("New User is created " + user);
    }
    
}
