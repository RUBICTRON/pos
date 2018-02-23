/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dao.mysql;


import java.sql.Connection;
import lk.rubictron.posfinal.dao.ConnectionFactory;
import lk.rubictron.posfinal.dao.DAOFactory;
import lk.rubictron.posfinal.dao.SuperDAO;
import lk.rubictron.posfinal.dao.TransactionScope;
import lk.rubictron.posfinal.dao.custom.CustomerDAO;
import lk.rubictron.posfinal.dao.custom.ItemDAO;
import lk.rubictron.posfinal.dao.custom.LoginDAO;
import lk.rubictron.posfinal.dao.custom.OrderDAO;
import lk.rubictron.posfinal.dao.custom.OrderDetailsDAO;
import lk.rubictron.posfinal.dao.mysql.impl.CustomerDaoImpl;
import lk.rubictron.posfinal.dao.mysql.impl.ItemDaoImpl;
import lk.rubictron.posfinal.dao.mysql.impl.LoginDaoImpl;
import lk.rubictron.posfinal.dao.mysql.impl.OrderDaoImpl;
import lk.rubictron.posfinal.dao.mysql.impl.OrderDetailsDaoImpl;

/**
 *
 * @author rubictron
 */
public class DAOmySqlFactory extends  DAOFactory{

    private static DAOmySqlFactory factory;
    private final CustomerDAO customer;
    private final ItemDAO item;
    private LoginDAO login;
    private OrderDAO order;
    private OrderDetailsDAO orderDetails;
    private static  Connection connection;
    
  
    
    private DAOmySqlFactory() {
        
        customer=new CustomerDaoImpl();
        item=new ItemDaoImpl();
        login=new LoginDaoImpl();
        order=new OrderDaoImpl();
        orderDetails=new OrderDetailsDaoImpl();
        connection=ConnectionFactory.getInstance().getConnection();
        
    }
   
    public static DAOFactory getInstance(){
        if(factory==null) {factory=new DAOmySqlFactory();}
        return factory;
    }
    
   /* public static TransactionScope getTransactionScope() {
        return new TransactionScope(connection);
    }*/

    @Override
    public SuperDAO getDAO(DAOType type) {
         switch(type){
            case CUSTOMER:return customer;
            case ITEM:return item;
            case LOGIN:return login;
            case ORDER:return order;
            case ORDER_DETAIL:return orderDetails;
            default:return null;
        
    }}

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public  TransactionScope getTransactionScope() {
       return new TransactionScope(connection);
    }


 

    
}
