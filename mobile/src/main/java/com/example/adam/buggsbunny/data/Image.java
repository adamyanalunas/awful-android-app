package com.example.adam.buggsbunny.data;

import com.example.adam.buggsbunny.R;

import java.util.Random;

/**
 * Created by adam on 1/21/16.
 */
public class Image {

    private String name;
    private int pictureId;
    private Boolean hasBeenSeen = false;

    public Image() {
        pictureId = randomThumbID();
        name = randomName();
    }

    public String getName() { return name; }
    public int getPictureID() { return pictureId; }

    public Boolean getSeen() { return hasBeenSeen; }
    public void setSeen(Boolean hasSeen) { hasBeenSeen = hasSeen; }

    public String randomName() {
        Random r = new Random();
        return  names[r.nextInt(names.length)];
    }

    public Integer randomThumbID() {
        Random r = new Random();
        return thumbIds[r.nextInt(thumbIds.length)];
    }

    private String[] names = {
            "Rocky", "Han", "Luke", "Arin", "Danny",
            "Pete", "Brian", "Ben", "Sage", "Jess",
            "Megan", "Lucy", "Suzette", "Trisha",
            "Hank", "Henk", "Lorde", "Devin", "Tosin"
    };

    private int[] thumbIds = {
            R.drawable.planet1,
            R.drawable.planet2,
            R.drawable.planet3,
            R.drawable.planet4,
            R.drawable.space1,
            R.drawable.space2,
            R.drawable.space3,
            R.drawable.space4,
            R.drawable.space5,
            R.drawable.space6,
            R.drawable.space7,
            R.drawable.space8
    };
}
