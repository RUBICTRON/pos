/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.controller.custom;

import lk.rubictron.posfinal.controller.SuperControler;
import lk.rubictron.posfinal.dto.LoginDto;

/**
 *
 * @author rubictron
 */
public interface LoginControler extends SuperControler{
     LoginDto CheckUser(LoginDto dto) throws Exception;
     boolean addUser() throws Exception;
}
