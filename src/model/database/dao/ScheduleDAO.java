package model.database.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import model.database.entity.Schedule;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: general
 * Date: 16.06.13
 * Time: 0:11
 * To change this template use File | Settings | File Templates.
 */
public class ScheduleDAO extends BaseDaoImpl<Schedule, Integer> {

    public ScheduleDAO(ConnectionSource connectionSource, Class<Schedule> dataClass) throws SQLException{
        super(connectionSource, dataClass);
        //To change body of created methods use File | Settings | File Templates.
    }

    public List<Schedule> getAllSchedule() throws SQLException{
        return this.queryForAll();
    }
}
