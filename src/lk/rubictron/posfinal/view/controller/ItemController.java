/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import lk.rubictron.posfinal.dto.ItemDto;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.rubictron.posfinal.view.util.tablemodel.ItemTM;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import lk.rubictron.posfinal.controller.custom.CommenControler;
import lk.rubictron.posfinal.dao.ConnectionFactory;
import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.LocalJasperReportsContext;
import net.sf.jasperreports.engine.util.SimpleFileResolver;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author rubictron
 */
public class ItemController implements Initializable {

    @FXML
    private AnchorPane root2;
    @FXML
    private JFXTextField textfItemId;
    @FXML
    private JFXTextField textfName;
    @FXML
    private JFXButton btnSerch;
    @FXML
    private JFXTextField textfQuentity;
    @FXML
    private JFXTextField textfUnitPrice;
    
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnViewAll;

    private CommenControler controler;
    @FXML
    private TableView<ItemTM> tableItem;
    @FXML
    private JFXButton btnItemReport;

    public ItemController() {

        controler = DashbController.getControler();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemId"));
        tableItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tableItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tableItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tableItem.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ItemTM>() {
            
            @Override
            public void changed(ObservableValue<? extends ItemTM> observable, ItemTM oldValue, ItemTM newValue) {
                
                ItemTM currentRow = observable.getValue();
                
                if (currentRow != null) {
                    textfItemId.setText(currentRow.getItemId());
                    textfName.setText(currentRow.getName());
                    textfQuentity.setText(String.valueOf(currentRow.getQuantity()));
                    textfUnitPrice.setText(String.valueOf(currentRow.getUnitPrice()));
                      
                }

               
                

            }
        });
        
        abtnViewAll(new ActionEvent());
        
        
        
        
    }

    @FXML
    private void abtnSerch(ActionEvent event) {
        try {
            ArrayList<ItemDto> item = controler.getSerchItems(textfItemId.getText());
            ArrayList<ItemTM> alitem = new ArrayList<ItemTM>();
            for (ItemDto dto : item) {
                alitem.add(new ItemTM(dto.getItemId(),dto.getName(),dto.getQuantity(),dto.getUnitPrice()));
            }
            ObservableList<ItemTM> allcus = FXCollections.observableArrayList(alitem);

            tableItem.setItems(allcus);
        } catch (Exception ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void abtnSave(ActionEvent event) {
        
        try {
            ItemDto dto = new ItemDto(
                    textfItemId.getText(),
                    textfName.getText(),
                    Integer.parseInt(textfQuentity.getText()),
                   Double.parseDouble(textfUnitPrice.getText()));

            controler.saveItem(dto);
            
            abtnSerch(event);
            
        } catch (Exception ex) {

            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abtnDelete(ActionEvent event) {
 try {

            String id = tableItem.getSelectionModel().getSelectedItem().getItemId();
            controler.deleteItem(id);
            abtnViewAll(event);

        } catch (Exception ex) {
            
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abtnViewAll(ActionEvent event) {
        

        try {
            ArrayList<ItemDto> item = controler.getAllItems();
            ArrayList<ItemTM> alitem = new ArrayList<ItemTM>();
            for (ItemDto dto : item) {
                alitem.add(new ItemTM(dto.getItemId(),dto.getName(),dto.getQuantity(),dto.getUnitPrice()));
            }
            ObservableList<ItemTM> allcus = FXCollections.observableArrayList(alitem);

            tableItem.setItems(allcus);
        } catch (Exception ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @FXML
    private void abtnItemReport(ActionEvent event) {
        try {
            JasperReport compiledReport = (JasperReport) JRLoader.loadObject(ItemController.class.getResourceAsStream("/lk/rubictron/posfinal/view/report/item.jasper"));
            
            HashMap<String, Object> reportParams = new HashMap<>();
            
            JasperPrint filledReport = JasperFillManager.fillReport(compiledReport, reportParams, ConnectionFactory.getInstance().getConnection());
            
            JasperViewer.viewReport(filledReport); 
        } catch (JRException ex) {
            Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

}
