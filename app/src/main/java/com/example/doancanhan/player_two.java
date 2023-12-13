package com.example.doancanhan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.doancanhan.databinding.ActivityMainBinding;
import com.example.doancanhan.databinding.ActivityPlayerTwoBinding;


import java.util.Random;

public class player_two extends AppCompatActivity {

    ActivityPlayerTwoBinding mainBinding2;
    private PlayerTwoViewModel viewModel;
    //    public int  currScore2, allScore2, scorePlayer1;
    TextView score2,curr_score2,score_player1,winner;
    Button btnHold2, btnRoll2, btnReset2;
    ImageView img2;
    private static final int REQUEST_CODE_MAIN_TO_ACTIVITY2 = 1;
//    Random rand2;

//    int r2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.another_player);

        mainBinding2 = DataBindingUtil.setContentView(this,R.layout.activity_player_two);
        viewModel = new ViewModelProvider(this).get(PlayerTwoViewModel.class);


        int savedData= viewModel.getSaveData();

        SharedPreferences preferences = getSharedPreferences("scores", MODE_PRIVATE);
        int player1Score = preferences.getInt("player1Score", 0);
        int all2=preferences.getInt("all2",0);
        viewModel.setAllScore2(all2);


        viewModel.setScorePlayer2(player1Score);
        mainBinding2.score2Txt1.setText(""+viewModel.getAllScore2());



        score2 = findViewById(R.id.score2_txt1);
        score_player1=findViewById(R.id.score_player1);
        curr_score2 = findViewById(R.id.currentScore2_txt);
        btnHold2 = findViewById(R.id.hold_button2);
        btnRoll2 = findViewById(R.id.roll_button2);
        img2 = findViewById(R.id.dice_img2);
        btnReset2 = findViewById(R.id.reset_button2);


        btnReset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(player_two.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnRoll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.createRandom2();
                updateUI(viewModel.getR2());
                updateTextView();
                if (viewModel.getR2() == 1) {
                    viewModel.setCurrScore2(0);
                    mainBinding2.currentScore2Txt.setText(""+viewModel.getCurrScore2());

                    //

                openActivity();


                } else {

                    viewModel.setCurrScore2(viewModel.currScore2+= viewModel.getR2());
                    mainBinding2.currentScore2Txt.setText(""+viewModel.getCurrScore2());
                }
            }
        });

        btnHold2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.holdFunc2();
                mainBinding2.currentScore2Txt.setText(""+viewModel.getCurrScore2());
                mainBinding2.score2Txt1.setText(""+viewModel.getAllScore2());

                viewModel.setAllScore2(Integer.parseInt(mainBinding2.score2Txt1.getText().toString()));
                if(viewModel.getAllScore2()>=100) {
                    notiWiner();
                } else
                    openActivity();
            }


        });

    }

    private void notiWiner() {
        btnHold2.setEnabled(false);
        btnRoll2.setEnabled(false);
        mainBinding2.winner2.setText("🎉🎉 Player2 is Winner 🎉🎉");
        mainBinding2.winner2.setShadowLayer(5,2,2, Color.RED);

    }

    private void updateTextView() {

        mainBinding2.score2Txt1.setText(""+viewModel.getAllScore2());
        mainBinding2.currentScore2Txt.setText(""+viewModel.getCurrScore2());
        mainBinding2.scorePlayer1.setText("Player1: "+viewModel.getScorePlayer2());
    }
    private void updateUI(int n) {


        switch(n) {
            case 1:
                img2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                img2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                img2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                img2.setImageResource(R.drawable.dice4);
                break;
            case 5:
                img2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                img2.setImageResource(R.drawable.dice6);
                break;
        }


    }

//    public void sendDataBack() {
//        Intent resultIntent = new Intent();
//        resultIntent.putExtra("passScore",viewModel.getAllScore2());
//        setResult(RESULT_OK, resultIntent);
//        finish();
//    }

    private void openActivity() {SharedPreferences preferences = getSharedPreferences("scores2", MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putInt("player2Score", viewModel.getAllScore2());
    editor.apply();

    viewModel.setSaveData(viewModel.getSaveData()+viewModel.getAllScore2());

    Intent resultIntent = new Intent();
    resultIntent.putExtra("player2Score", viewModel.getSaveData());
    setResult(RESULT_OK, resultIntent);
    finish();
    }






}
