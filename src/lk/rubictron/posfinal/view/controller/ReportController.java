/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.view.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import lk.rubictron.posfinal.dto.OrderDto;
import lk.rubictron.posfinal.service.ServiceFactory;
import lk.rubictron.posfinal.service.custom.OrderService;

/**
 * FXML Controller class
 *
 * @author rubictron
 */
public class ReportController implements Initializable {

    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private JFXButton btnAllOrdersId;
    @FXML
    private JFXButton btnAllOrdersDate;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    @SuppressWarnings("unchecked")
    public void initialize(URL url, ResourceBundle rb) {
       try {
            // TODO

            OrderService servise = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
            ArrayList<OrderDto> orders;

            orders = servise.getAll();

           
             XYChart.Series series = new XYChart.Series();
            series.setName("All Orders");
            series.getData().clear();
            for (OrderDto dto : orders) {
                series.getData().add(new XYChart.Data(dto.getDate(), dto.getTotalPrice()));
            }

            lineChart.getData().clear();

            lineChart.getData().add(series);

        } catch (Exception ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    @FXML
    private void abtnAllOrdersId(ActionEvent event) {
        
         try {
            // TODO

            OrderService servise = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
            ArrayList<OrderDto> orders;

            orders = servise.getAll();

           
             XYChart.Series series = new XYChart.Series();
            series.setName("All Orders");
            series.getData().clear();
            for (OrderDto dto : orders) {
                series.getData().add(new XYChart.Data(dto.getOrderId(), dto.getTotalPrice()));
            }

            lineChart.getData().clear();

            lineChart.getData().add(series);

        } catch (Exception ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abtnAllOrdersDate(ActionEvent event) {
        
          try {
            // TODO

            OrderService servise = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
            ArrayList<OrderDto> orders;

            orders = servise.getAll();

           
             XYChart.Series series = new XYChart.Series();
            series.setName("All Orders");
            series.getData().clear();
            for (OrderDto dto : orders) {
                series.getData().add(new XYChart.Data(dto.getDate(), dto.getTotalPrice()));
            }

            lineChart.getData().clear();

            lineChart.getData().add(series);

        } catch (Exception ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
