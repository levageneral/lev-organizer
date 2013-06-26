package ru.hw_team.lev.model.database.factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import ru.hw_team.lev.model.database.dao.ScheduleDAO;
import ru.hw_team.lev.model.database.dao.TaskDAO;
import ru.hw_team.lev.model.database.entity.Schedule;
import ru.hw_team.lev.model.database.entity.Task;

import java.sql.SQLException;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 15.06.13
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "lev-organizer.db";

    private static final int DATABASE_VERSION = 1;

    private ScheduleDAO scheduleDAO = null;
    private TaskDAO taskDAO = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Schedule.class);
            TableUtils.createTable(connectionSource, Task.class);
            Log.e(TAG, "create DB on DatabaseHelper" + DATABASE_NAME);
        } catch (SQLException e) {
            Log.e(TAG, "error create DB " + DATABASE_NAME);
            throw new RuntimeException(e);
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer, int newVer) {
        try {
            TableUtils.dropTable(connectionSource, Schedule.class, true);
            TableUtils.dropTable(connectionSource, Task.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(TAG, "error upgrading DB " + DATABASE_NAME + "from version" + oldVer);
            throw new RuntimeException(e);
        }
    }


    public ScheduleDAO getScheduleDAO() throws SQLException {
        if (scheduleDAO == null) {
            scheduleDAO = new ScheduleDAO(getConnectionSource(), Schedule.class);
        }
        return scheduleDAO;
    }


    public TaskDAO getTaskDAO() throws SQLException {
        if (taskDAO == null) {
           taskDAO = new TaskDAO(getConnectionSource(), Task.class);
        }
        return taskDAO;
    }


    @Override
    public void close() {
        super.close();
        scheduleDAO = null;
        taskDAO = null;
    }
}
























