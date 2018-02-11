/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.controller.custom.impl;

import lk.rubictron.posfinal.controller.custom.LoginControler;
import lk.rubictron.posfinal.dao.DAOFactory;
import lk.rubictron.posfinal.dao.mysql.impl.LoginDaoImpl;
import lk.rubictron.posfinal.dto.LoginDto;
import lk.rubictron.posfinal.service.ServiceFactory;
import lk.rubictron.posfinal.service.custom.impl.LoginServiceImpl;

/**
 *
 * @author rubictron
 */
public class LoginControlerImpl  implements LoginControler{

    private static LoginDto user;
    @Override
    
    public LoginDto CheckUser(LoginDto dto) throws Exception {
        
        LoginServiceImpl service= (LoginServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.LOGIN);
        
     /*   LoginDaoImpl dao= (LoginDaoImpl) DAOFactory.getDAOFactory(DAOFactory.FactoryType.MYSQL).getDAO(DAOFactory.DAOType.LOGIN);
        user=dao.checklog(dto);*/
     user=service.CheckUser(dto);
        
        return user;
        
    }

    /**
     *
     * @return 
     */
    public static LoginDto getUser(){
        
    return LoginControlerImpl.user;
    };

    @Override
    public boolean addUser() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   
    
    
}
