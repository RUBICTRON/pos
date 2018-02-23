/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.service.custom.impl;

import java.util.ArrayList;
import lk.rubictron.posfinal.bussiness.BussinessFactory;
import lk.rubictron.posfinal.bussiness.SuperBussiness;
import lk.rubictron.posfinal.bussiness.custom.impl.ItemBussinessImpl;
import lk.rubictron.posfinal.service.custom.ItemService;
import lk.rubictron.posfinal.dto.ItemDto;
import lk.rubictron.posfinal.service.ServiceFactory;

/**
 *
 * @author rubictron
 */
public class ItemServiceImpl implements ItemService{

    private ItemBussinessImpl bussiness;

    public ItemServiceImpl() {
        
        bussiness=(ItemBussinessImpl) BussinessFactory.getInstant().getBussiness(ServiceFactory.ServiceType.ITEM);
    }
    
    

    @Override
    public boolean add(ItemDto t) throws Exception {
      return bussiness.add(t);
    }

    @Override
    public boolean update(ItemDto t) throws Exception {
       return bussiness.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return bussiness.delete(id);
    }

    @Override
    public ItemDto getByID(String id) throws Exception {
        return bussiness.getByID(id);
    }

    @Override
    public ArrayList<ItemDto> serch(String id) throws Exception {
        return bussiness.serch(id);
    }

    @Override
    public ArrayList<ItemDto> getAll() throws Exception {
       return bussiness.getAll();
    }
    
}
