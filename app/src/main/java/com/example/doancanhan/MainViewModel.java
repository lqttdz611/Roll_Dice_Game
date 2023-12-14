package com.example.doancanhan;

import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainViewModel extends ViewModel {

    public int  currScore=0, allScore=0, scorePlayer=0;
    Random rand;
    public int r;

    public int getShareScore() {
        return shareScore;
    }

    public void setShareScore(int shareScore) {
        this.shareScore = shareScore;
    }

    public int shareScore=0;

    public void createRandom() {
        rand = new Random();
        r = rand.nextInt(6) + 1;


    }


    public void holdFunc() {
        allScore += currScore;
        shareScore+=currScore;
        currScore=0;
    }

    public int getCurrScore() {
        return currScore;
    }

    public void setCurrScore(int currScore) {
        this.currScore = currScore;
    }

    public int getAllScore() {
        return allScore;
    }

    public void setAllScore(int allScore) {
        this.allScore = allScore;
    }

    public int getScorePlayer() {
        return scorePlayer;
    }

    public void setScorePlayer(int scorePlayer) {
        this.scorePlayer = scorePlayer;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
