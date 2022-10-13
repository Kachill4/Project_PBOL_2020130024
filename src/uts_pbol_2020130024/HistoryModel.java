/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_pbol_2020130024;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ASUS GAMING
 */
public class HistoryModel {
    public int HistoryId, GameMode, PlayerId, Score;
    public Time Time;
    private Date start;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public int getHistoryId() {
        return HistoryId;
    }

    public void setHistoryId(int HistoryId) {
        this.HistoryId = HistoryId;
    }

    public int getGameMode() {
        return GameMode;
    }

    public void setGameMode(int GameMode) {
        this.GameMode = GameMode;
    }

    public int getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(int PlayerId) {
        this.PlayerId = PlayerId;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public Time getTime() {
        return Time;
    }

    public void setTime(Time Time) {
        this.Time = Time;
    }
}
