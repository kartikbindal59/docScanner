package com.example.librarytrial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.labters.documentscanner.ImageCropActivity;
import com.labters.documentscanner.helpers.ScannerConstants;

public class MainActivity extends AppCompatActivity {


    private int ProcessRequestCode =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bitmap bmp = BitmapFactory.decodeResource(this.getResources(), R.drawable.doc3);
        ScannerConstants.selectedImageBitmap = Bitmap.createScaledBitmap(bmp, bmp.getWidth() / 4, bmp.getHeight() / 4, false);
        startActivityForResult(new Intent(this, ImageCropActivity.class), ProcessRequestCode);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ProcessRequestCode && resultCode == Activity.RESULT_OK) {
            if (ScannerConstants.selectedImageBitmap != null) {
                Bitmap result = ScannerConstants.selectedImageBitmap;
            } else {
                finish();
            }
        } else if (requestCode == ProcessRequestCode) {
            finish();
        }
    }
}