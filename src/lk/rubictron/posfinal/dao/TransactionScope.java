/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rubictron
 */
public class TransactionScope {

    private Connection connection;

    public TransactionScope(Connection connection) {
        this.connection = connection;
    }

    public void beginConnection() {
        if (connection != null) {
            try {
                connection.setAutoCommit(false);
            } catch (SQLException ex) {
                Logger.getLogger(TransactionScope.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void endConnection() {
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(TransactionScope.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void rollback() {
        if (connection != null) {
        }
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionScope.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
