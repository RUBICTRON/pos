/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dao;

import java.sql.Connection;
import lk.rubictron.posfinal.dao.mysql.DAOmySqlFactory;

/**
 *
 * @author rubictron
 */
public abstract class DAOFactory {

    private static DAOFactory factory;

    public enum FactoryType {
        MYSQL, FILE
    }

    public enum DAOType {
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL, LOGIN
    }
    /**
     *
     */
    public abstract SuperDAO getDAO(DAOType type);
    public abstract Connection getConnection();
    public abstract TransactionScope getTransactionScope();

    public static DAOFactory getDAOFactory(FactoryType type) {

        switch (type) {

            case MYSQL:
                return DAOmySqlFactory.getInstance();
            case FILE:
                return null;
            default:
                return null;

        }

    }

}
