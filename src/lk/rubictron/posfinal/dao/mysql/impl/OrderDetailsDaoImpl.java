/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dao.mysql.impl;

import lk.rubictron.posfinal.dto.OrderDetailsDto;
import lk.rubictron.posfinal.dto.SuperDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.rubictron.posfinal.dao.custom.OrderDetailsDAO;

public class OrderDetailsDaoImpl implements OrderDetailsDAO {

    private Connection connection;

    @Override
    public boolean add(OrderDetailsDto t) throws Exception {
        String sql = "INSERT INTO orderDetails VALUES (?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, t.getOrderId());
        pstm.setObject(2, t.getItemId());
        pstm.setObject(3, t.getQuentity());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "DELETE FROM orderDetails WHERE orderId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(OrderDetailsDto t) throws Exception {
        String sql = "UPDATE orderDetails SET itemId=?, quentity=? WHERE orderId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, t.getItemId());
        pstm.setObject(2, t.getQuentity());
        pstm.setObject(3, t.getOrderId());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public ArrayList<OrderDetailsDto> search(String id) throws Exception {
        String sql = "SELECT * FROM orderDetails WHERE customerId LIKE '%" + id + "%'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<OrderDetailsDto> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new OrderDetailsDto(rst.getString(1), rst.getString(2), rst.getInt(3)));
        }

        return list;
    }


@Override
        public ArrayList<OrderDetailsDto> getAll() throws Exception {
        String sql = "SELECT * FROM orderDetails";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<OrderDetailsDto> list = new ArrayList<>();

        while (rst.next()) {

            list.add(new OrderDetailsDto(rst.getString(1), rst.getString(2), rst.getInt(3)));

        }
        return list;
    }

    @Override
        public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public OrderDetailsDto getById(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
