/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pi;

import Controller.SpecialiteController;
import Entity.Specialite;
import Utlis.Database;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Mansour
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField txtspec;
    @FXML
    private TableView<Specialite> tvspec;
    @FXML
    private TableColumn<Specialite, Integer> colid;
    @FXML
    private TableColumn<Specialite, String> collibelle;
    @FXML
    private Button btninsert;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    
    ObservableList<Specialite> speclist=FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Connection con;
             con =Database.getInstance().getConnection();
        try {
            //  PreparedStatement preparedStatement;
            ResultSet resultSet = con.createStatement().executeQuery("select * from specialite");
            while(resultSet.next())
            {
                speclist.add(new Specialite(resultSet.getInt("id"),resultSet.getString("libelle")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
                collibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
                tvspec.setItems(speclist);

    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        String libelle= txtspec.getText();
        Specialite p = new Specialite(libelle);
        SpecialiteController sc = new SpecialiteController();
        
        sc.Add(p); 
        // System.out.println("sdqsds");
           
        
    }

    @FXML
    private void supprimer(MouseEvent event) throws SQLException {
     
          
         
                String p = event.getPickResult().getIntersectedNode().getId();
              //  int l = Integer.parseInt(p);
                System.out.println(p);
                   SpecialiteController sc = new SpecialiteController();
                  

         
    }

    
    
    
    public void updateTable()
    {
          colid.setCellValueFactory(new PropertyValueFactory<>("id"));
                collibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
                 tvspec.setItems(speclist);
    }
   
    
}
