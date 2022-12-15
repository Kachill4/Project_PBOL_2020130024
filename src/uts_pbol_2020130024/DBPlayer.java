/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_pbol_2020130024;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS GAMING
 */
public class DBPlayer {

    private PlayerModel dt = new PlayerModel();

    public PlayerModel getPlayerModel() {
        return (dt);
    }

    public void setPlayerModel(PlayerModel s) {
        dt = s;
    }

    public ObservableList<PlayerModel> Load() {
        try {
            ObservableList<PlayerModel> TableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "Select PlayerId, Name, Game1, Game2, Game3, Game4, Game5 from player"
            );
            int i = 1;
            while (rs.next()) {
                PlayerModel d = new PlayerModel();
                d.setPlayerId(rs.getInt("PlayerId"));
                d.setName(rs.getString("Name"));
                d.setGame1(rs.getInt("Game1"));
                d.setGame2(rs.getInt("Game2"));
                d.setGame3(rs.getInt("Game3"));
                d.setGame4(rs.getInt("Game4"));
                d.setGame5(rs.getInt("Game5"));

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

    public boolean insert() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "insert into player (PlayerId, Name, Game1, Game2, Game3, Game4, Game5) values (?,?,?,?,?,?,?)");
            con.preparedStatement.setInt(1, getPlayerModel().getPlayerId());
            con.preparedStatement.setString(2, getPlayerModel().getName());
            con.preparedStatement.setInt(3, getPlayerModel().getGame1());
            con.preparedStatement.setInt(4, getPlayerModel().getGame2());
            con.preparedStatement.setInt(5, getPlayerModel().getGame3());
            con.preparedStatement.setInt(6, getPlayerModel().getGame4());
            con.preparedStatement.setInt(7, getPlayerModel().getGame5());
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

    public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "update player set Name = ? where PlayerId = ?; ");
            con.preparedStatement.setString(1, getPlayerModel().getName());
            con.preparedStatement.setInt(2, getPlayerModel().getPlayerId());
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

    public boolean delete(String nomor) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "delete from player where PlayerId  = ? "
            );
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public int validasi(int nomor) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "select count(*) as jml from player where PlayerId = '" + nomor + "'");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

}
