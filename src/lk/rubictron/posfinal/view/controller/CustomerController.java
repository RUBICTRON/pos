/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import lk.rubictron.posfinal.controller.custom.impl.AdminControlerImpl;
import lk.rubictron.posfinal.dto.CustomerDto;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.rubictron.posfinal.view.util.tablemodel.CustomerTM;
import lk.rubictron.posfinal.controller.custom.CommenControler;
import lk.rubictron.posfinal.dao.ConnectionFactory;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author rubictron
 */
public class CustomerController implements Initializable {

    @FXML
    private AnchorPane root2;
    @FXML
    private JFXTextField textfCustomerId;
    @FXML
    private TableView<CustomerTM> tableCus;
    @FXML
    private JFXTextField textfName;
    @FXML
    private JFXButton btnSerch;
    @FXML
    private JFXTextField textfContact;
    @FXML
    private JFXTextField textfSalary;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnViewAll;

    private CommenControler controler;
    @FXML
    private JFXButton btnCustomerReport;

    public CustomerController() {

        controler = DashbController.getControler();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableCus.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tableCus.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tableCus.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tableCus.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("salary"));
        
         tableCus.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
            
            @Override
            public void changed(ObservableValue<? extends CustomerTM> observable, CustomerTM oldValue, CustomerTM newValue) {
                
                CustomerTM currentRow = observable.getValue();
                
                if (currentRow != null) {
                    textfCustomerId.setText(currentRow.getCustomerId());
                    textfName.setText(currentRow.getName());
                    textfContact.setText(currentRow.getContact());
                    textfSalary.setText(String.valueOf(currentRow.getSalary()));
                      
                }

               
                

            }
        });
    }

    @FXML
    private void clickBtnSerch(MouseEvent event) {

        try {
            String id = textfCustomerId.getText();

            ArrayList<CustomerDto> customer = controler.getSerchCustomers(id);
            ArrayList<CustomerTM> alcus = new ArrayList<CustomerTM>();
            for (CustomerDto dto : customer) {
                alcus.add(new CustomerTM(dto.getCustomerId(), dto.getName(), dto.getContact(), dto.getSalary()));
            }
            ObservableList<CustomerTM> allcus = FXCollections.observableArrayList(alcus);

            tableCus.setItems(allcus);
        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickBtnDelete(MouseEvent event) {

        try {

            String id = tableCus.getSelectionModel().getSelectedItem().getCustomerId();
            AdminControlerImpl controler = (AdminControlerImpl) this.controler;
            controler.deleteCustomer(id);
            clickBtnViewAll(event);

        } catch (Exception ex) {
            
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void clickBtnViewAll(MouseEvent event) {

        try {

            ArrayList<CustomerDto> customer = controler.getAllCustomers();
            ArrayList<CustomerTM> alcus = new ArrayList<CustomerTM>();
            for (CustomerDto dto : customer) {
                alcus.add(new CustomerTM(dto.getCustomerId(), dto.getName(), dto.getContact(), dto.getSalary()));
            }
            ObservableList<CustomerTM> allcus = FXCollections.observableArrayList(alcus);

            tableCus.setItems(allcus);

        } catch (Exception ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void clickBtnSave(MouseEvent event) {

        try {
            CustomerDto dto = new CustomerDto(
                    textfCustomerId.getText(),
                    textfName.getText(),
                    textfContact.getText(),
                    Integer.parseInt(textfSalary.getText()));

            controler.saveCustomer(dto);
            clickBtnSerch(event);
            
        } catch (Exception ex) {

            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alart(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void abtnCustomerReport(ActionEvent event) {
        try {
            JasperReport compiledReport = (JasperReport) JRLoader.loadObject(ItemController.class.getResourceAsStream("/lk/rubictron/posfinal/view/report/customer.jasper"));
            
            HashMap<String, Object> reportParams = new HashMap<>();
            
            JasperPrint filledReport = JasperFillManager.fillReport(compiledReport, reportParams, ConnectionFactory.getInstance().getConnection());
            
            JasperViewer.viewReport(filledReport); 
        } catch (JRException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
