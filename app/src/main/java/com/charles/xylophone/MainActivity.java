package com.charles.xylophone;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.charles.xylophone.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Variables
    private ActivityMainBinding binding;
    private MediaPlayer mediaPlayer;

    //Views

    //Libraries

    //Animations

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Change status bar background color
        getWindow().setStatusBarColor(getResources().getColor(R.color.red_shade));
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initialize();

    }

    private void initialize() {
        binding.amDoButton.setOnClickListener(v -> playSound(R.raw.note1));
        binding.amReButton.setOnClickListener(v -> playSound(R.raw.note2));
        binding.amMiButton.setOnClickListener(v -> playSound(R.raw.note3));
        binding.amFaButton.setOnClickListener(v -> playSound(R.raw.note4));
        binding.amSoButton.setOnClickListener(v -> playSound(R.raw.note5));
        binding.amLaButton.setOnClickListener(v -> playSound(R.raw.note6));
        binding.amTiButton.setOnClickListener(v -> playSound(R.raw.note7));
    }

    private void playSound(int soundResourceID) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(MainActivity.this, soundResourceID);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}