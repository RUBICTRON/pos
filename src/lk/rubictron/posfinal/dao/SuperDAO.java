/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dao;

import lk.rubictron.posfinal.dto.SuperDto;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * @author rubictron
 */
public interface SuperDAO<T extends SuperDto, IdType> {

    boolean add(T t) throws Exception;

    boolean update(T t) throws Exception;

    boolean delete(IdType id) throws Exception;

    T getById(IdType id) throws Exception;

    ArrayList<T> search(IdType id) throws Exception;

    ArrayList<T> getAll() throws Exception;

    void setConnection(Connection connection);
}
