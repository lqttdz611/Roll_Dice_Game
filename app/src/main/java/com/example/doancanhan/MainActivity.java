package com.example.doancanhan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doancanhan.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mainBinding;

    TextView score,curr_score,score_player2;
    Button btnHold, btnRoll, btnReset;
    ImageView img;
    Random rand;
    int r;
    private MainViewModel viewModel;

    private static final int REQUEST_CODE_ACTIVITY2 = 1;
    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);



        img = findViewById(R.id.dice_img);
        score = findViewById(R.id.score1_txt);
        curr_score = findViewById(R.id.currentScore_txt);
        btnHold = findViewById(R.id.hold_button);
        btnRoll = findViewById(R.id.roll_button);
        btnReset = findViewById(R.id.reset_button);
        score_player2 = findViewById(R.id.score_player2);





        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.createRandom();
                updateUI(viewModel.getR());
                updateTextView();
                if (viewModel.getR() == 1) {
                    viewModel.setCurrScore(0);
//
                    mainBinding.currentScoreTxt.setText(""+viewModel.getCurrScore());
                    //
                    viewModel.setAllScore(Integer.parseInt(mainBinding.score1Txt.getText().toString()));

                    openActivity();


                } else {
                    viewModel.setCurrScore(viewModel.currScore+= viewModel.getR());
                    mainBinding.currentScoreTxt.setText(""+viewModel.getCurrScore());

                }
            }
        });


       

        btnHold.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SuspiciousIndentation")
            @Override
            public void onClick(View v) {


                viewModel.holdFunc();
                mainBinding.currentScoreTxt.setText(""+viewModel.getCurrScore());
                mainBinding.score1Txt.setText(""+viewModel.getAllScore());
                //
                viewModel.setAllScore(Integer.parseInt(mainBinding.score1Txt.getText().toString()));
                if(viewModel.getAllScore()>=50) {
                    notiWiner();
                } else
                openActivity();
            }

        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ACTIVITY2 && resultCode == RESULT_OK) {
            SharedPreferences preferences = getSharedPreferences("scores2", MODE_PRIVATE);
            int player2Score = preferences.getInt("player2Score", 0);

            viewModel.setScorePlayer(player2Score);

            updateTextView();
        }
    }


    public void notiWiner() {
            btnHold.setEnabled(false);
            btnRoll.setEnabled(false);
            mainBinding.winner.setText("🎉🎉 Player1 is Winner 🎉🎉");
            mainBinding.winner.setShadowLayer(5,2,2, Color.RED);


    }

    private void updateTextView() {

        mainBinding.score1Txt.setText(""+viewModel.getAllScore());
        mainBinding.currentScoreTxt.setText(""+viewModel.getCurrScore());
        mainBinding.scorePlayer2.setText("Player 2: "+viewModel.getScorePlayer());
    }

    private void updateUI(int n) {

            switch(n) {
                case 1:
                    img.setImageResource(R.drawable.img1);
                    break;
                case 2:
                    img.setImageResource(R.drawable.img2);
                    break;
                case 3:
                    img.setImageResource(R.drawable.img3);
                    break;
                case 4:
                    img.setImageResource(R.drawable.img4);
                    break;
                case 5:
                    img.setImageResource(R.drawable.img5);
                    break;
                case 6:
                    img.setImageResource(R.drawable.img6);
                    break;
            }
        }

    private void openActivity() {
        SharedPreferences preferences = getSharedPreferences("scores", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("player1Score", viewModel.getAllScore());
        editor.putInt("all2",viewModel.getScorePlayer());
        editor.apply();
        Intent intent = new Intent(MainActivity.this, player_two.class);


        startActivityForResult(intent, REQUEST_CODE_ACTIVITY2);
    }


}

