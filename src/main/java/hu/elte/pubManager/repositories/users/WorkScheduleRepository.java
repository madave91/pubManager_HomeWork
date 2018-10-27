/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.repositories.users;

import hu.elte.pubManager.entities.Users.WorkSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author madave91
 */
@ResponseBody
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Integer> {
         
}

