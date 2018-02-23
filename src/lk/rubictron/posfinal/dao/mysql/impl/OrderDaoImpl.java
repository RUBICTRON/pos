/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dao.mysql.impl;

import lk.rubictron.posfinal.dto.OrderDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.rubictron.posfinal.dao.custom.OrderDAO;

/**
 *
 * @author rubictron
 */
public class OrderDaoImpl implements OrderDAO {

    private Connection connection;

    @Override
    public boolean add(OrderDto t) throws Exception {
        String sql = "INSERT INTO orders VALUES (?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, t.getOrderId());
        pstm.setObject(2, parseDate(t.getDate()));
        pstm.setObject(3, t.getCustomerId());
        pstm.setObject(4, t.getTotalPrice());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql = "DELETE FROM order WHERE orderId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, id);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean update(OrderDto t) throws Exception {
        String sql = "UPDATE orders SET date=?, customerId=?, totalPrice=? WHERE customerId=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, parseDate(t.getDate()));
        pstm.setObject(2, t.getCustomerId());
        pstm.setObject(3, t.getTotalPrice());
        pstm.setObject(4, t.getOrderId());

        return pstm.executeUpdate() > 0;
    }

    @Override
    public ArrayList<OrderDto> getAll() throws Exception {
        String sql = "SELECT * FROM orders";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<OrderDto> list = new ArrayList<>();

        while (rst.next()) {

            list.add(new OrderDto(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4)));

        }
        return list;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<OrderDto> search(String id) throws Exception {
        String sql = "SELECT * FROM orders WHERE orderId LIKE '%" + id + "%'";
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<OrderDto> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new OrderDto(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
        }

        return list;
    }

    private Date parseDate(String date) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

            return sdf.parse(date);

        } catch (ParseException ex) {
            Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public OrderDto getById(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastId() throws Exception {
        String sql = "select max(orderId) from orders";
        
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        String res = "0000";
        while (rst.next()) {
          res = rst.getString("max(orderId)");
           
        }
        return res;
        
    }

}
