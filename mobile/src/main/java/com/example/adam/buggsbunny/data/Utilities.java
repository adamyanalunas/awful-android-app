package com.example.adam.buggsbunny.data;

import android.content.Context;

/**
 * Created by adam on 1/21/16.
 */
public class Utilities {
    public static int dpToPx(Context context, int dp)
    {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float)dp * density);
    }
}
