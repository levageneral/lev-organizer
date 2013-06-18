package ru.hw_team.lev.model.database.factory;


import android.content.Context;
import com.j256.ormlite.android.apptools.OpenHelperManager;


/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 15.06.13
 */
public class HelperFactory {

    private static DatabaseHelper databaseHelper;

    public synchronized static DatabaseHelper getHelper() {
        return databaseHelper;
    }

    public static void setHelper(Context context) {
        databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
    }

    public static void releaseHelper() {
        OpenHelperManager.releaseHelper();
        databaseHelper = null;
    }
}
