/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS GAMING
 */
public class FXML_InputPlayerController implements Initializable {

    @FXML
    private TextField txtnama;
    @FXML
    private Button btnsimpan;
    @FXML
    private Button btnbatal;
    @FXML
    private TextField txtid;
    @FXML
    private Button btnbatal1;
    private Stage disStage;
    Stage stage;
    boolean status = false;
    @FXML
    private Button btncancel;
    @FXML
    private AnchorPane menupane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void simpanklik(ActionEvent event) {
        status = true;
        PlayerModel s = new PlayerModel();
        s.setPlayerId(Integer.parseInt(txtid.getText()));
        s.setName(txtnama.getText());
        FXMLDocumentController.dtplayer.setPlayerModel(s);
        btnsimpan.getScene().getWindow().hide();

        //UPDATE
        if (editdata) {
            if (FXMLDocumentController.dtplayer.update()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil diubah", ButtonType.OK);
                a.showAndWait();
                txtnama.setEditable(true);
                batalklik1(event);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal diubah", ButtonType.OK);
                a.showAndWait();
            }
        } else if (FXMLDocumentController.dtplayer.validasi(s.getPlayerId()) <= 0) {
            if (FXMLDocumentController.dtplayer.insert()) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Data berhasil disimpan", ButtonType.OK);
                a.showAndWait();                
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "Data gagal disimpan", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data sudah ada", ButtonType.OK);
            a.showAndWait();
            txtnama.requestFocus();
        }
            //cancelklik(event);
    }

    @FXML
    private void cancelklik(ActionEvent event) {
//       stage.close();
            btncancel.getScene().getWindow().hide();
    }
    
    
    boolean editdata = false;
    public void execute(PlayerModel d) {
        if (!d.getName().isEmpty()) {
            editdata = true;
            txtid.setText(String.valueOf(d.getPlayerId()));
            txtnama.setText(d.getName());
            txtid.setEditable(false);
            txtnama.requestFocus();
            btnbatal.setDisable(true);
        }
    }
    

    
   
    @FXML
    private void batalklik(ActionEvent event) {
        txtid.clear();
    }

    @FXML
    private void batalklik1(ActionEvent event) {
        txtnama.clear();
    }


}
