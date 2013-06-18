package ru.hw_team.lev.model.database.entity;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 17.06.13
 */

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "schedule")

public class Schedule{

    public final static String SCHEDULE_FIELD_ID = "_id";
    public final static String SCHEDULE_FIELD_DESCRIPTION = "description";
    public final static String SCHEDULE_FIELD_TITLE = "title";
    public final static String SCHEDULE_FIELD_DATE_START = "dateStart";
    public final static String SCHEDULE_FIELD_DATE_END = "dateEnd";



    @DatabaseField(generatedId = true, columnName = SCHEDULE_FIELD_ID)
    private int id;

    @DatabaseField(dataType = DataType.STRING, columnName = SCHEDULE_FIELD_DESCRIPTION)
    private String description;

    @DatabaseField(dataType = DataType.STRING, columnName = SCHEDULE_FIELD_TITLE)
    private  String title;

    @DatabaseField(dataType = DataType.DATE, columnName = SCHEDULE_FIELD_DATE_START)
    private Date dateStart;

    @DatabaseField(dataType = DataType.DATE, columnName = SCHEDULE_FIELD_DATE_END)
    private Date dateEnd;

    public Schedule(){

    }

    public Schedule(int id, String description, String title, Date dateStart, Date dateEnd){
     this.id = id;
     this.description = description;
     this.title = title;
     this.dateStart = dateStart;
     this.dateEnd = dateEnd;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateEnd() {
        return dateEnd;
    }
}
