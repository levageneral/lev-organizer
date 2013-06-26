package ru.hw_team.lev.model.database.entity;

import android.util.Log;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 15.06.13
 */

@DatabaseTable(tableName = "task")
public class Task {

    public final static String TASK_FIELD_ID = "_id";
    public final static String TASK_FIELD_DESCRIPTION = "description";
    public final static String TASK_FIELD_TITLE = "title";
    public final static String TASK_FIELD_DATE = "date";
    public final static String TASK_FIELD_STATUS = "status";
    public final static String TASK_FIELD_PRIORITY = "priority";
    private static final String LOG_TAG = "myLogs";

    @DatabaseField(generatedId = true, columnName = TASK_FIELD_ID)
    private int id;

    @DatabaseField(dataType = DataType.STRING, columnName = TASK_FIELD_DESCRIPTION)
    private String description;

    @DatabaseField(dataType = DataType.STRING, columnName = TASK_FIELD_TITLE)
    private String title;

    @DatabaseField(dataType = DataType.DATE, columnName = TASK_FIELD_DATE)
    private Date date;

    @DatabaseField(dataType = DataType.INTEGER, columnName = TASK_FIELD_STATUS)
    private int status;

    @DatabaseField(dataType = DataType.INTEGER, columnName = TASK_FIELD_PRIORITY)
    private int priority;


    public Task() {

    }

    public Task(int id, String description, String title, Date date, int status, int priority) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.date = date;
        this.status = status;
        this.priority = priority;
        Log.e(LOG_TAG, "LOG Message constructor Task()");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
