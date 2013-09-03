package ru.hw_team.lev.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.danikula.aibolit.Aibolit;
import com.danikula.aibolit.annotation.InjectOnClickListener;
import com.danikula.aibolit.annotation.InjectView;
import ru.hw_team.lev.model.database.entity.Schedule;
import ru.hw_team.lev.model.database.factory.HelperFactory;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: general
 * Email: im-leva@yandex.ru
 * Date: 18.08.13
 */
public class ScheduleAddActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    static final int DIALOG_DATE_START = 0;
    static final int DIALOG_TIME_START = 1;
    static final int DIALOG_DATE_END = 2;
    static final int DIALOG_TIME_END = 3;

    @InjectView(R.id.scheduleDescriptionEt)
    private EditText etDes;

    @InjectView(R.id.scheduleTitleEt)
    private EditText etTitle;

    @InjectView(R.id.scheduleDateStartInfoTv)
    private TextView tvDateStart;

    @InjectView(R.id.scheduleTimeStartInfoTv)
    private TextView tvTimeStart;

    @InjectView(R.id.scheduleDateEndInfoTv)
    private TextView tvDateEnd;

    @InjectView(R.id.scheduleTimeEndInfoTv)
    private TextView tvTimeEnd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_add_activity);
        Aibolit.doInjections(this);
       defaultDateTime();
    }

    private void defaultDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dateStr = dateFormat.format(date);
        tvDateStart.setText(dateStr);
        tvDateEnd.setText(dateStr);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date time = new Date();
        String timeStr = timeFormat.format(time);
        tvTimeStart.setText(timeStr);
        tvTimeEnd.setText(timeStr);
    }

    @InjectOnClickListener(R.id.scheduleDateStartInfoTv)
    private void onScheduleDateStartInfoTv(View v) {
       showDialog(DIALOG_DATE_START);
    }

    @InjectOnClickListener(R.id.scheduleTimeStartInfoTv)
    private void onScheduleTimeStartInfoTv(View v) {
       showDialog(DIALOG_TIME_START);
    }

    @InjectOnClickListener(R.id.scheduleDateEndInfoTv)
    private void onScheduleDateEndInfoTv(View v) {
       showDialog(DIALOG_DATE_END);
    }

    @InjectOnClickListener(R.id.scheduleTimeEndInfoTv)
    private void onScheduleTimeEndInfoTv(View v) {
       showDialog(DIALOG_TIME_END);
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        Date yearDate = new Date();
        int Year = Integer.parseInt(yearFormat.format(yearDate));

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        Date monthDate = new Date();
        int  Month = Integer.parseInt(monthFormat.format(monthDate));
        Month--;

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        Date dayDate = new Date();
        int Day = Integer.parseInt(dayFormat.format(dayDate));


        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        Date hourDate = new Date();
        int Hour = Integer.parseInt(hourFormat.format(hourDate));

        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
        Date minuteDate = new Date();
        int Minute = Integer.parseInt(minuteFormat.format(minuteDate));

        switch(id){
            case DIALOG_DATE_START:
                return new DatePickerDialog(this, CallBackDateStart, Year, Month, Day);
            case DIALOG_TIME_START:
                return new TimePickerDialog(this, CallBackTimeStart, Hour, Minute, true);
            case DIALOG_DATE_END:
                return new DatePickerDialog(this, CallBackDateEnd, Year, Month, Day);
            case DIALOG_TIME_END:
                return new TimePickerDialog(this, CallBackTimeEnd, Hour, Minute, true);
        }
        return null;
    }



    public DatePickerDialog.OnDateSetListener CallBackDateStart = new DatePickerDialog.OnDateSetListener() {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        Date yearDate = new Date();
        int Year = Integer.parseInt(yearFormat.format(yearDate));

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        Date monthDate = new Date();
        int  Month = Integer.parseInt(monthFormat.format(monthDate));

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        Date dayDate = new Date();
        int Day = Integer.parseInt(dayFormat.format(dayDate));

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Year = year;
            Month = monthOfYear + 1;
            Day = dayOfMonth;
            tvDateStart.setText(Year  + "/" + Month + "/" + Day);

        }
    };


    TimePickerDialog.OnTimeSetListener CallBackTimeStart = new TimePickerDialog.OnTimeSetListener() {
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        Date hourDate = new Date();
        int Hour = Integer.parseInt(hourFormat.format(hourDate));

        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
        Date minuteDate = new Date();
        int Minute = Integer.parseInt(minuteFormat.format(minuteDate));

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Hour = hourOfDay;
            Minute = minute;
            tvTimeStart.setText(Hour + ":" + Minute);
        }
    };



    public DatePickerDialog.OnDateSetListener CallBackDateEnd = new DatePickerDialog.OnDateSetListener() {

        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        Date yearDate = new Date();
        int Year = Integer.parseInt(yearFormat.format(yearDate));

        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        Date monthDate = new Date();
        int  Month = Integer.parseInt(monthFormat.format(monthDate));

        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        Date dayDate = new Date();
        int Day = Integer.parseInt(dayFormat.format(dayDate));

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Year = year;
            Month = monthOfYear + 1;
            Day = dayOfMonth;
            tvDateEnd.setText(Year  + "/" + Month + "/" + Day);

        }
    };

    TimePickerDialog.OnTimeSetListener CallBackTimeEnd = new TimePickerDialog.OnTimeSetListener() {
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        Date hourDate = new Date();
        int Hour = Integer.parseInt(hourFormat.format(hourDate));

        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
        Date minuteDate = new Date();
        int Minute = Integer.parseInt(minuteFormat.format(minuteDate));

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Hour = hourOfDay;
            Minute = minute;
            tvTimeEnd.setText(Hour + ":" + Minute);
        }
    };





    @InjectOnClickListener(R.id.btnScheduleCancel)
    private void onBtnScheduleCancelClick(View v) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
    }

    @InjectOnClickListener(R.id.btnScheduleAdd)
    private void onBtnScheduleAddClick(View v) {
         String description = etDes.getText().toString();
         String title = etTitle.getText().toString();
        String dateStr = tvDateStart.getText().toString();
         Date dateStart = new Date();
         Date dateEnd = new Date();
        if (description.equals("") || title.equals(""))
        {
            Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show();
        }
        else
        {
            Log.d(TAG, "LOG Message onClick description: " + description);
            Log.d(TAG, "LOG Message onClick title: " + title);
            Log.d(TAG, "LOG Message onClick dateStart: " + dateStart);
            Log.d(TAG, "LOG Message onClick dateStart: " + dateEnd);
            Schedule schedule = new Schedule(0, description, title, dateStart, dateEnd);
            try {
                HelperFactory.getHelper().getScheduleDAO().createSchedule(schedule);
                Log.d(TAG, "HelperFactory.getHelper.getScheduleDAO.createSchedule(schedule)");
            } catch (SQLException e) {
                 e.printStackTrace();
                Log.e(TAG, "catch SQLException");
            }
        Toast.makeText(this, "New Schedule was Add", Toast.LENGTH_LONG).show();
        }

    }

}
