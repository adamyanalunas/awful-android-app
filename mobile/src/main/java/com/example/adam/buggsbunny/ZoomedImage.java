package com.example.adam.buggsbunny;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ZoomedImage extends AppCompatActivity {

    private ImageView imageView;
    private TextView mNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_zoomed_image);
        Bundle extras = getIntent().getExtras();

        imageView = (ImageView) findViewById(R.id.image_view);
        int imageID = extras.getInt("IMAGE_BUNDLE_ID");
        Picasso.with(getBaseContext())
                .load(imageID)
                .into(imageView);


        mNameTextView = (TextView) findViewById(R.id.image_text);
        String name = extras.getString("NAME_BUNDLE_ID");
        mNameTextView.setText(name);
    }
}
