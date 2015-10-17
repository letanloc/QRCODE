package com.loc.createqrcodeexample;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

public class CReateQrcode extends AppCompatActivity implements View.OnClickListener {
    private String LOG_TAG = "GenerateQRCode";
    ImageView myImage;
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qrcode);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    ImageView userLogo;

    public void CallView() {
        EditText qrInput = (EditText) findViewById(R.id.qrInput);
        container = (FrameLayout) findViewById(R.id.container);
        userLogo = (ImageView) findViewById(R.id.imageView);
        String qrInputText = qrInput.getText().toString();
        Log.v(LOG_TAG, qrInputText);
        myImage = (ImageView) findViewById(R.id.imageView1);
        userLogo.setVisibility(View.GONE);
        //Find screen size
        //
        WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        // khowit tạo pin  hienj cacs ddieemr
        Point point = new Point();
        display.getSize(point);
        int width = point.x;
        int height = point.y;
        //
        // tạo kích thuocw
        int smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3 / 4;

        //Encode with a QR Code image
        // gọi qrcode

        ///  truyền cái chuôi text đó vào và
        QRCodeEncoder qrCodeEncoder = new QRCodeEncoder(qrInputText,
                null,
                // đây là kieur tryển vào
                Contents.Type.TEXT,

                BarcodeFormat.QR_CODE.toString(),
                smallerDimension);
        try {
            Bitmap bitmap = qrCodeEncoder.encodeAsBitmap();
            Toast.makeText(CReateQrcode.this, "" + qrCodeEncoder.getContents(), Toast.LENGTH_SHORT).show();
            qrCodeEncoder.getContents();
            userLogo.setVisibility(View.VISIBLE);
            myImage.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                CallView();
                break;
        }
    }
}
