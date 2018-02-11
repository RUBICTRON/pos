/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.controller.custom.impl;

import lk.rubictron.posfinal.dto.CustomerDto;
import lk.rubictron.posfinal.dto.ItemDto;
import java.util.ArrayList;
import lk.rubictron.posfinal.dto.OrderDetailsDto;
import lk.rubictron.posfinal.dto.OrderDto;
import lk.rubictron.posfinal.controller.custom.CommenControler;
import lk.rubictron.posfinal.service.ServiceFactory;
import lk.rubictron.posfinal.service.custom.OrderDetailsService;
import lk.rubictron.posfinal.service.custom.OrderService;
import lk.rubictron.posfinal.service.custom.impl.CustomerServiceImpl;
import lk.rubictron.posfinal.service.custom.impl.ItemServiceImpl;

/**
 *
 * @author rubictron
 */
public class CommonControlerImpl implements CommenControler {

    private final CustomerServiceImpl customrService;
    private final ItemServiceImpl itemService;
    private final OrderService OrderService;
    private final OrderDetailsService orderDetailsService;

    public CommonControlerImpl() {

        customrService = (CustomerServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
        itemService = (ItemServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ITEM);
        OrderService = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
        orderDetailsService = (OrderDetailsService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDERDETAILS);

    }
    
    
       @Override
    public String getnewOrderId() throws Exception {
       String maxId= OrderService.getLastId();
       int i=Integer.parseInt(maxId.substring(3));
       String newId="ODR"+(i+1);
       return newId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean saveCustomer(CustomerDto dto) throws Exception {

        CustomerDto cus = customrService.getByID(dto.getCustomerId());

        if (cus == null) {
            return customrService.add(dto);
        } else {
            return customrService.update(dto);
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<CustomerDto> getAllCustomers() throws Exception {
        return customrService.getAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<ItemDto> getAllItems() throws Exception {

        return itemService.getAll();
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<CustomerDto> getSerchCustomers(String id) throws Exception {
        return customrService.serch(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<ItemDto> getSerchItems(String id) throws Exception {
        return itemService.serch(id);
    }

    @Override

    @SuppressWarnings("unchecked")
    public boolean saveItem(ItemDto dto) throws Exception {

        ItemDto dtoa = itemService.getByID(dto.getItemId());
        if (dtoa == null) {
            return itemService.add(dto);
        } else {
            return itemService.update(dto);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deleteItem(String id) throws Exception {
        itemService.delete(id);

    }

    @Override
    public boolean placeOrder(OrderDto Order, ArrayList<OrderDetailsDto> OrderDetailsArray) throws Exception {

        OrderService.add(Order);
        return orderDetailsService.add(OrderDetailsArray);
        // return OrderService.plaseOrder(Order, OrderDetailsArray);

    }

    @Override
    public CustomerDto getCustomerByID(String Id) throws Exception {

        return customrService.getByID(Id);

    }

    @Override
    public ItemDto getItemByID(String Id) throws Exception {

        return itemService.getByID(Id);

    }



}
