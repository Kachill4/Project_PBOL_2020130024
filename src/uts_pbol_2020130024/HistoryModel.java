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
    public Date Date;

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }
//    private Date start;
//
//    public Date getStart() {
//        return start;
//    }
//
//    public void setStart(Date start) {
//        this.start = start;
//    }
    
////////History
    public int getHistoryId() {
        return HistoryId;
    }

    public void setHistoryId(int HistoryId) {
        this.HistoryId = HistoryId;
    }

////////GameMode
    public int getGameMode() {
        return GameMode;
    }

    public void setGameMode(int GameMode) {
        this.GameMode = GameMode;
    }

////////Player
    public int getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(int PlayerId) {
        this.PlayerId = PlayerId;
    }
    
////////Score
    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }
    
////////Time
    public Time getTime() {
        return Time;
    }

    public void setTime(Time Time) {
        this.Time = Time;
    }
}
