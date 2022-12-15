/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_pbol_2020130024;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS GAMING
 */
public class FXML_MenuController implements Initializable {

    @FXML
    private Button game1btn;
    @FXML
    private Button game2btn;
    @FXML
    private Button game5btn;
    @FXML
    private Button game4btn;
    @FXML
    private Button game3btn;
    private Stage disStage;
    Stage stage;
    @FXML
    private Button backbtn;

    public PlayerModel pleyer = new PlayerModel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void game1klik(ActionEvent event) {
        System.out.println(pleyer.getPlayerId());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Game1.fxml"));
//            FXML_MenuController setuserid = loader.getController();
            Parent root = (Parent) loader.load();
            FXML_Game1Controller gemone = loader.getController();
            gemone.execute(pleyer.getPlayerId());
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void game2klik(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML_Game2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void game3klik(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML_Game3.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void game4klik(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML_Game4.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void game5klik(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML_Game5.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void execute(int id) {
        pleyer.setPlayerId(id);
    }
}
