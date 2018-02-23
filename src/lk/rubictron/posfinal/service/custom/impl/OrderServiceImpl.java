/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.service.custom.impl;

import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.BussinessFactory;
import lk.rubictron.posfinal.bussiness.SuperBussiness;
import lk.rubictron.posfinal.bussiness.custom.OrderBussiness;
import lk.rubictron.posfinal.dto.OrderDetailsDto;
import lk.rubictron.posfinal.service.custom.OrderDetailsService;
import lk.rubictron.posfinal.service.custom.OrderService;
import lk.rubictron.posfinal.dto.OrderDto;
import lk.rubictron.posfinal.service.ServiceFactory;

/**
 *
 * @author rubictron
 */
public class OrderServiceImpl implements OrderService{

    private final OrderBussiness orderBussinuss;

    public OrderServiceImpl() {
        orderBussinuss=(OrderBussiness) BussinessFactory.getInstant().getBussiness(ServiceFactory.ServiceType.ORDER);
    }
    
    

    @Override
    public boolean add(OrderDto t) throws Exception {
      return orderBussinuss.add(t);
    }

    @Override
    public boolean update(OrderDto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDto getByID(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDto> serch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDto> getAll() throws Exception {
        return orderBussinuss.getAll();
    }

    @Override
    public String getLastId() throws Exception {
    return orderBussinuss.getLastID();
    }


    
}
