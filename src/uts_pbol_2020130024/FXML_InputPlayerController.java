/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_pbol_2020130024;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    @FXML
    private Button btncancel;
    @FXML
    private AnchorPane menupane;
    private Stage disStage;
    Stage stage;
    boolean status = false;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    int id=0;
    public int tambahid(){
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement(); //ERROR
            ResultSet rs = con.statement.executeQuery("select max(PlayerId) as jml from player");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        id = val + 1;
        return id;
    }
    
    @FXML
    private void simpanklik(ActionEvent event) {
        int NewId = tambahid();
        status = true;
        PlayerModel s = new PlayerModel();
        s.setPlayerId(NewId);
        s.setName(txtnama.getText());
        s.setGame1(0);
        s.setGame2(0);
        s.setGame3(0);
        s.setGame4(0);
        s.setGame5(0);
        
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
