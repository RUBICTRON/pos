/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.service.custom;

import java.util.ArrayList;
import lk.rubictron.posfinal.dto.OrderDetailsDto;
import lk.rubictron.posfinal.service.SuperService;
import lk.rubictron.posfinal.dto.OrderDto;

/**
 *
 * @author rubictron
 */
public interface OrderService extends SuperService<OrderDto, String>{
 public String getLastId() throws Exception;
}
