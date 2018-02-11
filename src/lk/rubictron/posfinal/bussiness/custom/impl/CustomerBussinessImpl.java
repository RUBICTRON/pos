/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.bussiness.custom.impl;

import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.custom.CustomerBussiness;
import lk.rubictron.posfinal.dao.DAOFactory;
import lk.rubictron.posfinal.dao.custom.CustomerDAO;
import lk.rubictron.posfinal.dto.CustomerDto;

/**
 *
 * @author rubictron
 */
public class CustomerBussinessImpl implements CustomerBussiness {

    private CustomerDAO customerDAO;

    public CustomerBussinessImpl() {

        customerDAO = (CustomerDAO) DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getDAO(DAOFactory.DAOType.CUSTOMER);
    }

    @Override
    public boolean add(CustomerDto t) throws Exception {
        customerDAO.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return customerDAO.add(t);
    }

    @Override
    public boolean update(CustomerDto t) throws Exception {
        customerDAO.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return customerDAO.update(t);

    }

    @Override
    public boolean delete(String id) throws Exception {
        customerDAO.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return customerDAO.delete(id);

    }

    @Override
    public ArrayList<CustomerDto> serch(String id) throws Exception {
        customerDAO.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return customerDAO.search(id);
    }

    @Override
    public ArrayList<CustomerDto> getAll() throws Exception {
        customerDAO.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return customerDAO.getAll();
    }

    @Override
    public CustomerDto getByID(String id) throws Exception {
        customerDAO.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return customerDAO.getById(id);

    }

}
