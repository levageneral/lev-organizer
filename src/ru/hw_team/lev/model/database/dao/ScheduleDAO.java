package ru.hw_team.lev.model.database.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import ru.hw_team.lev.model.database.entity.Schedule;

import java.sql.SQLException;
import java.util.List;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 16.06.13
 */
public class ScheduleDAO extends BaseDaoImpl<Schedule, Integer> {

    public ScheduleDAO(ConnectionSource connectionSource, Class<Schedule> dataClass) throws SQLException{
        super(connectionSource, dataClass);

    }

    public List<Schedule> getAllSchedule() throws SQLException{
        return this.queryForAll();
    }
}
