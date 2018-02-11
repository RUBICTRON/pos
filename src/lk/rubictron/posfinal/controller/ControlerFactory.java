/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.controller;

import lk.rubictron.posfinal.controller.custom.AdminControler;
import lk.rubictron.posfinal.controller.custom.impl.AdminControlerImpl;
import lk.rubictron.posfinal.controller.custom.ReceptionControler;
import lk.rubictron.posfinal.controller.custom.impl.LoginControlerImpl;
import lk.rubictron.posfinal.controller.custom.impl.ReceptionControlerImpl;

/**
 *
 * @author rubictron
 */
public class ControlerFactory {

    private static ControlerFactory factory;
    
    private AdminControler admin;
    private ReceptionControler reception;
    private LoginControlerImpl login;
    
    public enum ControlerType{
    Admin,Reception,LOGIN
}

    private ControlerFactory(){
        admin=new AdminControlerImpl();
        reception=new ReceptionControlerImpl();
        login =new LoginControlerImpl();
        
    }

    public static ControlerFactory getInstance(){
        if(factory==null) factory=new ControlerFactory();
        return factory;
    }
    
    public SuperControler getController(ControlerType type){
        switch(type){
            case Admin:return  admin;
            case Reception: return reception;
            case LOGIN: return login;
            default:return null;
        }
    }
    
    
}
