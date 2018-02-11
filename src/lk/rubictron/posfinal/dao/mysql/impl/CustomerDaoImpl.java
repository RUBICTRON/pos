/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dao.mysql.impl;

import lk.rubictron.posfinal.dto.CustomerDto;
import lk.rubictron.posfinal.dto.SuperDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.rubictron.posfinal.dao.custom.CustomerDAO;

/**
 *
 * @author rubictron
 */
public class CustomerDaoImpl implements CustomerDAO {

    private Connection connection;

    public CustomerDaoImpl() {

    }

    @Override
    public boolean add(CustomerDto t) throws Exception {

        String sql = "INSERT INTO customer VALUES (?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, t.getCustomerId());
        pstm.setObject(2, t.getName());
        pstm.setObject(3, t.getContact());
        pstm.setObject(4, t.getSalary());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {

        String sql = "DELETE FROM customer WHERE customerId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(CustomerDto t) throws Exception {
        String sql = "UPDATE customer SET name=?, contact=?, salary=?  WHERE customerId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, t.getName());
        pstm.setObject(2, t.getContact());
        pstm.setObject(3, t.getSalary());
        pstm.setObject(4, t.getCustomerId());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public ArrayList<CustomerDto> getAll() throws Exception {
        String sql = "SELECT * FROM customer";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<CustomerDto> list = new ArrayList<>();

        while (rst.next()) {

            list.add(new CustomerDto(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4)));

        }
        return list;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<CustomerDto> search(String id) throws Exception {
        String sql = "SELECT * FROM customer WHERE customerId LIKE '%" + id + "%' OR name LIKE '%" + id + "%'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<CustomerDto> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new CustomerDto(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
        }

        return list;
    }

    @Override
    public CustomerDto getById(String id) throws Exception {

        String sql = "SELECT * FROM customer WHERE customerId =\"" + id + "\"";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            return (new CustomerDto(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
        } else {
            return null;
        }
    }

}
