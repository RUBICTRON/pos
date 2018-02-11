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
public class CustomerDto extends SuperDto{
    
    private String customerId;
    private String name;
    private String contact;
    private int salary;

    public CustomerDto(String customerId, String name, String contact, int sallery) {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
        this.salary = sallery;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param sallery the salary to set
     */
    public void setSalary(int sallery) {
        this.salary = sallery;
    }
    
    
    
}
