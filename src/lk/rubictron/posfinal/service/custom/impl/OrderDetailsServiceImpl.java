/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.service.custom.impl;

import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.BussinessFactory;
import lk.rubictron.posfinal.bussiness.SuperBussiness;
import lk.rubictron.posfinal.bussiness.custom.OrderDetailsBussiness;
import lk.rubictron.posfinal.bussiness.custom.impl.OrderDetailsBussinessImpl;
import lk.rubictron.posfinal.service.custom.OrderDetailsService;
import lk.rubictron.posfinal.dto.OrderDetailsDto;
import lk.rubictron.posfinal.service.ServiceFactory;

/**
 *
 * @author rubictron
 */
public class OrderDetailsServiceImpl implements OrderDetailsService{

    private final OrderDetailsBussiness business;

    public OrderDetailsServiceImpl() {
        business=(OrderDetailsBussiness) BussinessFactory.getInstant().getBussiness(ServiceFactory.ServiceType.ORDERDETAILS);
    }
    
    

    @Override
    public boolean add(OrderDetailsDto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrderDetailsDto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetailsDto getByID(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDetailsDto> serch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDetailsDto> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(ArrayList<OrderDetailsDto> array) throws Exception {
      return business.add(array);
    }
    
}
