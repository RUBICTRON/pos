/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import lk.rubictron.posfinal.controller.custom.impl.CommonControlerImpl;
import lk.rubictron.posfinal.dto.CustomerDto;
import lk.rubictron.posfinal.dto.ItemDto;
import lk.rubictron.posfinal.dto.OrderDetailsDto;
import lk.rubictron.posfinal.dto.OrderDto;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.rubictron.posfinal.dao.ConnectionFactory;
import lk.rubictron.posfinal.view.util.tablemodel.OrderTM;
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
public class OrderController implements Initializable {

    @FXML
    private JFXButton btno_add;
    @FXML
    private JFXButton btno_delete;
    @FXML
    private JFXButton btno_confirm;
    @FXML
    private JFXButton btno_confirm1;
    @FXML
    private TableView<OrderTM> tableo;
    @FXML
    private JFXTextField textf_item;
    @FXML
    private JFXComboBox<String> cbox_item;

    @FXML
    private JFXTextField textf_orderId;

    @FXML
    private JFXTextField textf_cusname;

    @FXML
    private JFXComboBox<String> cbox_cus;

    private JFXTextField textf_cusid;
    @FXML
    private JFXDatePicker textf_date;

    private final CommonControlerImpl controler;
    @FXML
    private JFXButton btnSerchItem;
    @FXML
    private JFXButton btnSerchCustomer;
    @FXML
    private JFXTextField textf_itemQty;
    @FXML
    private JFXTextField textf_totalOfOne;
    @FXML
    private JFXTextField textf_total;

    private static ItemDto item;

    ArrayList<OrderTM> orders = new ArrayList<>();
    ObservableList<OrderTM> alorder;

    public OrderController() {

        this.controler = (CommonControlerImpl) DashbController.getControler();
    }

    @FXML
    private void abtnAdd(ActionEvent event) {

        alorder = FXCollections.observableArrayList(orders);
        boolean update = false;
        double sum = 0;
        for (OrderTM oder : orders) {

            if (oder.getItemId() == cbox_item.getSelectionModel().getSelectedItem()) {

                update = true;

                oder.setItemName(textf_item.getText());
                oder.setQuentity(Integer.parseInt(textf_itemQty.getText()));
                oder.setTotal(Double.parseDouble(textf_totalOfOne.getText().substring(8)));
            }
            sum += oder.getTotal();

        }
        if (!update) {

            orders.add(new OrderTM(
                    cbox_item.getSelectionModel().getSelectedItem(),
                    textf_item.getText(),
                    item.getUnitPrice(),
                    Integer.parseInt(textf_itemQty.getText()),
                    Double.parseDouble(textf_totalOfOne.getText().substring(8))
            )
            );

            sum += Double.parseDouble(textf_totalOfOne.getText().substring(8));

        }

        textf_total.setText(String.valueOf(sum));
        alorder = FXCollections.observableArrayList(orders);
        tableo.setItems(alorder);
        tableo.refresh();

    }

    @FXML
    private void abtnDelete(ActionEvent event) {

        OrderTM remove = tableo.getSelectionModel().getSelectedItem();
        double sum = Double.parseDouble(textf_total.getText()) - remove.getTotal();
        textf_total.setText(String.valueOf(sum));
        orders.remove(remove);
        alorder = FXCollections.observableArrayList(orders);
        tableo.setItems(alorder);
        tableo.refresh();
    }

