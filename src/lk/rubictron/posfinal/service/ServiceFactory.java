/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.service;

import lk.rubictron.posfinal.service.custom.impl.CustomerServiceImpl;
import lk.rubictron.posfinal.service.custom.impl.ItemServiceImpl;
import lk.rubictron.posfinal.service.custom.impl.LoginServiceImpl;
import lk.rubictron.posfinal.service.custom.impl.OrderDetailsServiceImpl;
import lk.rubictron.posfinal.service.custom.impl.OrderServiceImpl;

/**
 *
 * @author rubictron
 */
public class ServiceFactory {

    private static ServiceFactory factory;
    private ItemServiceImpl item;
    private CustomerServiceImpl customer;
    private OrderDetailsServiceImpl orderDetails;
    private OrderServiceImpl order;
    private LoginServiceImpl log;

    public enum ServiceType {
        ITEM, CUSTOMER, ORDER, ORDERDETAILS, LOGIN
    }

    private ServiceFactory() {

        item = new ItemServiceImpl();
        customer = new CustomerServiceImpl();
        order = new OrderServiceImpl();
        orderDetails = new OrderDetailsServiceImpl();
        log = new LoginServiceImpl();

    }

    public static ServiceFactory getInstance() {

        if (factory == null) {
            factory = new ServiceFactory();
        }

        return factory;

    }

    public SuperService getService(ServiceType type) {

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
