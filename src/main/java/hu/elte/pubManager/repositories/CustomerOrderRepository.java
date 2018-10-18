/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.pubManager.repositories;

import hu.elte.pubManager.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author madave91
 */
@ResponseBody
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer>{
}
