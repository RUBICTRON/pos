/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.bussiness.custom;

import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.SuperBussiness;
import lk.rubictron.posfinal.dto.OrderDetailsDto;
import lk.rubictron.posfinal.dto.OrderDto;

/**
 *
 * @author rubictron
 */
public interface OrderBussiness extends SuperBussiness<OrderDto,String>{
  public String getLastID() throws Exception;    
}
