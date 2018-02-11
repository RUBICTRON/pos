/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dao.mysql.impl;

import lk.rubictron.posfinal.dto.ItemDto;
import lk.rubictron.posfinal.dto.SuperDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.rubictron.posfinal.dao.custom.ItemDAO;




/**
 *
 * @author rubictron
 */
public class ItemDaoImpl implements ItemDAO {

    private Connection connection;

    @Override
    public boolean add(ItemDto t) throws Exception {
        String sql = "INSERT INTO item VALUES (?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, t.getItemId());
        pstm.setObject(2, t.getName());
        pstm.setObject(3, t.getQuantity());
        pstm.setObject(4, t.getUnitPrice());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "DELETE FROM item WHERE itemId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(ItemDto t) throws Exception {

        String sql = "UPDATE item SET name=?, quantity=?, unitPrice=?  WHERE  itemId=?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, t.getName());
        pstm.setObject(2, t.getQuantity());
        pstm.setObject(3, t.getUnitPrice());
        pstm.setObject(4, t.getItemId());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public ArrayList<ItemDto> getAll() throws Exception {
        String sql = "SELECT * FROM item";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ItemDto> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new ItemDto(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4)
            ));
        }
        return list;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<ItemDto> search(String id) throws Exception {
       
      
    String sql = "SELECT * FROM item WHERE itemId LIKE '%" + id + "%' OR name LIKE '%" + id + "%'";
           Statement stm = connection.createStatement();
           ResultSet rst = stm.executeQuery(sql);
           ArrayList<ItemDto> list = new ArrayList<>();
           while (rst.next()) {
                list.add(new ItemDto(
                       rst.getString(1),
                       rst.getString(2),
                       rst.getInt(3),
                      rst.getDouble(4)
                ));

            }
           return list;
        
        
    }

    @Override
    public ItemDto getById(String id) throws Exception {
         String sql = "SELECT * FROM item WHERE ItemId =\"" + id + "\"";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return (new ItemDto(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getInt(4)));
        } else {
            return null;
        }
    }

   
}
