/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.service;

import java.util.ArrayList;
import lk.rubictron.posfinal.dto.SuperDto;

/**
 *
 * @author rubictron
 */
public interface SuperService<T extends SuperDto,IdType> {

    public boolean add(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean delete(String id) throws Exception;
    
    public T getByID(String id) throws Exception;

    public ArrayList<T> serch(String id) throws Exception;

    public ArrayList<T> getAll() throws Exception;
    
}
