package ru.hw_team.lev.model.loaders;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;


public class InterestedConfigChanges {
    final Configuration mLastConfiguration = new Configuration();

    int mLastDensity;

    boolean applyNewConfig(Resources pResources) {
        int configChanges = mLastConfiguration.updateFrom(pResources.getConfiguration());
        boolean densityChanged = mLastDensity != pResources.getDisplayMetrics().densityDpi;
        if (densityChanged || (configChanges & (ActivityInfo.CONFIG_LOCALE
                | ActivityInfo.CONFIG_UI_MODE | ActivityInfo.CONFIG_SCREEN_LAYOUT)) != 0) {
            mLastDensity = pResources.getDisplayMetrics().densityDpi;
            return true;
        }
        return false;
    }
}
