package ru.hw_team.lev.util;

import android.app.Application;
import ru.hw_team.lev.model.database.factory.HelperFactory;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 15.06.13
 */
public class LevApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HelperFactory.setHelper(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        HelperFactory.releaseHelper();
        super.onTerminate();
    }
}
