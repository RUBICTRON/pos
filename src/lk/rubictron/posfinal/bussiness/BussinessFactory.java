/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.bussiness;

import lk.rubictron.posfinal.bussiness.custom.impl.CustomerBussinessImpl;
import lk.rubictron.posfinal.bussiness.custom.impl.ItemBussinessImpl;
import lk.rubictron.posfinal.bussiness.custom.impl.LoginBussinessImpl;
import lk.rubictron.posfinal.bussiness.custom.impl.OrderBussinessImpl;
import lk.rubictron.posfinal.bussiness.custom.impl.OrderDetailsBussinessImpl;
import lk.rubictron.posfinal.service.ServiceFactory;

/**
 *
 * @author rubictron
 */
public class BussinessFactory {
    
    private static BussinessFactory factory; 
    private ItemBussinessImpl item;
    private CustomerBussinessImpl customer;
    private OrderBussinessImpl order;
    private OrderDetailsBussinessImpl orderDetails;
    private LoginBussinessImpl log;

    private BussinessFactory() {
        item=new ItemBussinessImpl();
        customer=new CustomerBussinessImpl();
        order=new OrderBussinessImpl();
        orderDetails=new OrderDetailsBussinessImpl();
        log=new LoginBussinessImpl();
    }
    
    public static BussinessFactory getInstant(){
    
        if(factory==null){factory=new BussinessFactory();}
        return factory;
    
    
    }
    
    
        public SuperBussiness getBussiness(ServiceFactory.ServiceType type) {

        switch (type) {

            case ITEM:
                return item;
            case CUSTOMER:
                return customer;
            case ORDER:
                return order;
            case ORDERDETAILS:
                return orderDetails;
            case LOGIN:
                return log;
            default:
                return null;

        }

    }
}
