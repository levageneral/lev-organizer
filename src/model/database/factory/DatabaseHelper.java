package model.database.factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.database.dao.ScheduleDAO;
import model.database.dao.TaskDAO;
import model.database.entity.Schedule;
import model.database.entity.Task;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: general
 * Date: 15.06.13
 * Time: 23:27
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String LOG_TAG = DatabaseHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "lev-organizer.db";

    private static final int DATABASE_VERSION = 1;

    private ScheduleDAO scheduleDAO = null;
    private TaskDAO taskDAO = null;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Выполняется когда файл БД не найден на устройстве
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource){
         try
         {
             TableUtils.createTable(connectionSource, Schedule.class);
             TableUtils.createTable(connectionSource, Task.class);
         }
         catch (SQLException e) {
             Log.e(LOG_TAG, "error create DB " + DATABASE_NAME);
             throw  new RuntimeException(e);
         }
    }

    //Виполняется когда версия БД отличается от текущей
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer, int newVer){
        try
        {
          TableUtils.dropTable(connectionSource, Schedule.class, true);
          TableUtils.dropTable(connectionSource, Task.class, true);
          onCreate(db, connectionSource);
        } catch (SQLException e) {
         Log.e(LOG_TAG, "error upgrading DB " + DATABASE_NAME + "from version" + oldVer);
            throw new RuntimeException(e);
        }
    }

    //синголтон для ScheduleDAO
    public ScheduleDAO getScheduleDAO() throws SQLException{
        if (scheduleDAO == null){
            scheduleDAO = new ScheduleDAO(getConnectionSource(), Schedule.class);
        }
        return scheduleDAO;
    }

    //синглотон для TaskDAO
    public  TaskDAO getTaskDAO() throws SQLException{
        if (taskDAO == null){
            taskDAO = new TaskDAO(getConnectionSource(), Task.class);
        }
        return taskDAO;
    }

    //Виполняется при закрытии приложения
    @Override
    public void close(){
        super.close();
        scheduleDAO = null;
        taskDAO = null;
    }
}
























