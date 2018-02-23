/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.bussiness.custom.impl;

import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.custom.LoginBussiness;
import lk.rubictron.posfinal.dao.ConnectionFactory;
import lk.rubictron.posfinal.dao.DAOFactory;
import lk.rubictron.posfinal.dao.mysql.impl.LoginDaoImpl;
import lk.rubictron.posfinal.dto.LoginDto;

/**
 *
 * @author rubictron
 */
public class LoginBussinessImpl implements LoginBussiness{

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
    public ArrayList<LoginDto> serch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LoginDto> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginDto getByID(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginDto checkUser(LoginDto t) throws Exception {
         LoginDaoImpl dao= (LoginDaoImpl) DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getDAO(DAOFactory.DAOType.LOGIN);
         dao.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
         return dao.checklog(t);
        
        }
    
}
