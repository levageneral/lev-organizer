package ru.hw_team.lev.model.database.factory;

import android.app.Application;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 15.06.13
 */
public class MyAplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        HelperFactory.setHelper(getApplicationContext());
    }

    @Override
    public void onTerminate(){
        HelperFactory.releaseHelper();
        super.onTerminate();
    }
}
