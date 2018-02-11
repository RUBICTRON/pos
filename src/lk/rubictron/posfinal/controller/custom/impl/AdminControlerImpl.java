/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.controller.custom.impl;

import java.util.ArrayList;
import lk.rubictron.posfinal.controller.custom.AdminControler;
import lk.rubictron.posfinal.dao.DAOFactory;
import lk.rubictron.posfinal.dao.ConnectionFactory;
import lk.rubictron.posfinal.dao.SuperDAO;
import lk.rubictron.posfinal.dto.OrderDto;
import lk.rubictron.posfinal.service.ServiceFactory;
import lk.rubictron.posfinal.service.custom.CustomerService;
import lk.rubictron.posfinal.service.custom.OrderService;

/**
 *
 * @author rubictron
 */
public class AdminControlerImpl extends CommonControlerImpl implements AdminControler {

    @Override
    public void deleteCustomer(String id) throws Exception {
        
        CustomerService customerService=(CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
        customerService.delete(id);
    }

    @Override
    public ArrayList<OrderDto> showIncome() throws Exception {
        
        OrderService orderService=(OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
        return orderService.getAll();
     
    }

   

    

}
