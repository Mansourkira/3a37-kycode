/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import Entity.Medecin;
import Entity.Specialite;
import Utlis.Database;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import pi.FXMLDocumentController;

/**
 * FXML Controller class
 *
 * @author Mansour
 */
public class MedecinController implements Initializable {
    @FXML
    private TableColumn<Medecin, String> colnom;
    @FXML
    private TableColumn<Medecin, String> colprenom;
    @FXML
    private TableColumn<Medecin, String> coladresse;
    @FXML
    private TableColumn<Medecin, String> colemail;
    @FXML
    private TableColumn<Medecin, String> colshcool;
    @FXML
    private TableColumn<Medecin, String> coltelephone;
    @FXML
    private TableColumn<Medecin, String> colspec;
    @FXML
    private TextField adresse;
    @FXML
    private TextField school;
    @FXML
    private TextField cv;
    @FXML
    private TextField pass;
    @FXML
    private TextField email;
    @FXML
    private TextField prenom;
    @FXML
    private TextField nom;
    @FXML
    private TextField telephone;
    @FXML
    private TextField spec;
    @FXML
    private Button supprimer;
        @FXML
    private TableView<Medecin> tvmedecin;
    /**
     * Initializes the controller class.
     */
        ObservableList<Medecin> medecinlist=FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Connection con;
             con =Database.getInstance().getConnection();
        try {
            //  PreparedStatement preparedStatement;
            ResultSet resultSet = con.createStatement().executeQuery("select * from medecin");
            while(resultSet.next())
            {
                medecinlist.add(new Medecin(resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("adresse"),resultSet.getString("email"),resultSet.getString("school"),resultSet.getString("num_telephone"),resultSet.getInt("specialite_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                                coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
                colshcool.setCellValueFactory(new PropertyValueFactory<>("shcool"));
                coltelephone.setCellValueFactory(new PropertyValueFactory<>("num_telephone"));
                colspec.setCellValueFactory(new PropertyValueFactory<>("specialite_id"));

                tvmedecin.setItems(medecinlist); // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        String name = nom.getText();
        String lname= prenom.getText();
        String adresses=adresse.getText();
        String shcools=school.getText();
        String phone=telephone.getText();
        
      //Medecin p = new Medecin ()
    }

    @FXML
    private void modifier(ActionEvent event) {
        
    }
    
}
