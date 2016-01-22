package com.example.adam.buggsbunny;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.adam.buggsbunny.data.Image;
import com.example.adam.buggsbunny.data.ImageAdapter;
import com.example.adam.buggsbunny.net.FetchService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageAdapter adapter;
    private GridView gridView;
    private ArrayList<Image> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.gridView);

        images = conjureImages();
        adapter = new ImageAdapter(this, images);
        gridView.setAdapter(adapter);

        final Activity self = this;
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Image image = images.get(position);
                Intent intent = new Intent(self, ZoomedImage.class);
                Bundle extras = new Bundle();

                extras.putInt("IMAGE_BUNDLE_ID", image.getPictureID());
                extras.putString("NAME_BUNDLE_ID", image.getName());
                intent.putExtras(extras);

                startActivity(intent);
                adapter.notifyDataSetChanged();
            }
        });

        Intent intent = new Intent(this, FetchService.class);
        this.startService(intent);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncTask fetchTask = new AsyncTask() {
                    @Override
                    protected Object doInBackground(Object[] params) {
                        System.out.println("Fetch more images");
                        return null;
                    }
                };
                fetchTask.execute();
            }
        });
    }

    private ArrayList<Image> conjureImages() {
        ArrayList<Image> images = new ArrayList<>();

        for(int i=0; i<30; i++) {
            images.add(new Image());
        }

        return images;
    }
}
