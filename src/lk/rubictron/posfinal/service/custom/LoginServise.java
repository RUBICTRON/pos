/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.service.custom;

import lk.rubictron.posfinal.service.SuperService;
import lk.rubictron.posfinal.dto.LoginDto;

/**
 *
 * @author rubictron
 */
public interface LoginServise extends SuperService<LoginDto, String>{
    public LoginDto CheckUser(LoginDto t) throws Exception;
}
