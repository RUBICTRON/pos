/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.controller.custom;

import java.util.ArrayList;
import lk.rubictron.posfinal.dto.OrderDto;

/**
 *
 * @author rubictron
 */
public interface AdminControler extends CommenControler{
    public void deleteCustomer(String id) throws  Exception;
    public ArrayList<OrderDto>  showIncome() throws Exception;
     
}
