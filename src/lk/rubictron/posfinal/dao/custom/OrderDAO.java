/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dao.custom;

import lk.rubictron.posfinal.dto.OrderDto;
import lk.rubictron.posfinal.dao.SuperDAO;

/**
 *
 * @author rubictron
 */
public interface OrderDAO extends SuperDAO<OrderDto, String>{

    public String getLastId() throws Exception;
    
}
