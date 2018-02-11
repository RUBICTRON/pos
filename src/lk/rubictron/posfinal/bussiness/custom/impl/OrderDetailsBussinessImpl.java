/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.bussiness.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.custom.OrderDetailsBussiness;
import lk.rubictron.posfinal.dao.DAOFactory;
import lk.rubictron.posfinal.dao.TransactionScope;
import lk.rubictron.posfinal.dao.custom.ItemDAO;
import lk.rubictron.posfinal.dao.custom.OrderDetailsDAO;
import lk.rubictron.posfinal.dto.ItemDto;
import lk.rubictron.posfinal.dto.OrderDetailsDto;

/**
 *
 * @author rubictron
 */
public class OrderDetailsBussinessImpl implements OrderDetailsBussiness {

    private final OrderDetailsDAO orderDetailsDAO;
    private final ItemDAO itemDAO;

    public OrderDetailsBussinessImpl() {

        orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getDAO(DAOFactory.DAOType.ORDER_DETAIL);
        itemDAO = (ItemDAO) DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getDAO(DAOFactory.DAOType.ITEM);
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
    public ArrayList<OrderDetailsDto> serch(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDetailsDto> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetailsDto getByID(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(ArrayList<OrderDetailsDto> array) throws Exception {
        Connection connection=DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection();        
        TransactionScope transaction = DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getTransactionScope();       
        orderDetailsDAO.setConnection(connection);
        itemDAO.setConnection(connection);
        boolean b=false;
        for (OrderDetailsDto orderDetailsDto : array) {
            if (!orderDetailsDAO.add(orderDetailsDto)) {
                transaction.rollback();
                ItemDto item = itemDAO.getById(orderDetailsDto.getItemId());
                item.setQuantity(item.getQuantity() - orderDetailsDto.getQuentity());
                b = itemDAO.update(item);
                if (!b) {
                   transaction.rollback();
                }
            }
        }
         transaction.endConnection();
       return b;
    }
}