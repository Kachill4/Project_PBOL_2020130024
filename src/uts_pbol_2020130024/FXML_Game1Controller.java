/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package uts_pbol_2020130024;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.application.Platform;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import java.text.SimpleDateFormat;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS GAMING
 */
public class FXML_Game1Controller implements Initializable {

    @FXML
    private Label txtsoal;
    @FXML
    private Label label;
    @FXML
    private TextField tfjawab;
    @FXML
    private Label txtscore;
    @FXML
    private Label txttime;

    private Stage disStage;
    Stage stage;

    int x = number(1, 10);
    int y = number(1, 10);
    int jawab;

    String operator = operator();
    int answer = solve(x, y, operator);
    String question = x + " " + operator + " " + y + " = ";

    int counter = 10;
    Timer t = new Timer();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy,hh:mm:ss");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        while (answer < 0 || answer % 1 != 0) {
            x = number(1, 10);
            y = number(1, 10);
            operator = operator();
            answer = solve(x, y, operator);
        }
        txtsoal.setText(question);
        timer();
//        
    }
    boolean status = false;

    public void timer() {
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    txttime.setText(String.valueOf(counter));
                    int i = 0;
                    if (counter > 0) {
                        counter--;
                    } else if (status == true) {
                        txttime.setText(String.valueOf(i));
                    } else if (counter == 0 && status == false) {
                        status = true;
                        txttime.setText(String.valueOf(i));
                        Alert al = new Alert(Alert.AlertType.ERROR,
                                "Waktunya Sudah Habis" + "\nKamu mendapatkan " + poin + " poin", ButtonType.OK);
                        al.showAndWait();
                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Menu.fxml"));
                            txttime.getScene().getWindow().hide();
                            Parent root = (Parent) loader.load();
                            Scene scene = new Scene(root);
                            Stage stg = new Stage();
                            stg.initModality(Modality.APPLICATION_MODAL);
                            stg.setResizable(false);
                            stg.setIconified(false);
                            stg.setScene(scene);
                            stg.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }, 0, 1000);
    }

    public static int number(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static String operator() {
        String[] operations = {"+", "-", "*", "/"};
        return operations[number(0, 3)];
    }

    public static int solve(int x, int y, String operator) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            case "/":
                return x / y;
            default:
                return -999;
        }
    }
    int poin = 0;

    @FXML
    private void jwbklik(KeyEvent event) {
        int j = Integer.parseInt(tfjawab.getText());
        if (event.getCode().equals(KeyCode.ENTER)) {
            if (j == answer) {
                x = number(1, 10);
                y = number(1, 10);
                operator = operator();
                answer = solve(x, y, operator);

                while (answer < 0 || answer % 1 != 0) {
                    x = number(1, 10);
                    y = number(1, 10);
                    operator = operator();
                    answer = solve(x, y, operator);
                }

                question = x + " " + operator + " " + y + " = ";
                txtsoal.setText(question);

                tfjawab.setText("");
                tfjawab.requestFocus();
                poin++;

                txtscore.setText(String.valueOf(poin));
            } else {
                Alert al = new Alert(Alert.AlertType.ERROR,
                        "Jawaban Kamu Salah" + "\nKamu mendapatkan " + poin + " poin", ButtonType.OK);
                al.showAndWait();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("FXML_Menu.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        

    }

}
