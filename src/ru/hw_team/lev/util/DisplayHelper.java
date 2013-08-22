package ru.hw_team.lev.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class DisplayHelper {

    public static int dpToPx(int dp) {
        Resources resources = LevApplication.getContext().getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }

    public static int spToPx(int sp) {
        return dpToPx(sp);
    }
}
