/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.view.util.tablemodel;

/**
 *
 * @author rubictron
 */
public class OrderTM {
    private String itemId;
    private String itemName;
    private double unitPrice;
    private int quentity;
    private double total;

    public OrderTM(String itemId, String itemName, double unitPrice, int quentity, double total) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.quentity = quentity;
        this.total = total;
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
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the quentity
     */
    public int getQuentity() {
        return quentity;
    }

    /**
     * @param quentity the quentity to set
     */
    public void setQuentity(int quentity) {
        this.quentity = quentity;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
    
}
