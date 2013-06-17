package model.database.factory;

import android.app.Application;

/**
 * Created with IntelliJ IDEA.
 * User: general
 * Date: 15.06.13
 * Time: 23:45
 * To change this template use File | Settings | File Templates.
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
