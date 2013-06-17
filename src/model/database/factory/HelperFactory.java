package model.database.factory;


import android.content.Context;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;


/**
 * Created with IntelliJ IDEA.
 * User: general
 * Date: 15.06.13
 * Time: 23:18
 * To change this template use File | Settings | File Templates.
 */
public class HelperFactory {

    private static DatabaseHelper databaseHelper;

    public static DatabaseHelper getHelper(){
        return databaseHelper;
    }

    public static void setHelper(Context context){
        databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
    }
 public static void releaseHelper(){
    OpenHelperManager.releaseHelper();
    databaseHelper = null;
 }
}
