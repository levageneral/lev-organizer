package ru.hw_team.lev.util;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;

import static ru.hw_team.lev.util.AndroidApiVersions.ANDROID_API_VERSION_HONEYCOMB_MR2;

public class DisplayHelper {

    public static final int WIDTH_CELL = 0;

    public static final int HEIGHT_CELL = 1;

    public static final int DISPLAY_SIZE_MASSIVE_CAPACITY = 2;

    public static int dpToPx(int dp) {
        Resources resources = LevApplication.getContext().getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }

    public static int spToPx(int sp) {
        return dpToPx(sp);
    }

    public static Integer[] getDisplaySize(Activity activity) {
        Integer[] sizes = new Integer[DISPLAY_SIZE_MASSIVE_CAPACITY];
        if (Build.VERSION.SDK_INT >= ANDROID_API_VERSION_HONEYCOMB_MR2) {
            Display display = activity.getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            sizes[WIDTH_CELL] = size.x;
            sizes[HEIGHT_CELL] = size.y;
        } else {
            Display display = activity.getWindowManager().getDefaultDisplay();
            sizes[WIDTH_CELL] = display.getWidth();  // deprecated
            sizes[HEIGHT_CELL] = display.getHeight();  // deprecated
        }

        return sizes;
    }
}
