/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.bussiness;

import java.util.ArrayList;
import lk.rubictron.posfinal.dto.SuperDto;

/**
 *
 * @author rubictron
 */
public interface SuperBussiness<T extends SuperDto, IdType> {

    public boolean add(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public T getByID(String id) throws Exception;

    public boolean delete(IdType id) throws Exception;

    public ArrayList<T> serch(IdType id) throws Exception;

    public ArrayList<T> getAll() throws Exception;

}
