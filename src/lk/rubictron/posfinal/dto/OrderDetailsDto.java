/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dto;

/**
 *
 * @author rubictron
 */
public class OrderDetailsDto extends SuperDto {
    
    private String orderId;
    private String itemId;
    private int quentity;

    public OrderDetailsDto(String orderId, String itemId, int quentity) {
        this.orderId = orderId;
        this.itemId = itemId;
        this.quentity = quentity;
    }



    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     * @return the quantity
     */
    public int getQuentity() {
        return quentity;
    }

    /**
     * @param quentity the quantity to set
     */
    public void setQuentity(int quentity) {
        this.quentity = quentity;
    }
    
    
    
    
}
