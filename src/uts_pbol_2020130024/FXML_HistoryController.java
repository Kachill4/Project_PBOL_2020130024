/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_pbol_2020130024;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Date;
import java.sql.Time;

/**
 * FXML Controller class
 *
 * @author ASUS GAMING
 */
public class FXML_HistoryController implements Initializable {

    @FXML
    private Button backbtn;
    
    private Stage disStage;
    Stage stage;
    @FXML
    private TableView<HistoryModel> tbvhistory;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showdata();
    }    
    
    public void showdata(){
        ObservableList<HistoryModel> data=FXMLDocumentController.dthistory.Load();
        if(data!=null){            
            tbvhistory.getColumns().clear();
            tbvhistory.getItems().clear();
            
            TableColumn col=new TableColumn("GameMode");
            col.setCellValueFactory(new PropertyValueFactory<HistoryModel, Integer>("GameMode"));
            tbvhistory.getColumns().addAll(col);
            
            col=new TableColumn("PlayerId");
            col.setCellValueFactory(new PropertyValueFactory<HistoryModel, Integer>("PlayerId"));
            tbvhistory.getColumns().addAll(col);
            
            col=new TableColumn("Date");
            col.setCellValueFactory(new PropertyValueFactory<HistoryModel, Date>("Date"));
            tbvhistory.getColumns().addAll(col);
            
            col=new TableColumn("Time");
            col.setCellValueFactory(new PropertyValueFactory<HistoryModel, Time>("Time"));
            tbvhistory.getColumns().addAll(col);
            
            col=new TableColumn("Score");
            col.setCellValueFactory(new PropertyValueFactory<HistoryModel, Integer>("Score"));
            tbvhistory.getColumns().addAll(col);
            
            tbvhistory.setItems(data);
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvhistory.getScene().getWindow().hide();
        } 
    }
    
    

    @FXML
    private void backklik(ActionEvent event) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
