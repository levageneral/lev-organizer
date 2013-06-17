package model.database.entity;

/**
 * Created with IntelliJ IDEA.
 * User: general
 * Date: 15.06.13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DataType;

import java.util.Date;

@DatabaseTable(tableName = "schedule")

public class Schedule{

    public final static String SCHEDULE_FIELD_ID = "_id";
    public final static String SCHEDULE_FIELD_DESCRIPTION = "description";
    public final static String SCHEDULE_FIELD_TITLE = "title";
    public final static String SCHEDULE_FIELD_DATE_START = "date_start";
    public final static String SCHEDULE_FIELD_DATE_END = "date_end";



    @DatabaseField(generatedId = true, columnName = SCHEDULE_FIELD_ID)
    private int id;

    @DatabaseField(dataType = DataType.STRING, columnName = SCHEDULE_FIELD_DESCRIPTION)
    private String description;

    @DatabaseField(dataType = DataType.STRING, columnName = SCHEDULE_FIELD_TITLE)
    private  String title;

    @DatabaseField(dataType = DataType.DATE, columnName = SCHEDULE_FIELD_DATE_START)
    private Date date_start;

    @DatabaseField(dataType = DataType.DATE, columnName = SCHEDULE_FIELD_DATE_END)
    private Date date_end;

    public Schedule(){

    }

    public Schedule(int id, String description, String title, Date date_start, Date date_end){
     this.id = id;
     this.description = description;
     this.title = title;
     this.date_start = date_start;
     this.date_end = date_end;
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

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public Date getDate_end() {
        return date_end;
    }
}
