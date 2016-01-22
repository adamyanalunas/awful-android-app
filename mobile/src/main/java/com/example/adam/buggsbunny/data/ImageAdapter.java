package com.example.adam.buggsbunny.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adam.buggsbunny.R;

import java.util.ArrayList;

/**
 * Created by adam on 1/21/16.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Image> images;
    private final LayoutInflater inflater;


    public ImageAdapter(Context c, ArrayList<Image> images) {
        this.inflater = LayoutInflater.from(c);
        this.context = c;
        this.images = images;
    }

    public int getCount() {
        return images.size();
    }

    public Image getItem(int position) {
        return images.get(position);
    }

    public long getItemId(int position) {
        return images.get(position).getPictureID();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextView name;

        if (convertView == null) {
            v = inflater.inflate(R.layout.grid_item, parent, false);
            v.setTag(R.id.cover_image, v.findViewById(R.id.cover_image));
            v.setTag(R.id.title, v.findViewById(R.id.title));
        }

        name = (TextView) v.getTag(R.id.title);

        Image image = getItem(position);
        name.setText(image.getName());

        return v;
    }
}
