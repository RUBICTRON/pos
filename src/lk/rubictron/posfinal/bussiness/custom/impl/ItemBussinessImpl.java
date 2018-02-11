/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.bussiness.custom.impl;

import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.custom.ItemBussiness;
import lk.rubictron.posfinal.dao.DAOFactory;
import lk.rubictron.posfinal.dao.custom.ItemDAO;
import lk.rubictron.posfinal.dto.ItemDto;

/**
 *
 * @author rubictron
 */
public class ItemBussinessImpl implements ItemBussiness {

    private ItemDAO itemDao;

    public ItemBussinessImpl() {
        itemDao = (ItemDAO) DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getDAO(DAOFactory.DAOType.ITEM);
    }

    @Override
    public boolean add(ItemDto t) throws Exception {
        itemDao.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return itemDao.add(t);
    }

    @Override
    public boolean update(ItemDto t) throws Exception {
        itemDao.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return itemDao.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
        itemDao.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return itemDao.delete(id);
    }

    @Override
    public ArrayList<ItemDto> serch(String id) throws Exception {
        itemDao.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return itemDao.search(id);
    }

    @Override
    public ArrayList<ItemDto> getAll() throws Exception {
        itemDao.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return itemDao.getAll();
    }

    @Override
    public ItemDto getByID(String id) throws Exception {
        itemDao.setConnection(DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getConnection());
        return itemDao.getById(id);
    }

}
