/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package uts_pbol_2020130024;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author ASUS GAMING
 */
public class FXMLDocumentController implements Initializable {
    public static DBPlayer dtplayer = new DBPlayer();
    
    @FXML
    private Button playbtn;
    @FXML
    private Button exitbtn;
    
    private Stage disStage;
    Stage stage;
    @FXML
    private AnchorPane menupane;
    @FXML
    private Button historybtn;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void playklik(ActionEvent event) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("FXML_Player.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    @FXML
    private void exitklik(ActionEvent event) {
        System.out.println("Exit");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Exit From The Game??? :(");
        alert.setContentText("You'll be playing here again, won't you? ");
        
        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) menupane.getScene().getWindow();
            System.out.println("Come Again!");
            stage.close();
        }
    }

    @FXML
    private void historyklik(ActionEvent event) {
    }
    
}
