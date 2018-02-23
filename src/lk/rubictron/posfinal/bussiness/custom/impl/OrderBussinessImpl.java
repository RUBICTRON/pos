/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.bussiness.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.custom.OrderBussiness;
import lk.rubictron.posfinal.dao.DAOFactory;
import lk.rubictron.posfinal.dao.TransactionScope;
import lk.rubictron.posfinal.dao.custom.ItemDAO;
import lk.rubictron.posfinal.dao.custom.OrderDAO;
import lk.rubictron.posfinal.dao.custom.OrderDetailsDAO;
import lk.rubictron.posfinal.dto.ItemDto;
import lk.rubictron.posfinal.dto.OrderDetailsDto;
import lk.rubictron.posfinal.dto.OrderDto;

/**
 *
 * @author rubictron
 */
public class OrderBussinessImpl implements OrderBussiness {
    
     OrderDAO orderDAO;
     OrderDetailsDAO orderDetailsDAO;
      ItemDAO itemDAO;
      TransactionScope transaction;

    public OrderBussinessImpl() {
        
         orderDAO = (OrderDAO) DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getDAO(DAOFactory.DAOType.ORDER);
         orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getDAO(DAOFactory.DAOType.ORDER_DETAIL);
         itemDAO = (ItemDAO) DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getDAO(DAOFactory.DAOType.ITEM);
      
        
        
        transaction=DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getTransactionScope();//=new TransactionScope(connection);
        
        transaction.beginConnection();

    }
    
    

    @Override
    public boolean add(OrderDto t) throws Exception {
         Connection connection = DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection();
          TransactionScope transaction = DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getTransactionScope(); 
          transaction.beginConnection();
        orderDAO.setConnection(connection);
            return orderDAO.add(t);
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
    public ArrayList<OrderDto> serch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDto> getAll() throws Exception {
        orderDAO.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return orderDAO.getAll();
    }

    @Override
    public OrderDto getByID(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastID() throws Exception {
       orderDAO.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
       return orderDAO.getLastId();
    }


}
