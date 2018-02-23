/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.bussiness.custom;

import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.SuperBussiness;
import lk.rubictron.posfinal.dto.OrderDetailsDto;

/**
 *
 * @author rubictron
 */
public interface OrderDetailsBussiness extends SuperBussiness<OrderDetailsDto,String>{
    public boolean add(ArrayList<OrderDetailsDto> array) throws Exception;
}
