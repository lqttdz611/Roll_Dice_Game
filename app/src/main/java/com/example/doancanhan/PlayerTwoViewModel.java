package com.example.doancanhan;

import androidx.lifecycle.ViewModel;

import java.util.Random;

public class PlayerTwoViewModel extends ViewModel {


    public int currScore2=0, allScore2=0, scorePlayer2=0;
    Random rand2;


    public void setSaveData(int saveData) {
        this.saveData = saveData;
    }

    public int r2;
    private int saveData;

    public void saveDataBeforeFinish() {
        saveData = allScore2;
    }

    public int getSaveData() {
        return saveData;
    }

    public void createRandom2() {
        rand2 = new Random();
        r2 = rand2.nextInt(6)+1;
    }

    public void holdFunc2() {
        allScore2+= currScore2;
        currScore2=0;
    }

    public int getCurrScore2() {
        return currScore2;
    }

    public void setCurrScore2(int currScore2) {
        this.currScore2 = currScore2;
    }

    public int getAllScore2() {
        return allScore2;
    }

    public void setAllScore2(int allScore2) {
        this.allScore2 = allScore2;
    }

    public int getScorePlayer2() {
        return scorePlayer2;
    }

    public void setScorePlayer2(int scorePlayer2) {
        this.scorePlayer2 = scorePlayer2;
    }

    public int getR2() {
        return r2;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }
}
