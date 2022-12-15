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

    private HistoryModel dt = new HistoryModel();

    public HistoryModel getHistoryModel() {
        return (dt);
    }

    public void setHistoryModel(HistoryModel s) {
        dt = s;
    }

    public ObservableList<HistoryModel> Load() {
        try {
            ObservableList<HistoryModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select HistoryId, GameMode, PlayerId, Date, Time, Score from history where GameMode=1"
            );
            int i = 1;
            while (rs.next()) {
                HistoryModel d = new HistoryModel();
                d.setHistoryId(rs.getInt("HistoryId"));
                d.setGameMode(rs.getInt("GameMode"));
                d.setPlayerId(rs.getInt("PlayerId"));
                d.setDate(rs.getDate("Date"));
                d.setTime(rs.getTime("Time"));
                d.setScore(rs.getInt("Score"));
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
    
    public ObservableList<HistoryModel> Load3() {
        try {
            ObservableList<HistoryModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select HistoryId, GameMode, PlayerId, Date, Time, Score from history where GameMode=3"
            );
            int i = 1;
            while (rs.next()) {
                HistoryModel d = new HistoryModel();
                d.setHistoryId(rs.getInt("HistoryId"));
                d.setGameMode(rs.getInt("GameMode"));
                d.setPlayerId(rs.getInt("PlayerId"));
                d.setDate(rs.getDate("Date"));
                d.setTime(rs.getTime("Time"));
                d.setScore(rs.getInt("Score"));
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

    public int getLastId() {
        try {
            int lastid = 0;
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select MAX(HistoryId) as Id from history"
            );
            int i = 1;
            while (rs.next()) {
                lastid = rs.getInt("Id");
            }
            con.tutupKoneksi();
            int newid = lastid + 1;
            System.out.println(newid);
            return newid;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean insert() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "insert into history (HistoryId,GameMode,PlayerId, Date, Time, Score) values (?,?,?,?,?,?)");
            con.preparedStatement.setInt(1, getHistoryModel().getHistoryId());
            con.preparedStatement.setInt(2, getHistoryModel().getGameMode());
            con.preparedStatement.setInt(3, getHistoryModel().getPlayerId());
            con.preparedStatement.setDate(4, getHistoryModel().getDate());
            con.preparedStatement.setTime(5, getHistoryModel().getTime());
            con.preparedStatement.setInt(6, getHistoryModel().getScore());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

}
