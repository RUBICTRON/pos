/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.service.custom.impl;

import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.BussinessFactory;
import lk.rubictron.posfinal.bussiness.custom.LoginBussiness;
import lk.rubictron.posfinal.service.custom.LoginServise;
import lk.rubictron.posfinal.dto.LoginDto;
import lk.rubictron.posfinal.service.ServiceFactory;

/**
 *
 * @author rubictron
 */
public class LoginServiceImpl implements LoginServise{

    @Override
    public boolean add(LoginDto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(LoginDto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginDto getByID(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LoginDto> serch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LoginDto> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginDto CheckUser(LoginDto t) throws Exception {
        LoginBussiness Bussiness=(LoginBussiness) BussinessFactory.getInstant().getBussiness(ServiceFactory.ServiceType.LOGIN);
        return Bussiness.checkUser(t);
    
    }
    
}
