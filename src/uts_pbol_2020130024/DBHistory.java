/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_pbol_2020130024;

import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS GAMING
 */
public class DBHistory {
    private HistoryModel dt=new HistoryModel();    
    public HistoryModel getHistoryModel(){ return(dt);}
    public void setHistoryModel(HistoryModel s){ dt=s;}
    
    public ObservableList<HistoryModel>  Load() {
        try {   
            ObservableList<HistoryModel> TableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select HistoryId, GameMode, PlayerId, Date, Time, Score from history"
            );
            int i = 1;
            while (rs.next()) {
                HistoryModel d=new HistoryModel();
                d.setHistoryId(rs.getInt("HistoryId"));
                d.setGameMode(rs.getInt("GameMode"));
                d.setPlayerId(rs.getInt("PlayerId"));
                d.setStart(rs.getDate("Date"));
                d.setTime(rs.getTime("Time"));
                d.setGameMode(rs.getInt("Score"));
                TableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return TableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
