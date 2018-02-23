/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.controller.custom;

import lk.rubictron.posfinal.controller.SuperControler;
import lk.rubictron.posfinal.dto.CustomerDto;
import lk.rubictron.posfinal.dto.ItemDto;
import lk.rubictron.posfinal.dto.OrderDetailsDto;
import lk.rubictron.posfinal.dto.OrderDto;
import java.util.ArrayList;

/**
 *
 * @author rubictron
 */
public interface CommenControler extends SuperControler {

    boolean saveCustomer(CustomerDto dto) throws Exception;

    boolean saveItem(ItemDto dto) throws Exception;

    ArrayList<CustomerDto> getAllCustomers() throws Exception;

    ArrayList<ItemDto> getAllItems() throws Exception;

    ArrayList<CustomerDto> getSerchCustomers(String id) throws Exception;

    ArrayList<ItemDto> getSerchItems(String id) throws Exception;

    public void deleteItem(String id) throws Exception;

    CustomerDto getCustomerByID(String Id) throws Exception;

    ItemDto getItemByID(String Id) throws Exception;
    
    String getnewOrderId() throws Exception;

    boolean placeOrder(OrderDto Order, ArrayList<OrderDetailsDto> OrderDetailsArray) throws Exception;

}
