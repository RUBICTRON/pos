/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dao.mysql.impl;

import lk.rubictron.posfinal.dao.ConnectionFactory;
import lk.rubictron.posfinal.dto.LoginDto;
import lk.rubictron.posfinal.dto.SuperDto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.rubictron.posfinal.dao.custom.LoginDAO;

/**
 *
 * @author rubictron
 */
public class LoginDaoImpl implements LoginDAO{
    
   private Connection connection;

    

    @Override
    public void setConnection(Connection connection) {
        this.connection=connection;
    }

    @Override
    public boolean add(SuperDto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(SuperDto t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SuperDto> search(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<SuperDto> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginDto checklog(LoginDto dto) throws Exception {
       
        connection=ConnectionFactory.getInstance().getConnection();
        
        String sql="SELECT * FROM login WHERE `userName` = '"+dto.getUserName()+"' AND `password` = '"+dto.getPassword()+"'";
        Statement stm = connection.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        
        if(rst.next()){ 
        LoginDto dto2=new LoginDto(rst.getString(1), rst.getString(1), rst.getInt(3));
        if(dto2.getPassword()==dto.getPassword()){return null;}
        return dto2;
        }else {
        return null;
        }   
        
        
        
    }

    @Override
    public SuperDto getById(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
