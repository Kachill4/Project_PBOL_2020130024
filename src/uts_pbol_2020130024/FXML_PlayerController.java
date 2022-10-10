/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_pbol_2020130024;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS GAMING
 */
public class FXML_PlayerController implements Initializable {

    
    @FXML
    private TableView<PlayerModel> tbvplayer;
    @FXML
    private Button createbtn;
    @FXML
    private Button playbtn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button editbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //showdata(); 
    }   
    
    public void showdata(){
        ObservableList<PlayerModel> data=FXMLDocumentController.dtplayer.Load();
        if(data!=null){            
            tbvplayer.getColumns().clear();
            tbvplayer.getItems().clear();
            
            TableColumn col=new TableColumn("Name");
            col.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("Name"));
            tbvplayer.getColumns().addAll(col);
            
            tbvplayer.setItems(data);
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvplayer.getScene().getWindow().hide();;
        } 
    }
    

    @FXML
    private void createklik(ActionEvent event) {
        try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXML_InputPlayer.fxml"));    
        Parent root = (Parent)loader.load();        
        Scene scene = new Scene(root);        
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);        
        stg.setIconified(false);        
        stg.setScene(scene);
        stg.showAndWait();
        } catch (IOException e){  
            e.printStackTrace();   
        }
        showdata();
        
    }

    @FXML
    private void playklik(ActionEvent event) {
    }

    @FXML
    private void deleteklik(ActionEvent event) {
    }

    @FXML
    private void editklik(ActionEvent event) {
    }
    
}
