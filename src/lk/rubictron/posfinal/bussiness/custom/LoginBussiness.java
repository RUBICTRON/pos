/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.bussiness.custom;

import lk.rubictron.posfinal.bussiness.SuperBussiness;
import lk.rubictron.posfinal.dto.LoginDto;
import lk.rubictron.posfinal.dto.SuperDto;

/**
 *
 * @author rubictron
 */
public interface LoginBussiness extends SuperBussiness<LoginDto,String>{
    public LoginDto checkUser(LoginDto t) throws Exception;
}
