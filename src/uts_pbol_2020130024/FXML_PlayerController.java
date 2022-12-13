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
import static javafx.fxml.FXMLLoader.load;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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

    private Stage disStage;
    Stage stage;
    @FXML
    private Button backbtn;
    private Label displayhello;
    private Label displaynama;
    private Label txtnama;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showdata();
    }

    public void showdata() {
        ObservableList<PlayerModel> data = FXMLDocumentController.dtplayer.Load();
        //tbvplayer.setItems(tbvplayer.getSelectionModel().selectedIndexProperty().intValue());
        if (data != null) {
            tbvplayer.getColumns().clear();
            tbvplayer.getItems().clear();

            TableColumn col = new TableColumn("PlayerId");
            col.setCellValueFactory(new PropertyValueFactory<PlayerModel, Integer>("PlayerId"));
            tbvplayer.getColumns().addAll(col);

            col = new TableColumn("Name");
            col.setCellValueFactory(new PropertyValueFactory<PlayerModel, String>("Name"));
            tbvplayer.getColumns().addAll(col);

            tbvplayer.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "Data kosong", ButtonType.OK);
            a.showAndWait();
            tbvplayer.getScene().getWindow().hide();
        }
    }

    public void tampilnama() {
        PlayerModel np = new PlayerModel();
        np = tbvplayer.getSelectionModel().getSelectedItem();
        displayhello.setText("Hello!!!");
        displaynama.setText(np.getName());
    }

    @FXML
    private void createklik(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputPlayer.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showdata();
    }

    private int hasil = 1;
    private String namahasil = "";
    public int getHasil(){return(hasil);}

    public String getNamahasil() {
        return (namahasil);
    }

    @FXML
    private void playklik(ActionEvent event) {
        int pilihan = tbvplayer.getSelectionModel().getSelectedCells().get(0).getRow();
        namahasil = tbvplayer.getItems().get(pilihan).getName();
        if(hasil == 1){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Menu.fxml"));
            Parent root = (Parent) loader.load();
//            Parent root = FXMLLoader.load(getClass().getResource("FXML_Menu.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            FXML_PlayerController isidt = (FXML_PlayerController) loader.getController();
            if (isidt.getHasil() == 1) {
                txtnama.setText(isidt.getNamahasil());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        }else {Alert a = new Alert(Alert.AlertType.ERROR, "Pilih Nama Terlebih dahulu", ButtonType.OK);
            a.showAndWait();}

    }

    @FXML
    private void deleteklik(ActionEvent event) {
        PlayerModel s = new PlayerModel();
        s = tbvplayer.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Mau dihapus?",
                ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLDocumentController.dtplayer.delete(String.valueOf(s.getPlayerId()))) {
                Alert b = new Alert(Alert.AlertType.INFORMATION,
                        "Data berhasil dihapus", ButtonType.OK);
                b.showAndWait();
            } else {
                Alert b = new Alert(Alert.AlertType.ERROR,
                        "Data gagal dihapus", ButtonType.OK);
                b.showAndWait();
            }
            showdata();
        }
    }

    @FXML
    private void editklik(ActionEvent event) {
        PlayerModel s = new PlayerModel();
        s = tbvplayer.getSelectionModel().getSelectedItem();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_InputPlayer.fxml"));
            Parent root = (Parent) loader.load();
            FXML_InputPlayerController isidt = (FXML_InputPlayerController) loader.getController();
            isidt.execute(s);
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
        showdata();
    }

    @FXML
    private void backklik(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
