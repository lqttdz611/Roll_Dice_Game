//package com.example.doancanhan;
//
//import androidx.lifecycle.ViewModel;
//
//import java.util.Random;
//
//public class MyViewModel extends ViewModel {
//    public int  currScore=0, allScore=0, scorePlayer=0;
//    public int currScore2=0, allScore2=0, scorePlayer2=0;
//
//    Random rand,rand2;
//    public int r;
//    public int r2;
//
//    public int getShareScore() {
//        return shareScore;
//    }
//
//    public void setShareScore(int shareScore) {
//        this.shareScore = shareScore;
//    }
//
//    public int shareScore;
//
//
//    public int getCurrScore2() {
//        return currScore2;
//    }
//
//    public void setCurrScore2(int currScore2) {
//        this.currScore2 = currScore2;
//    }
//
//    public int getAllScore2() {
//        return allScore2;
//    }
//
//    public void setAllScore2(int allScore2) {
//        this.allScore2 = allScore2;
//    }
//
//    public int getScorePlayer2() {
//        return scorePlayer2;
//    }
//
//    public void setScorePlayer2(int scorePlayer2) {
//        this.scorePlayer2+=allScore2+ scorePlayer2;
//    }
//
//    public int getR2() {
//        return r2;
//    }
//
//    public void setR2(int r2) {
//        this.r2 = r2;
//    }
//
//    public int getCurrScore() {
//        return currScore;
//    }
//
//    public void createRandom() {
//        rand = new Random();
//        r = rand.nextInt(6) + 1;
////                updateUI(r);
////        updateTextView();
//
//    }
//
//    public void createRandom2() {
//        rand2 = new Random();
//        r2 = rand2.nextInt(6)+1;
//    }
//
//    public void holdFunc() {
//        allScore += currScore;
//        currScore=0;
//    }
//
//    public void holdFunc2() {
//        allScore2+= currScore2;
//        currScore2=0;
//    }
//
//    public void setCurrScore(int currScore) {
//        this.currScore = currScore;
//    }
//
//    public int getAllScore() {
//        return allScore;
//    }
//
//    public void setAllScore(int allScore) {
//        this.allScore = allScore;
//    }
//
//    public int getScorePlayer() {
//        return scorePlayer;
//    }
//
//    public void setScorePlayer(int scorePlayer) {
//        this.scorePlayer = scorePlayer;
//    }
//
//    public int getR() {
//        return r;
//    }
//
//    public void setR(int r) {
//        this.r = r;
//    }
//
//}
