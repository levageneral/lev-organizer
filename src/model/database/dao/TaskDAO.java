package model.database.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import model.database.entity.Task;

import java.sql.SQLException;
import java.util.List;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 17.06.13
 */
public class TaskDAO extends BaseDaoImpl<Task, Integer> {

    public TaskDAO(ConnectionSource connectionSource, Class<Task> dataClass) throws SQLException{
        super(connectionSource, dataClass);
    }

    public List<Task> getAllTask() throws SQLException{
        return this.queryForAll();
    }


    public List<Task> getTaskByStatus(Integer status) throws SQLException{
        QueryBuilder<Task, Integer> queryBuilder = queryBuilder();
        queryBuilder.where().eq(Task.TASK_FIELD_STATUS, status);
        PreparedQuery<Task> preparedQuery = queryBuilder.prepare();
        List<Task> taskByStatusList = query(preparedQuery);
        return taskByStatusList;
    }

    public List<Task> getTaskByPriority(Integer priority) throws SQLException{
        QueryBuilder<Task, Integer> queryBuilder = queryBuilder();
        queryBuilder.where().eq(Task.TASK_FIELD_PRIORITY, priority);
        PreparedQuery<Task> preparedQuery = queryBuilder.prepare();
        List<Task> taskByPriorityList = query(preparedQuery);
        return taskByPriorityList;
    }
    }
