package com.loc.createqrcodeexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout contai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contai = (LinearLayout) findViewById(R.id.contai);
        View();

    }

    public Button bindButton(int Id) {


        return (Button) findViewById(Id);

    }

    Button createQR, readQR;

    public void View() {
        createQR = bindButton(R.id.btnCreate);
        readQR = bindButton(R.id.readQr);
        createQR.setOnClickListener(this);
        readQR.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:
                startActivity(new Intent(MainActivity.this, CReateQrcode.class));
                break;
            case R.id.readQr:
                startActivity(new Intent(MainActivity.this, ReadQrcode.class));
                break;
        }

    }
}
