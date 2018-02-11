/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import lk.rubictron.posfinal.service.ServiceFactory;
import lk.rubictron.posfinal.service.custom.OrderDetailsService;

/**
 * FXML Controller class
 *
 * @author rubictron
 */
public class OrderManageController implements Initializable {

    @FXML
    private TableView<?> tableOrderDetails;
    @FXML
    private JFXButton btnSerch;
    @FXML
    private JFXButton btnViewAll;
    @FXML
    private JFXTextField textfSerch;
    
   private OrderDetailsService service;

    public OrderManageController() {
        
       service= (OrderDetailsService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDERDETAILS);
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void abtnSerch(ActionEvent event) {
        
        
        
    }

    @FXML
    private void abtnViewAll(ActionEvent event) {
        
       
        
        
    }
    
}
