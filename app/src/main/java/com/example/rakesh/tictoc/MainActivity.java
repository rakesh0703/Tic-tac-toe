package com.example.rakesh.tictoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void singleplayer(View view) {
        Intent intent1 = new Intent(this,SinglePlayer.class);
        startActivity(intent1);
    }

    public void multiplayer(View view) {
        Intent intent2 = new Intent(this,MultiPlayer.class);
        startActivity(intent2);
    }

    public void exit(View view) {
        finish();
    }
}
