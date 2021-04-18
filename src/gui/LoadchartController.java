/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Mansour
 */
public class LoadchartController implements Initializable {
    @FXML
    private LineChart<String,Number > stat;
    @FXML
    private Button btnchart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              
          String jan ="2021-01";
          String fev ="2021-02";
          String mar ="2021-03";
          String apr ="2021-04";
          String may ="2021-05";
          
          String queryjn="select count(";
          
        XYChart.Series<String,Number> series=new XYChart.Series<String,Number>();        
        series.getData().add(new XYChart.Data<String, Number>("jan",8));
        series.getData().add(new XYChart.Data<String, Number>("fev",2));
        series.getData().add(new XYChart.Data<String, Number>("mar",5));
        series.getData().add(new XYChart.Data<String, Number>("avr",6));
        series.getData().add(new XYChart.Data<String, Number>("mai",9));
        stat.getData().add(series);

       
    }    
    
}
