package com.example.medicationqrscan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button generateQRbtn,ScanQRbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        generateQRbtn = findViewById(R.id.idBtnGeneratorQR);
        ScanQRbtn = findViewById(R.id.idBtnScanQR);
        generateQRbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomeActivity.this,GenerateQRcodeActivity.class);
                startActivity(i);

            }
        });
        ScanQRbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HomeActivity.this,ScanQRcodeActivity.class);
                startActivity(i);
            }
        });
    }
}