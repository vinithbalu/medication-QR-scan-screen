package com.example.medicationqrscan;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.WriterException;
import androidx.appcompat.app.AppCompatActivity;
import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import com.google.android.material.textfield.TextInputEditText;


public class GenerateQRcodeActivity extends AppCompatActivity {
    private TextView QRCodeTV;
    private ImageView QRCodeIV;
    private TextInputEditText dataEdt;
    private Button GenerateQRbtn;
    private QRGEncoder qrgEncoder;
    private Bitmap bitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qrcode);
        QRCodeTV = findViewById(R.id.idTVGeneratorQRCode);
        QRCodeIV = findViewById(R.id.idIVQRCode);
        dataEdt = findViewById(R.id.idEdtData);
        GenerateQRbtn = findViewById(R.id.idBtnGeneratorQR);
        GenerateQRbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = dataEdt.getText().toString();
                if(data.isEmpty()){
                    Toast.makeText(GenerateQRcodeActivity.this, "please enter some data to Generate QR code", Toast.LENGTH_SHORT).show();
                }else {
                    WindowManager Manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                    Display display = getWindowManager().getDefaultDisplay();
                     Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                    int height = point.y;
                    int dimen = width<height ? width:height;
                    dimen = dimen * 3/4;

                    qrgEncoder = new QRGEncoder(dataEdt.getText().toString(), null, QRGContents.Type.TEXT, dimen);
                    try {
                        bitmap = qrgEncoder.encodeAsBitmap();
                        QRCodeTV.setVisibility(View.GONE);
                        QRCodeIV.setImageBitmap(bitmap);


                    }catch (WriterException e){
                        e.printStackTrace();
                        System.out.println("Error "+ e.toString());
                    }


                }
            }
        });
    }
}