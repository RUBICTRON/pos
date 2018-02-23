/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import lk.rubictron.posfinal.controller.ControlerFactory;
import lk.rubictron.posfinal.controller.custom.LoginControler;
import lk.rubictron.posfinal.controller.custom.impl.LoginControlerImpl;
import lk.rubictron.posfinal.dto.LoginDto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import lk.rubictron.posfinal.controller.custom.CommenControler;

/**
 * FXML Controller class
 *
 * @author rubictron
 */
public class DashbController implements Initializable {

    @FXML
    private AnchorPane ap;

    @FXML
    private AnchorPane apmain;

    @FXML
    private AnchorPane apleft;
    @FXML
    private AnchorPane aptop;
    @FXML
    private JFXButton btnItem;
    @FXML
    private JFXButton btnCustomer;
    @FXML
    private JFXButton btnReport;
    @FXML
    private JFXButton btnPlaseOrder;
    @FXML
    private JFXButton btnManageOrder;
    @FXML
    private Label lblUser;

    private LoginDto user;
    @FXML
    private AnchorPane login;
    @FXML
    private JFXTextField textfUserName;
    @FXML
    private JFXPasswordField textfPassword;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXButton btnRegistor;
    @FXML
    private Label logUser;
    @FXML
    private JFXButton btnLogout;

    private static CommenControler controler;

    public DashbController() {
       

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void clickLoging(MouseEvent event) {
        

    }

    @FXML
    private void clickBtnItem(MouseEvent event) {
        loadAnchor("item");

    }

    @FXML
    private void clickBtnCustomer(MouseEvent event) {
        loadAnchor("customer");

    }

    @FXML
    private void clickBtnReport(MouseEvent event) {
        loadAnchor("report");
    }

    @FXML
    private void clickBtnPlaseOrder(MouseEvent event) {
        loadAnchor("order");

    }

    @FXML
    private void clickBtnManageOrder(MouseEvent event) {

        loadAnchor("orderManage");

    }

    private void loadAnchor(String name) {
        try {
            apmain.getChildren().clear();
            Parent loder = FXMLLoader.load(getClass().getResource("/lk/rubictron/posfinal/view/ui/" + name + ".fxml"));
            apmain.getChildren().add(loder);
          
            
            
            Node n = (Node) loder;
            AnchorPane.setTopAnchor(n, 0.0);
            AnchorPane.setRightAnchor(n, 0.0);
            AnchorPane.setLeftAnchor(n, 0.0);
            AnchorPane.setBottomAnchor(n, 0.0);
        } catch (IOException ex) {
            Logger.getLogger(DashbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

    @FXML
    private void clickBtnRegistor(MouseEvent event) {
    }

    private void log(LoginDto user) {
        lblUser.setText(user.getUserName());
        switch (user.getAccessLevel()) {

            case 1:
                btnCustomer.setDisable(false);
                btnItem.setDisable(false);
                btnPlaseOrder.setDisable(false);
                btnManageOrder.setDisable(false);
                btnReport.setDisable(false);
                break;
            case 2:
                btnCustomer.setDisable(false);
                btnItem.setDisable(false);
                btnPlaseOrder.setDisable(false);
                break;

        }

        
        alart("Login Confirmed");
        login.setVisible(false);

        switch (LoginControlerImpl.getUser().getAccessLevel()) {
            case 1:
                controler = (CommenControler) ControlerFactory.getInstance().getController(ControlerFactory.ControlerType.Admin);
                break;
            case 2:
                controler = (CommenControler) ControlerFactory.getInstance().getController(ControlerFactory.ControlerType.Reception);
                break;
            default:
        }

    }

    public static CommenControler getControler() {

        return controler;
    }

    @FXML
    private void clickLogout(MouseEvent event) {
        
        apmain.getChildren().clear();
        apmain.getChildren().add(login);
        login.setVisible(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Log Out");
        alert.setHeaderText(null);
        alert.setContentText("Thank you for Using Modern Pos System");
        alert.showAndWait();
        lblUser.setText("Login");
        
        btnCustomer.setDisable(true);
        btnItem.setDisable(true);
        btnPlaseOrder.setDisable(true);
        btnManageOrder.setDisable(true);
        btnReport.setDisable(true);

    }

    @FXML
    private void abtnLogout(ActionEvent event) {
    }
    
    
        public void alart(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void clickBtnLogin(ActionEvent event) {
        
        
        try {

            user = new LoginDto(textfUserName.getText(), textfPassword.getText(), -1);
            LoginControler controler = (LoginControler) ControlerFactory.getInstance().getController(ControlerFactory.ControlerType.LOGIN);
            user = controler.CheckUser(user);
            textfPassword.clear();
            
            log(user);
            if (user == null) {
                
                
                textfUserName.setText("Access Deniede");
            } else {

                logUser.setText("Login Confirmed");
                 loadAnchor("order");

            }
        } catch (Exception ex) {
            alart("Access Deniede");
            Logger.getLogger(DashbController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
