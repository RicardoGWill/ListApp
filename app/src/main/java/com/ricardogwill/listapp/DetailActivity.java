package com.ricardogwill.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Gets the intent from the MainActivity. (Note that "-1" is the default value "case" that deals with the "switch" statement below.)
        Intent in = getIntent();
        int index = in.getIntExtra("ricardogwill.com.ITEM_INDEX", -1);
        // This uses the method "getImg()" below. (Cases 0~2.)
        if (index > -1) {
            int pic = getImg(index);
            ImageView img = (ImageView) findViewById(R.id.changing_image_view);
            // Method from below called, which scales the image.
            scaleImg(img, pic);
        }
    }

    // Method to display the appropriate image.
    private int getImg(int index) {
        switch (index) {
            case 0: return R.drawable.peach;
            case 1: return R.drawable.tomato;
            case 2: return R.drawable.squash;
            default: return -1;
        }
    }

    // Scales (only shrinks down) the larger images so their width equals that of the screen.
    private void scaleImg(ImageView img, int pic) {

        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round((float) imgWidth / (float) screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
    }

}
