/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.service.custom.impl;

import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.BussinessFactory;
import lk.rubictron.posfinal.bussiness.custom.CustomerBussiness;
import lk.rubictron.posfinal.bussiness.custom.impl.CustomerBussinessImpl;
import lk.rubictron.posfinal.service.custom.CustomerService;
import lk.rubictron.posfinal.dto.CustomerDto;
import lk.rubictron.posfinal.service.ServiceFactory;

/**
 *
 * @author rubictron
 */
public class CustomerServiceImpl implements CustomerService {
    
    private CustomerBussiness bussiness;
    
    public CustomerServiceImpl() {
        
        bussiness =  (CustomerBussiness) BussinessFactory.getInstant().getBussiness(ServiceFactory.ServiceType.CUSTOMER);
    }
    
    @Override
    public boolean add(CustomerDto t) throws Exception {
       return bussiness.add(t);
    }
    
    @Override
    public boolean update(CustomerDto t) throws Exception {
        return bussiness.update(t);
    }
    
    @Override
    public boolean delete(String id) throws Exception {
        return bussiness.delete(id);
       
    }
    
    @Override
    public CustomerDto getByID(String id) throws Exception {
        return bussiness.getByID(id);
       
    }
    
    @Override
    public ArrayList<CustomerDto> serch(String id) throws Exception {
        return bussiness.serch(id);
    }
    
    @Override
    public ArrayList<CustomerDto> getAll() throws Exception {
        return bussiness.getAll();
    }
    
}