    @FXML
    private void abtnConfirm(ActionEvent event) {
        String id=textf_orderId.getText();
        
        

        try {
            List<OrderTM> orderTM = tableo.getItems();
            ArrayList<OrderDetailsDto> orderArray = new ArrayList<>();

            for (OrderTM order : orderTM) {

                orderArray.add(new OrderDetailsDto(
                        textf_orderId.getText(),
                        order.getItemId(),
                        order.getQuentity())
                );

            }

            OrderDto orderDto = new OrderDto(
                    textf_orderId.getText(),
                    textf_date.getEditor().getText(),
                    cbox_cus.getSelectionModel().getSelectedItem(),
                    Double.parseDouble(textf_total.getText()));

            controler.placeOrder(orderDto, orderArray);
        setNewOrderId();
        textf_item.clear();
        textf_itemQty.clear();
        textf_totalOfOne.clear();
        textf_total.clear();
        
        
        
        JasperReport compiledReport = (JasperReport) JRLoader.loadObject(OrderController.class.getResourceAsStream("/lk/rubictron/posfinal/view/report/order.jasper"));
            
            HashMap<String, Object> reportParams = new HashMap<>();
            reportParams.put("orderId",id);
            
            JasperPrint filledReport = JasperFillManager.fillReport(compiledReport, reportParams, ConnectionFactory.getInstance().getConnection());
            
            JasperViewer.viewReport(filledReport); 
        
        
        
        
        
        
        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void abtnCancel(ActionEvent event) {

    }

    @FXML
    private void clicktextf_cusname(MouseEvent event) {
    }

    @FXML
    private void key_on(KeyEvent event) {
    }

    @FXML
    private void click_cboxcus(MouseEvent event) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableo.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("itemId"));
        tableo.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tableo.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tableo.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("quentity"));
        tableo.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("total"));

        setNewOrderId();
        textf_date.getEditor().setText(String.valueOf(LocalDate.now()));
    

        try {
            ArrayList<ItemDto> item = controler.getAllItems();
            item.forEach((dto) -> {
                cbox_item.getItems().add(dto.getItemId());
            });

            ArrayList<CustomerDto> customer = controler.getAllCustomers();
            customer.forEach((dto) -> {
                cbox_cus.getItems().add(dto.getCustomerId());
            });

        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }

        cbox_cus.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            try {
                String id = observable.getValue();

                CustomerDto customer = controler.getCustomerByID(id);
                textf_cusname.setText(customer.getName());

            } catch (Exception ex) {
                Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        cbox_item.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            try {
                String id = observable.getValue();
                ItemDto item1 = controler.getItemByID(id);
                textf_item.setText(item1.getName());
                textf_totalOfOne.setPromptText("Unit Price :" + item1.getUnitPrice());
                textf_itemQty.setPromptText("Select Quentity from :" + item1.getQuantity());
                OrderController.item = item1;
                textf_itemQty.clear();
                textf_total.clear();
                textf_totalOfOne.clear();
            } catch (Exception ex) {
                Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        tableo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OrderTM>() {
            @Override
            public void changed(ObservableValue<? extends OrderTM> observable, OrderTM oldValue, OrderTM newValue) {

                OrderTM order = observable.getValue();
                
                cbox_item.getSelectionModel().select(order.getItemId());
                
                textf_itemQty.setText(String.valueOf(order.getQuentity()));
                textf_totalOfOne.setText(String.valueOf(order.getTotal()));

            }
        });

    }

    @FXML
    private void abtnSerchItem(ActionEvent event) {
        cbox_item.getItems().clear();
        try {
            ArrayList<ItemDto> item = controler.getSerchItems(textf_item.getText());
            for (ItemDto dto : item) {
                cbox_item.getItems().add(dto.getItemId());
                cbox_item.show();
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abtnSerchCustomer(ActionEvent event) {
        cbox_cus.getItems().clear();
        try {
            ArrayList<CustomerDto> customer = controler.getSerchCustomers(textf_cusname.getText());
            customer.forEach((dto) -> {
                cbox_cus.getItems().add(dto.getCustomerId());
                cbox_cus.show();
            });
        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void atextfUnitPrice(InputMethodEvent event) {

    }

    @FXML
    private void onkeyInQty(KeyEvent event) {

        if (Integer.parseInt(textf_itemQty.getText()) <= item.getQuantity()) {
            textf_totalOfOne.setText("Total = " + (OrderController.item.getUnitPrice() * Integer.parseInt(textf_itemQty.getText())));
        } else {
            textf_totalOfOne.setText("Out of Available Quentity");

        }
    }

    private void setNewOrderId() {
        String oid;
        try {
            oid = controler.getnewOrderId();
            textf_orderId.setText(oid);
        } catch (Exception ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
